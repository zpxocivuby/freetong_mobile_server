package itaf.framework.web.workflow.action;

import itaf.framework.business.platform.service.ISysAttachmentService;
import itaf.framework.core.common.PageResult;
import itaf.framework.core.constant.QueryConditionConstants;
import itaf.framework.core.util.SpringContextUtil;
import itaf.framework.web.base.action.BaseRichFacesDataGridAction;
import itaf.framework.web.platform.action.AttachmentAction;
import itaf.framework.web.util.ProcessQueryUtil;
import itaf.framework.workflow.service.WorkFlowService;
import itaf.framework.workflow.service.WorkflowProcessService;
import itaf.framework.workflow.vo.ProcinstVo;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.richfaces.event.FileUploadEvent;
import org.richfaces.model.UploadedFile;

@ManagedBean(name = "deployWorkFlowAction")
@ViewScoped
public class DeployWorkFlowAction extends
		BaseRichFacesDataGridAction<ProcinstVo> {
	private static final long serialVersionUID = 1L;

	private static final Log log = LogFactory.getLog(AttachmentAction.class);

	@ManagedProperty(value = "#{workflowProcessServiceImpl}")
	private WorkflowProcessService workflowProcessService;
	
	@ManagedProperty(value = "#{sysAttachmentServiceImpl}")
	private ISysAttachmentService bsAttachmentService;
	
	@ManagedProperty(value = "#{workFlowServiceImpl}")	
	WorkFlowService workFlowService;

	// 文件支持的格式
	private String acceptedTypes;
	// 单次可以上传的文件个数
	private int maxFilesQuantity;

	public String getAcceptedTypes() {
		return acceptedTypes;
	}

	public void setAcceptedTypes(String acceptedTypes) {
		this.acceptedTypes = acceptedTypes;
	}

	public int getMaxFilesQuantity() {
		return maxFilesQuantity;
	}

	public void setMaxFilesQuantity(int maxFilesQuantity) {
		this.maxFilesQuantity = maxFilesQuantity;
	}

	public void setWorkflowProcessService(
			WorkflowProcessService workflowProcessService) {
		this.workflowProcessService = workflowProcessService;
	}

	private WorkflowProcessService getWorkflowProcessService() {
		if (workflowProcessService == null) {
			workflowProcessService = (WorkflowProcessService) SpringContextUtil
					.getBean("workflowProcessServiceImpl");
		}
		return workflowProcessService;
	}

	public ISysAttachmentService getBsAttachmentService() {
		return bsAttachmentService;
	}

	public void setBsAttachmentService(ISysAttachmentService bsAttachmentService) {
		this.bsAttachmentService = bsAttachmentService;
	}

	public WorkFlowService getWorkFlowService() {
		return workFlowService;
	}

	public void setWorkFlowService(WorkFlowService workFlowService) {
		this.workFlowService = workFlowService;
	}

	protected PageResult<ProcinstVo> getPageContent() {
		workflowProcessService = this.getWorkflowProcessService();
		int currentIndex = queryCriteria.getStartIndex();
		int pageSize = queryCriteria.getPageSize();
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put(QueryConditionConstants.STARTTIME,
				ProcessQueryUtil.processDate(queryCriteria, "startTime"));
		variables.put(QueryConditionConstants.ENDTIME,
				ProcessQueryUtil.processDate(queryCriteria, "endTime"));
		variables.put(QueryConditionConstants.PROCESSDEFINITIONID,
				ProcessQueryUtil.processString(queryCriteria,
						"processDefinitionId"));
		return workflowProcessService.findActProcinst(currentIndex, pageSize,
				variables);
	}

	// 附件上传
	public void upload(FileUploadEvent event) {
		UploadedFile item = event.getUploadedFile();
		if (item.getSize() == 0) {
			return;
		}

		String srcFileName = "";
		try {
			srcFileName = URLDecoder.decode(item.getName(), "utf-8");
			int p = srcFileName.lastIndexOf("\\");
			if (p > -1) {
				srcFileName = srcFileName.substring(p);
			}
		} catch (UnsupportedEncodingException e) {
			log.error(e.getMessage(), e);
		}

		int i = srcFileName.lastIndexOf(".");

		// 文件名
		String srcFileNameNoExt  = srcFileName.substring(0, i);
		// 扩展名
		String fileExt = srcFileName.substring(i + 1, srcFileName.length());

		// 生成文件名
		String fileName = bsAttachmentService.generateUniqueFileName(1L,
				fileExt);
		// URL
		String fileFullPath = bsAttachmentService.getAbsolutePath(fileName,
				fileExt);
		// 写入
		File newFile = new File(fileName);
		try{
			workFlowService.deployment(srcFileNameNoExt+"."+fileExt, item.getInputStream());
		} catch (Exception e) {
			log.error("附件上传失败！", e);
		}
		/*if (newFile.exists()) {
			try {
				saveToFile(item.getInputStream(), newFile);
			} catch (Exception e) {
				log.error("附件上传失败！", e);
			}
		}*/
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
			log.error(ex, ex);
			log.error("Exception during download file "
					+ file.getAbsolutePath());
		} finally {
			try {
				fos.close();
			} catch (IOException ex) {
				log.error(ex, ex);
				log.error("Exception during closing file output stream "
						+ file.getAbsolutePath());
			}
			try {
				bis.close();
			} catch (IOException ex) {
				log.error(ex, ex);
				log.error("Exception during closing buffered input stream "
						+ file.getAbsolutePath());
			}
		}
		return result;
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		
	}
}
