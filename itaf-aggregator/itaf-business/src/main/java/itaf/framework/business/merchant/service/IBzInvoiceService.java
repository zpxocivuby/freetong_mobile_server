package itaf.framework.business.merchant.service;

import itaf.framework.core.common.PageResult;
import itaf.framework.core.common.QueryCriteria;
import itaf.framework.domain.merchant.BzInvoice;

public interface IBzInvoiceService {

	PageResult<BzInvoice> findByCriteria(QueryCriteria criteria);

	public BzInvoice getById(Long id);

	public void doInvoice(Long bzOrderId, Long bzDistCompanyId);

}
