package itaf.framework.web.platform.action;

import itaf.framework.business.common.service.IBzAttachmentService;
import itaf.framework.business.platform.service.ISysAttachmentService;
import itaf.framework.core.util.StringHelper;
import itaf.framework.domain.common.BzAttachment;
import itaf.framework.domain.platform.SysAttachment;
import itaf.framework.web.base.action.AbstractPageAction;
import itaf.framework.web.util.ProcessQueryUtil;
import itaf.framework.workflow.service.AttachmentTaskService;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.richfaces.event.FileUploadEvent;
import org.richfaces.model.UploadedFile;

/**
 * 附件信息,如果是URL访问，可以带参数formId,acceptedTypes和maxFilesQuantity
 * 
 * @author XINXIN
 * 
 */
@ManagedBean(name = "attachmentAction")
@ViewScoped
public class AttachmentAction extends AbstractPageAction {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{sysAttachmentServiceImpl}")
	private ISysAttachmentService sysAttachmentService;

	@ManagedProperty(value = "#{attachmentTaskServiceImpl}")
	private AttachmentTaskService attachmentTaskService;

	@ManagedProperty(value = "#{bzAttachmentServiceImpl}")
	private IBzAttachmentService bzAttachmentService;

	// 任务ID
	private String taskId;
	// 文件支持的格式
	private String acceptedTypes;
	// 单次可以上传的文件个数
	private int maxFilesQuantity;
	// 附件列表
	private List<SysAttachment> attachments;
	// js回调的方法名字
	private String jsCallback;
	// 上传成功后的附件Id
	private String attachIds = "";
	private String attachNames = "";
	// 1为是(默认)，非1为否
	private String isTempFile = "1";

	public AttachmentTaskService getAttachmentTaskService() {
		return attachmentTaskService;
	}

	public void setAttachmentTaskService(
			AttachmentTaskService attachmentTaskService) {
		this.attachmentTaskService = attachmentTaskService;
	}

	public IBzAttachmentService getBzAttachmentService() {
		return bzAttachmentService;
	}

	public void setBzAttachmentService(IBzAttachmentService bzAttachmentService) {
		this.bzAttachmentService = bzAttachmentService;
	}

