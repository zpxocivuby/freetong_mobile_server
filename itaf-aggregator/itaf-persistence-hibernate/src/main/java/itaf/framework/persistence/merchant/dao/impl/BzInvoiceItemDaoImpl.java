package itaf.framework.persistence.merchant.dao.impl;

import itaf.framework.domain.merchant.BzInvoiceItem;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.merchant.dao.IBzInvoiceItemDao;

import org.springframework.stereotype.Repository;

@Repository("bzInvoiceItemDaoImpl")
public class BzInvoiceItemDaoImpl extends BaseDaoImpl<BzInvoiceItem> implements
		IBzInvoiceItemDao {

}