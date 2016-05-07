package itaf.framework.workflow.service.impl;

import itaf.framework.domain.workflow.AttachmentTask;
import itaf.framework.persistence.workflow.dao.AttachmentTaskDao;
import itaf.framework.workflow.base.service.impl.BaseServiceImpl;
import itaf.framework.workflow.service.AttachmentTaskService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("attachmentTaskServiceImpl")
public class AttachmentTaskServiceImpl extends BaseServiceImpl implements
		AttachmentTaskService {

	@Autowired
	private AttachmentTaskDao attachmentTaskDao;

	public void doSaveAttachmentTask(AttachmentTask attachmentTask) {
		attachmentTaskDao.save(attachmentTask);
	}

	public List<AttachmentTask> findByTaskId(String taskId) {
		AttachmentTask attachmentTask = new AttachmentTask();
		attachmentTask.setTaskId(taskId);
		List<AttachmentTask> list = attachmentTaskDao.find(attachmentTask);
		if (list == null) {
			list = new ArrayList<AttachmentTask>();
		}
		return list;
	}

	public void doDeleteByAttachId(Long attachId) {
		AttachmentTask attachmentTask = new AttachmentTask();
		attachmentTask.setBsAttachmentId(attachId);
		List<AttachmentTask> list = attachmentTaskDao.find(attachmentTask);
		if (list != null && list.size() != 0) {
			attachmentTaskDao.remove(list.get(0));
		}
	}
}
