package itaf.framework.business.common.service;

import itaf.framework.domain.common.BzAttachment;
import itaf.framework.domain.platform.SysAttachment;

import java.util.Collection;
import java.util.List;

public interface IBzAttachmentService {

	String generateUniqueFileName(Long fileType, String fileExt);

	String getAbsolutePath(String fileName, String fileExt);

	String getPath(String fileName, String fileExt);

	String getPathById(Long attachmentId);

	BzAttachment getById(Long attachmentId);

	List<BzAttachment> getByIds(String attachmentIds);

	List<BzAttachment> getByIds(List<Long> attachmentIds);

	void doSaveOrUpdate(BzAttachment attachment);

	void doDelete(Long attachmentId);

	void doDelete(BzAttachment attachment);

	void doDelete(Collection<BzAttachment> attachments);

	String getDefaultAcceptedTypes();

	int getDefaultMaxFilesQuantity();

	void doMarkForValid(Long attachmentId);

	void doMarkForValid(Collection<BzAttachment> attachments);

	void doClearInvalidAttachments();
	
	List<SysAttachment> findByTaskId(String taskId);
	
	void doSaveContact(String taskId, Long attachmentId);

}
