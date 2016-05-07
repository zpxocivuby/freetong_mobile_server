package itaf.framework.workflow.service;

import itaf.framework.domain.workflow.AttachmentTask;

import java.util.List;

public interface AttachmentTaskService {
	public void doSaveAttachmentTask(AttachmentTask attachmentTask);

	public List<AttachmentTask> findByTaskId(String taskId);

	public void doDeleteByAttachId(Long attachId);
}
