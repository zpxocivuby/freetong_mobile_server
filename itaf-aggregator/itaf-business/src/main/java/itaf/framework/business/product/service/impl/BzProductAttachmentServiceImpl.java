package itaf.framework.business.product.service.impl;

import itaf.framework.business.base.service.impl.BaseServiceImpl;
import itaf.framework.business.platform.service.ISystemConfigService;
import itaf.framework.business.product.service.IBzProductAttachmentService;
import itaf.framework.core.util.DateHelper;
import itaf.framework.core.util.StringHelper;
import itaf.framework.domain.product.BzProductAttachment;
import itaf.framework.persistence.product.dao.IBzProductAttachmentDao;

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

@Service("bzProductAttachmentServiceImpl")
public class BzProductAttachmentServiceImpl extends BaseServiceImpl implements
		IBzProductAttachmentService {

	@Autowired
	private IBzProductAttachmentDao bzProductAttachmentDao;
	@Autowired
	private ISystemConfigService systemConfigService;

	// 文件支持的格式
	private String defaultAcceptedTypes;
	// 单次可以上传的文件个数
	private int defaultMaxFilesQuantity;

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
		BzProductAttachment bzProductAttachment = this.getById(attachmentId);
		if (bzProductAttachment == null) {
			return "";
		}
		return getPath(bzProductAttachment.getFileName(),
				bzProductAttachment.getFileExt());
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
			type = "PI";
		} else if (fileType == 2) {
			type = "ST";
		}
		return type;
	}

	public BzProductAttachment getById(Long id) {
		return bzProductAttachmentDao.getById(id);
	}

	public List<BzProductAttachment> getByIds(String attachmentIds) {
		List<BzProductAttachment> attachments = new ArrayList<BzProductAttachment>();
		for (String attachmentId : StringUtils.split(attachmentIds, ",")) {
			attachments.add(getById(Long.valueOf(attachmentId)));
		}
		return attachments;
	}

	public List<BzProductAttachment> getByIds(List<Long> attachmentIds) {
		return bzProductAttachmentDao.getByIds(attachmentIds);
	}

	public void doSaveOrUpdate(BzProductAttachment attachment) {
		bzProductAttachmentDao.saveOrUpdate(attachment);
	}

	public void doDelete(Long attachmentId) {
		doDelete(bzProductAttachmentDao.getById(attachmentId));
	}

	public void doDelete(BzProductAttachment attachment) {
		deleteFile(attachment);
		bzProductAttachmentDao.remove(attachment);
	}

	public void doDelete(Collection<BzProductAttachment> attachments) {
		for (BzProductAttachment attachment : attachments) {
			doDelete(attachment);
		}
	}

	private void deleteFile(BzProductAttachment attachment) {
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
		BzProductAttachment attachment = getById(attachmentId);
		attachment.setMarkForDelete(false);
		this.doSaveOrUpdate(attachment);
	}

	public void doMarkForValid(Collection<BzProductAttachment> attachments) {
		Set<Long> attachmentIds = new HashSet<Long>();
		for (BzProductAttachment bsAttachment : attachments) {
			attachmentIds.add(bsAttachment.getId());
		}
		this.doMarkForValid(attachmentIds);
	}

	private void doMarkForValid(Set<Long> attachmentIds) {
		String hql = "update BzProductAttachment b set b.markForDelete=:markForDelete where b.id in (:attachmentIds)";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("markForDelete", false);
		params.put("attachmentIds", attachmentIds);
		bzProductAttachmentDao.hqlExecute(hql, params);
	}

	public void doClearInvalidAttachments() {
		String hql = "select b from BzProductAttachment b where ba.markForDelete=:markForDelete and b.createdDate<:createdDate";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("markForDelete", true);
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, -1);
		params.put("createdDate", c.getTime());
		List<BzProductAttachment> target = bzProductAttachmentDao.query(hql,
				params);
		for (BzProductAttachment bsAttachment : target) {
			this.doDelete(bsAttachment);
		}
	}

}