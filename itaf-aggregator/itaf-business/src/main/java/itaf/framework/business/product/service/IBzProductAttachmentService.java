package itaf.framework.business.product.service;

import itaf.framework.domain.product.BzProductAttachment;

import java.util.Collection;
import java.util.List;

public interface IBzProductAttachmentService {

	String generateUniqueFileName(Long fileType, String fileExt);

	String getAbsolutePath(String fileName, String fileExt);

	String getPath(String fileName, String fileExt);

	String getPathById(Long attachmentId);

	BzProductAttachment getById(Long attachmentId);

	List<BzProductAttachment> getByIds(String attachmentIds);

	List<BzProductAttachment> getByIds(List<Long> attachmentIds);

	void doSaveOrUpdate(BzProductAttachment attachment);

	void doDelete(Long attachmentId);

	void doDelete(BzProductAttachment attachment);

	void doDelete(Collection<BzProductAttachment> attachments);

	String getDefaultAcceptedTypes();

	int getDefaultMaxFilesQuantity();

	void doMarkForValid(Long attachmentId);

	void doMarkForValid(Collection<BzProductAttachment> attachments);

	void doClearInvalidAttachments();

}
