package itaf.framework.persistence.common.dao.impl;

import itaf.framework.domain.common.BzAttachment;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.common.dao.IBzAttachmentDao;

import org.springframework.stereotype.Repository;

@Repository("bzAttachmentDaoImpl")
public class BzAttachmentDaoImpl extends BaseDaoImpl<BzAttachment> implements
		IBzAttachmentDao {

}