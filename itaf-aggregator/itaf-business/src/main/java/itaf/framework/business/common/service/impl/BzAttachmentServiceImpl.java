package itaf.framework.business.common.service.impl;

import itaf.framework.business.base.service.impl.BaseServiceImpl;
import itaf.framework.business.common.service.IBzAttachmentService;
import itaf.framework.business.platform.service.ISystemConfigService;
import itaf.framework.core.util.DateHelper;
import itaf.framework.core.util.StringHelper;
import itaf.framework.domain.common.BzAttachment;
import itaf.framework.domain.platform.SysAttachment;
import itaf.framework.domain.workflow.AttachmentTask;
import itaf.framework.persistence.common.dao.IBzAttachmentDao;
import itaf.framework.persistence.platform.dao.ISysAttachmentDao;
import itaf.framework.workflow.service.AttachmentTaskService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bzAttachmentServiceImpl")
public class BzAttachmentServiceImpl extends BaseServiceImpl implements
		IBzAttachmentService {

	@Autowired
	private IBzAttachmentDao bzAttachmentDao;
	@Autowired
	private ISystemConfigService systemConfigService;

	// 文件支持的格式
	private String defaultAcceptedTypes;
	// 单次可以上传的文件个数
	private int defaultMaxFilesQuantity;
	
	@Autowired
	private AttachmentTaskService attachmentTaskService;
	
	@Autowired
	ISysAttachmentDao sysAttachmentDao;

	public String generateUniqueFileName(Long fileType, String fileExt) {
		StringBuilder fileName = new StringBuilder();
		fileName.append(this.getType4FileName(fileType));
		fileName.append(this.getTime4FileName());
		fileName.append(this.getRandom4FileName());
		String result = fileName.toString();
		String fileFullPath = this.getAbsolutePath(result, fileExt);
		File newFile = new File(fileFullPath);
		if (!newFile.exists()) {
			try {
				int j = fileFullPath.lastIndexOf("/");
				String filePath = fileFullPath.substring(0, j);
				File dirFile = new File(filePath);
				if (!(dirFile.exists()) && !(dirFile.isDirectory())) {
					dirFile.mkdirs();
				}
				newFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			result = this.generateUniqueFileName(fileType, fileExt);
		}
		return result;
	}

	public String getAbsolutePath(String fileName, String fileExt) {
		StringBuilder filePath = new StringBuilder();
		filePath.append(this.getUploadfilesPath());
		filePath.append(fileName.substring(0, 2));
		filePath.append("/");
		filePath.append(fileName.substring(2, 6));
		filePath.append("/");
		filePath.append(fileName.substring(2, 8));
		filePath.append("/");
		filePath.append(fileName.substring(2, 10));
		filePath.append("/");
		filePath.append(fileName);
		filePath.append(".");
		filePath.append(fileExt);
		return filePath.toString();
	}

	public String getPath(String fileName, String fileExt) {
		if (StringHelper.isEmpty(fileName) || StringHelper.isEmpty(fileExt)) {
			return "";
		}
		StringBuilder filePath = new StringBuilder();
		filePath.append(fileName.substring(0, 2));
		filePath.append("/");
		filePath.append(fileName.substring(2, 6));
		filePath.append("/");
		filePath.append(fileName.substring(2, 8));
		filePath.append("/");
		filePath.append(fileName.substring(2, 10));
		filePath.append("/");
		filePath.append(fileName);
		filePath.append(".");
		filePath.append(fileExt);
		return filePath.toString();
	}

	public String getPathById(Long attachmentId) {
		BzAttachment bzAttachment = this.getById(attachmentId);
		if (bzAttachment == null) {
			return "";
		}
		return getPath(bzAttachment.getFileName(), bzAttachment.getFileExt());
	}

	private String getRandom4FileName() {
		return (int) (Math.random() * 9000 + 1000) + "";
	}

	private String getTime4FileName() {
		StringBuilder time = new StringBuilder();
		Date date = new Date();
		time.append(DateHelper
				.formatDate(date, DateHelper.FORMAT_DATE_YYYYMMDD));
		long milliseconds = date.getTime()
				+ TimeZone.getDefault().getRawOffset();
		time.append(milliseconds % 86400000);
		return time.toString();
	}

	private String getType4FileName(Long fileType) {
		String type = "";
		if (fileType == 1) {
			type = "PO";
		} else if (fileType == 2) {
			type = "UF";
		} else if (fileType == 3) {
			type = "UT";
		}
		return type;
	}

	public BzAttachment getById(Long id) {
		return bzAttachmentDao.getById(id);
	}

	public List<BzAttachment> getByIds(String attachmentIds) {
		List<BzAttachment> attachments = new ArrayList<BzAttachment>();
		for (String attachmentId : StringUtils.split(attachmentIds, ",")) {
			attachments.add(getById(Long.valueOf(attachmentId)));
		}
		return attachments;
	}

	public List<BzAttachment> getByIds(List<Long> attachmentIds) {
		return bzAttachmentDao.getByIds(attachmentIds);
	}

	public void doSaveOrUpdate(BzAttachment attachment) {
		bzAttachmentDao.saveOrUpdate(attachment);
	}

	public void doDelete(Long attachmentId) {
		doDelete(bzAttachmentDao.getById(attachmentId));
	}

	public void doDelete(BzAttachment attachment) {
		deleteFile(attachment);
		bzAttachmentDao.remove(attachment);
	}

	public void doDelete(Collection<BzAttachment> attachments) {
		for (BzAttachment attachment : attachments) {
			doDelete(attachment);
		}
	}

	private void deleteFile(BzAttachment attachment) {
		String filePath = this.getAbsolutePath(attachment.getFileName(),
				attachment.getFileExt());
		this.deleteFileByPath(filePath);
	}

	private void deleteFileByPath(String filePath) {
		File file = new File(filePath);
		if (file.isFile() && file.exists()) {
			file.delete();
		}
	}

	private String getUploadfilesPath() {
		return systemConfigService.getConfigValue("PATH_UPLOADFILES");
	}

	public ISystemConfigService getSystemConfigService() {
		return systemConfigService;
	}

	public void setSystemConfigService(ISystemConfigService systemConfigService) {
		this.systemConfigService = systemConfigService;
	}

	public String getDefaultAcceptedTypes() {
		defaultAcceptedTypes = systemConfigService
				.getConfigValue("PRODUCT_ACCEPTED_TYPES");
		return defaultAcceptedTypes;
	}

	public void setDefaultAcceptedTypes(String defaultAcceptedTypes) {
		this.defaultAcceptedTypes = defaultAcceptedTypes;
	}

	public int getDefaultMaxFilesQuantity() {
		defaultMaxFilesQuantity = Integer.valueOf(systemConfigService
				.getConfigValue("PRODUCT_MAX_FILES_QUANTITY"));
		return defaultMaxFilesQuantity;
	}

	public void setDefaultMaxFilesQuantity(int defaultMaxFilesQuantity) {
		this.defaultMaxFilesQuantity = defaultMaxFilesQuantity;
	}

	public void doMarkForValid(Long attachmentId) {
		BzAttachment attachment = getById(attachmentId);
		attachment.setMarkForDelete(false);
		this.doSaveOrUpdate(attachment);
	}

	public void doMarkForValid(Collection<BzAttachment> attachments) {
		Set<Long> attachmentIds = new HashSet<Long>();
		for (BzAttachment bsAttachment : attachments) {
			attachmentIds.add(bsAttachment.getId());
		}
		this.doMarkForValid(attachmentIds);
	}

	private void doMarkForValid(Set<Long> attachmentIds) {
		String hql = "update BzAttachment b set b.markForDelete=:markForDelete where b.id in (:attachmentIds)";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("markForDelete", false);
		params.put("attachmentIds", attachmentIds);
		bzAttachmentDao.hqlExecute(hql, params);
	}

	public void doClearInvalidAttachments() {
		String hql = "select b from BzAttachment b where ba.markForDelete=:markForDelete and b.createdDate<:createdDate";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("markForDelete", true);
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, -1);
		params.put("createdDate", c.getTime());
		List<BzAttachment> target = bzAttachmentDao.query(hql, params);
		for (BzAttachment bsAttachment : target) {
			this.doDelete(bsAttachment);
		}
	}
	
	public List<SysAttachment> findByTaskId(String taskId){
		List<AttachmentTask> attachmentTaskList = attachmentTaskService
				.findByTaskId(taskId);
		List<SysAttachment> bizAttachmentList = new ArrayList<SysAttachment>();

		for (int i = 0; i < attachmentTaskList.size(); i++) {
			AttachmentTask attachmentTask = attachmentTaskList.get(i);
			bizAttachmentList.add(sysAttachmentDao.getById(attachmentTask
					.getBsAttachmentId()));
		}
		return bizAttachmentList;
	}
	
	public void doSaveContact(String taskId, Long attachmentId) {
		AttachmentTask attachmentTask = new AttachmentTask();
		attachmentTask.setTaskId(taskId);
		attachmentTask.setBsAttachmentId(attachmentId);
		attachmentTaskService.doSaveAttachmentTask(attachmentTask);
	}
}