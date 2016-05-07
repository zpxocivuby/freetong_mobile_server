package itaf.framework.business.merchant.service;

import itaf.framework.core.common.PageResult;
import itaf.framework.core.common.QueryCriteria;
import itaf.framework.domain.merchant.BzDistCompany;

public interface IBzDistCompanyService {

	public PageResult<BzDistCompany> findByCriteria(QueryCriteria criteria);

	public void doSaveOrUpdate(BzDistCompany bzDistCompany);

	public void doSave(BzDistCompany bzDistCompany);

	public BzDistCompany findById(Long bzDistCompanyId);

	public BzDistCompany getById(Long bzDistCompanyId);
	
	public void doSaveBzDistCompany(BzDistCompany bzDistCompany);
	
	public void doUpdateBzDistCompany(BzDistCompany bzDistCompany);

}
