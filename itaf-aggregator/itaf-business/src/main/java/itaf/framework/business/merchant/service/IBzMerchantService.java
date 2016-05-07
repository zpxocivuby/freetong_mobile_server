package itaf.framework.business.merchant.service;

import itaf.framework.core.common.PageResult;
import itaf.framework.core.common.QueryCriteria;
import itaf.framework.domain.merchant.BzMerchant;

public interface IBzMerchantService {

	public PageResult<BzMerchant> findByCriteria(QueryCriteria criteria);

	public void doSaveOrUpdate(BzMerchant bzMerchant);

	public void doSave(BzMerchant bzMerchant);

	public BzMerchant findById(Long bzMerchantId);

	public BzMerchant getById(Long bzMerchantId);

	public void doMarkForDelete(BzMerchant bzMerchant);

	public void doMarkForDeleteById(Long bzMerchantId);
	
	public void doSaveDistMerchant(BzMerchant bzMerchant);
	
	public void doUpdateDistMerchant(BzMerchant bzMerchant);
	
	public void doSaveBzMerchant(BzMerchant bzMerchant);
	
	public void doUpdateBzMerchant(BzMerchant bzMerchant);

}
