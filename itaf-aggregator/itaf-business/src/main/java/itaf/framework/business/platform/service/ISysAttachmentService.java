package itaf.framework.business.platform.service;

import itaf.framework.domain.platform.SysAttachment;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * 附件服务类
 * 
 * @author XINXIN
 * 
 */
public interface ISysAttachmentService {

	/**
	 * 生成唯一系统文件名
	 * 
	 * @param fileType
	 *            类型
	 * @param fileExt
	 *            文件扩展名
	 * @return 类型+年月日+8位时间+4位内的随机数[1000-9999]
	 */
	String generateUniqueFileName(Long fileType, String fileExt);

	/**
	 * 获取绝对路径
	 * 
	 * @param fileName
	 *            系统文件名
	 * @param fileExt
	 *            文件扩展名
	 * @return defaultPath + path + fileName + "." + fileExt
	 */
	String getAbsolutePath(String fileName, String fileExt);

	/**
	 * 获取相对路径
	 * 
	 * @param fileName
	 *            系统文件名
	 * @param fileExt
	 *            文件扩展名
	 * @return path + fileName + "." + fileExt
	 */
	String getPath(String fileName, String fileExt);

	/**
	 * 获取相对路径
	 * 
	 * @param attachmentId
	 *            附件Id
	 * @return path + fileName + "." + fileExt
	 */
	String getPathById(Long attachmentId);

	void doSaveOrUpdate(SysAttachment attachment);

	/**
	 * 根据Id进行查找
	 * 
	 * @param attachmentId
	 *            附件Id
	 * @return SysAttachment
	 */
	SysAttachment findById(Long attachmentId);

	SysAttachment getById(Long attachmentId);

	List<SysAttachment> getByIds(String attachmentIds);

	/**
	 * 根据Id进行删除(数据库+文件系统)
	 * 
	 * @param attachmentId
	 *            附件Id
	 */
	void doDelete(Long attachmentId);

	void doDelete(SysAttachment attachment);

	void doDelete(Collection<SysAttachment> attachments);

	/**
	 * 系统默认格式
	 * 
	 * @return "avi, rm, rmvb, mp4, mkv, mov, asf, wmv, flv"
	 */
	String getDefaultAcceptedTypes();

	/**
	 * 系统默认最多上传文件数
	 * 
	 * @return 5
	 */
	int getDefaultMaxFilesQuantity();

	/**
	 * 更新标记删除
	 * 
	 * @param attachmentId
	 *            附件Id
	 */
	void doMarkForValid(Long attachmentId);

	/**
	 * 更新标记删除
	 * 
	 * @param attachmentIds
	 *            附件Id列表
	 */
	void doMarkForValid(Set<Long> attachmentIds);

	/**
	 * 更新标记删除
	 * 
	 * @param attachments
	 *            SysAttachment对象列表
	 */
	void doMarkForValid(Collection<SysAttachment> attachments);

	/**
	 * 清理无效的附件
	 */
	void doClearInvalidAttachments();

}
