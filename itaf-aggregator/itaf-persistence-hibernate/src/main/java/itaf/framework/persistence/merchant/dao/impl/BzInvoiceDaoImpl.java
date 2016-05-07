package itaf.framework.persistence.merchant.dao.impl;

import itaf.framework.domain.merchant.BzInvoice;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.merchant.dao.IBzInvoiceDao;

import org.springframework.stereotype.Repository;

@Repository("bzInvoiceDaoImpl")
public class BzInvoiceDaoImpl extends BaseDaoImpl<BzInvoice> implements
		IBzInvoiceDao {

}