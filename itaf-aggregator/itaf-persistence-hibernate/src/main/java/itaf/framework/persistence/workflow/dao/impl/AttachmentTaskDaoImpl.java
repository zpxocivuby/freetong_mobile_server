package itaf.framework.persistence.workflow.dao.impl;

import itaf.framework.domain.workflow.AttachmentTask;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.workflow.dao.AttachmentTaskDao;

import org.springframework.stereotype.Repository;

@Repository("attachmentTaskDaoImpl")
public class AttachmentTaskDaoImpl extends BaseDaoImpl<AttachmentTask>
		implements AttachmentTaskDao {
}
