package itaf.framework.business.platform.service.impl;

import itaf.framework.business.base.service.impl.BaseServiceImpl;
import itaf.framework.business.platform.service.ISysAttachmentService;
import itaf.framework.business.platform.service.ISystemConfigService;
import itaf.framework.core.util.DateHelper;
import itaf.framework.core.util.StringHelper;
import itaf.framework.domain.platform.SysAttachment;
import itaf.framework.persistence.platform.dao.ISysAttachmentDao;

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

@Service("sysAttachmentServiceImpl")
public class SysAttachmentServiceImpl extends BaseServiceImpl implements
		ISysAttachmentService {

	@Autowired
	private ISysAttachmentDao attachDao;
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
		SysAttachment bsAttachment = this.getById(attachmentId);
		if (bsAttachment == null) {
			return "";
		}
		return getPath(bsAttachment.getFileName(), bsAttachment.getFileExt());
	}

	/**
	 * 生成随机数[1000-9999]
	 * 
	 * @return [1000-9999]
	 */
	private String getRandom4FileName() {
		return (int) (Math.random() * 9000 + 1000) + "";
	}

	/**
	 * 生成时间值
	 * 
	 * @return String
	 */
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

	/**
	 * 根据文件类型生成文件名的前两位（必须是两位）
	 * 
	 * @param fileType
	 *            文件类型
	 * @return 类型
	 */
	private String getType4FileName(Long fileType) {
		String type = "";
		if (fileType == 1) {
			type = "vi";
		} else if (fileType == 2) {
			type = "pi";
		}
		return type;
	}

	public void doSaveOrUpdate(SysAttachment attachment) {
		attachDao.saveOrUpdate(attachment);
	}

	public SysAttachment findById(Long attachmentId) {
		return attachDao.findById(attachmentId);
	}

	public SysAttachment getById(Long attachmentId) {
		return attachDao.getById(attachmentId);
	}

	public List<SysAttachment> getByIds(String attachmentIds) {
		List<SysAttachment> bsAttachments = new ArrayList<SysAttachment>();
		for (String attachmentId : StringUtils.split(attachmentIds, ",")) {
			bsAttachments.add(getById(Long.valueOf(attachmentId)));
		}
		return bsAttachments;
	}

	public void doDelete(Long attachmentId) {
		SysAttachment attachment = this.findById(attachmentId);
		deleteFile(attachment);
		attachDao.remove(attachment);
	}

	public void doDelete(SysAttachment attachment) {
		deleteFile(attachment);
		attachDao.remove(attachment);
	}

	public void doDelete(Collection<SysAttachment> attachments) {
		for (SysAttachment bsAttachment : attachments) {
			doDelete(bsAttachment);
		}
	}

	private void deleteFile(SysAttachment attachment) {
		String filePath = this.getAbsolutePath(attachment.getFileName(),
				attachment.getFileExt());
		this.deleteFileByPath(filePath);
	}

	/**
	 * 删除单个文件
	 * 
	 * @param filePath
	 *            被删除文件的路径
	 * @return 单个文件删除成功返回true，否则返回false
	 */
	private void deleteFileByPath(String filePath) {
		File file = new File(filePath);
		// 路径为文件且不为空则进行删除
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
				.getConfigValue("DEFAULT_ACCEPTED_TYPES");
		return defaultAcceptedTypes;
	}

	public void setDefaultAcceptedTypes(String defaultAcceptedTypes) {
		this.defaultAcceptedTypes = defaultAcceptedTypes;
	}

	public int getDefaultMaxFilesQuantity() {
		defaultMaxFilesQuantity = Integer.valueOf(systemConfigService
				.getConfigValue("DEFAULT_MAX_FILES_QUANTITY"));
		return defaultMaxFilesQuantity;
	}

	public void setDefaultMaxFilesQuantity(int defaultMaxFilesQuantity) {
		this.defaultMaxFilesQuantity = defaultMaxFilesQuantity;
	}

	public void doMarkForValid(Long attachmentId) {
		SysAttachment attachment = getById(attachmentId);
		attachment.setMarkForDelete(false);
		this.doSaveOrUpdate(attachment);
	}

	public void doMarkForValid(Set<Long> attachmentIds) {
		String hql = "update SysAttachment b set b.markForDelete=:markForDelete where b.id in (:attachmentIds)";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("markForDelete", false);
		params.put("attachmentIds", attachmentIds);
		attachDao.hqlExecute(hql, params);
	}

	public void doMarkForValid(Collection<SysAttachment> attachments) {
		Set<Long> attachmentIds = new HashSet<Long>();
		for (SysAttachment bsAttachment : attachments) {
			attachmentIds.add(bsAttachment.getId());
		}
		this.doMarkForValid(attachmentIds);
	}

	public void doClearInvalidAttachments() {
		String hql = "select b from SysAttachment b where b.markForDelete=:markForDelete and b.createdDate<:createdDate";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("markForDelete", true);
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, -1);
		params.put("createdDate", c.getTime());
		List<SysAttachment> target = attachDao.query(hql, params);
		for (SysAttachment bsAttachment : target) {
			this.doDelete(bsAttachment);
		}
	}

}