	// 附件上传
	public void upload(FileUploadEvent event) {
		// 上传项，item里封装了上传文件的所有数据，同时包含HTTP数据
		UploadedFile item = event.getUploadedFile();
		if (item.getSize() == 0) {
			this.setActionMsg("不能上传空文件！");
			return;
		}

		// 解码文件名，当文件命中有中文等其他字符时，你必须这么做
		String srcFileName = "";
		try {
			srcFileName = URLDecoder.decode(item.getName(), "utf-8");
			int p = srcFileName.lastIndexOf("\\");
			if (p > -1) {
				srcFileName = srcFileName.substring(p);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			this.getLog().error(e.getMessage(), e);
		}
		// 判断文件名是否为空
		SysAttachment attachment = new SysAttachment();
		int i = srcFileName.lastIndexOf(".");
		if (i < 0) {
			return;
		}
		// 文件名
		attachment.setSrcFileName(srcFileName.substring(0, i));
		// 扩展名
		String fileExt = srcFileName.substring(i + 1, srcFileName.length());
		attachment.setFileExt(fileExt);
		// 生成文件名
		String fileName = sysAttachmentService.generateUniqueFileName(1L,
				fileExt);
		attachment.setFileName(fileName);
		attachment.setFileType(1L);
		attachment.setMarkForDelete("1".equals(isTempFile));
		// URL
		String fileFullPath = sysAttachmentService.getAbsolutePath(fileName,
				fileExt);
		// 写入
		File newFile = new File(fileFullPath);
		if (newFile.exists()) {
			try {
				saveToFile(item.getInputStream(), newFile);
			} catch (Exception e) {
				e.printStackTrace();
				this.getLog().error("附件上传失败！", e);
			}
		}

		sysAttachmentService.doSaveOrUpdate(attachment);

		if (attachment != null && attachment.getId() != null) {
			if (StringHelper.isEmpty(attachIds)) {
				attachIds = attachment.getId() + "";
				attachNames = attachment.getSrcFileName() + "."
						+ attachment.getFileExt() + "";
			} else {
				attachIds += "," + attachment.getId();
				attachNames += "," + attachment.getSrcFileName() + "."
						+ attachment.getFileExt();
			}
		}
		// 工作流使用
		String taskId = ProcessQueryUtil.getValueOfForm("taskId");
		if (StringHelper.isNotEmpty(taskId)) {
			bzAttachmentService.doSaveContact(taskId, attachment.getId());
		}
	}

	private boolean saveToFile(InputStream inputStream, File file) {
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		boolean result = false;
		try {
			byte[] buffer = new byte[1024];
			fos = new FileOutputStream(file);
			bis = new BufferedInputStream(inputStream, buffer.length);
			int numRead = -1;
			while ((numRead = bis.read(buffer, 0, buffer.length)) != -1) {
				fos.write(buffer, 0, numRead);
			}
			result = true;
		} catch (IOException ex) {
			ex.printStackTrace();
			this.getLog().error(ex, ex);
			this.getLog().error(
					"Exception during download file " + file.getAbsolutePath());
		} finally {
			try {
				fos.close();
			} catch (IOException ex) {
				ex.printStackTrace();
				this.getLog().error(ex, ex);
				this.getLog().error(
						"Exception during closing file output stream "
								+ file.getAbsolutePath());
			}
			try {
				bis.close();
			} catch (IOException ex) {
				ex.printStackTrace();
				this.getLog().error(ex, ex);
				this.getLog().error(
						"Exception during closing buffered input stream "
								+ file.getAbsolutePath());
			}
		}
		return result;
	}

	// 附件下载
	public String download() {
		String attachId = ProcessQueryUtil.getValueOfForm("attachId");
		if (StringUtils.isNotEmpty(attachId)) {
			SysAttachment attachment = sysAttachmentService.findById(Long
					.valueOf(attachId));
			ServletOutputStream sos = null;
			BufferedInputStream fis = null;
			try {
				FacesContext context = FacesContext.getCurrentInstance();
				context.responseComplete();
				String contentType = "application/x-download";
				HttpServletResponse response = (HttpServletResponse) context
						.getExternalContext().getResponse();
				HttpServletRequest request = (HttpServletRequest) context
						.getExternalContext().getRequest();
				response.setContentType(contentType);
				String fileName = attachment.getSrcFileName() + "."
						+ attachment.getFileExt();
				if (request.getHeader("User-Agent").toLowerCase()
						.indexOf("firefox") > 0) {
					fileName = new String(fileName.getBytes("UTF-8"),
							"ISO8859-1");
				} else if (request.getHeader("User-Agent").toUpperCase()
						.indexOf("MSIE") > 0) {
					fileName = URLEncoder.encode(fileName, "UTF-8");
				}
				response.setHeader("Content-Disposition",
						"attachment; filename=\"" + fileName + "\"");
				sos = response.getOutputStream();
				String filePath = sysAttachmentService.getAbsolutePath(
						attachment.getFileName(), attachment.getFileExt());
				File file = new File(filePath);
				response.setContentLength((int) file.length());
				byte[] buffer = new byte[1048576];
				int readBytes = 0;
				fis = new BufferedInputStream(new FileInputStream(file));
				while ((readBytes = fis.read(buffer)) > 0) {
					sos.write(buffer, 0, readBytes);
				}
				sos.flush();
			} catch (Exception e) {
				e.printStackTrace();
				this.getLog().error("附件下载失败！", e);
				this.setActionMsg("附件下载失败！");
			} finally {
				try {
					fis.close();
				} catch (IOException e) {
					this.getLog().error(e.getMessage(), e);
				} finally {
					try {
						sos.close();
					} catch (IOException e) {
						e.printStackTrace();
						this.getLog().error(e.getMessage(), e);
					}
				}
			}
		}
		return null;
	}

	// 删除附件
	public String delete() {
		String attachId = ProcessQueryUtil.getValueOfForm("attachId");
		if (StringUtils.isNotEmpty(attachId)) {
			sysAttachmentService.doDelete(Long.valueOf(attachId));
		}
		return null;
	}

	public String deleteAttach() {
		String attachId = ProcessQueryUtil.getValueOfForm("attachId");
		if (StringUtils.isNotEmpty(attachId)) {
			sysAttachmentService.doDelete(Long.valueOf(attachId));
			attachmentTaskService.doDeleteByAttachId(Long.valueOf(attachId));
		}
		return null;
	}

	public List<SysAttachment> getAttachments() {
		String taskId = this.getTaskId();
		if (StringHelper.isNotEmpty(taskId)) {
			attachments = bzAttachmentService.findByTaskId(taskId);
		}
		if (attachments == null) {
			attachments = new ArrayList<SysAttachment>();
		}
		return attachments;
	}

	public String getTaskId() {
		taskId = ProcessQueryUtil.getValueOfForm("taskId");
		return taskId;

	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getAcceptedTypes() {
		acceptedTypes = ProcessQueryUtil.getValueOfForm("acceptedTypes");
		if (StringHelper.isEmpty(acceptedTypes)) {
			acceptedTypes = sysAttachmentService.getDefaultAcceptedTypes();
		}
		return acceptedTypes;
	}

	public int getMaxFilesQuantity() {
		String maxFilesQuantityStr = ProcessQueryUtil
				.getValueOfForm("maxFilesQuantity");
		if (StringHelper.isNotEmpty(maxFilesQuantityStr)) {
			maxFilesQuantity = Integer.valueOf(maxFilesQuantityStr);
		}
		if (maxFilesQuantity <= 0) {
			maxFilesQuantity = sysAttachmentService
					.getDefaultMaxFilesQuantity();
		}
		return maxFilesQuantity;
	}

	public void setAcceptedTypes(String acceptedTypes) {
		this.acceptedTypes = acceptedTypes;
	}

	public void setMaxFilesQuantity(int maxFilesQuantity) {
		this.maxFilesQuantity = maxFilesQuantity;
	}

	public void setAttachments(List<SysAttachment> attachments) {
		this.attachments = attachments;
	}

	public ISysAttachmentService getSysAttachmentService() {
		return sysAttachmentService;
	}

	public void setSysAttachmentService(
			ISysAttachmentService sysAttachmentService) {
		this.sysAttachmentService = sysAttachmentService;
	}

	// public AttachmentTaskService getAttachmentTaskService() {
	// return attachmentTaskService;
	// }
	//
	// public void setAttachmentTaskService(
	// AttachmentTaskService attachmentTaskService) {
	// this.attachmentTaskService = attachmentTaskService;
	// }

	public String getJsCallback() {
		jsCallback = ProcessQueryUtil.getValueOfForm("jsCallback");
		return jsCallback;
	}

	public void setJsCallback(String jsCallback) {
		this.jsCallback = jsCallback;
	}

	public String getAttachIds() {
		return attachIds;
	}

	public void setAttachIds(String attachIds) {
		this.attachIds = attachIds;
	}

	public String getAttachNames() {
		return attachNames;
	}

	public void setAttachNames(String attachNames) {
		this.attachNames = attachNames;
	}

	public String getIsTempFile() {
		isTempFile = ProcessQueryUtil.getValueOfForm("isTempFile");
		if (StringHelper.isEmpty(isTempFile)) {
			isTempFile = "1";
		}
		return isTempFile;
	}

	public void setIsTempFile(String isTempFile) {
		this.isTempFile = isTempFile;
	}

}
