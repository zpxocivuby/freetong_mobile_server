package itaf.framework.persistence.product.dao.impl;

import itaf.framework.domain.product.BzProductAttachment;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.product.dao.IBzProductAttachmentDao;

import org.springframework.stereotype.Repository;

@Repository("bzProductAttachmentDaoImpl")
public class BzProductAttachmentDaoImpl extends
		BaseDaoImpl<BzProductAttachment> implements IBzProductAttachmentDao {

}