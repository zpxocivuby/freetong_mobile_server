package itaf.framework.business.merchant.service;

import itaf.framework.domain.merchant.BzShelf;

import java.util.List;

public interface IBzShelfService {

	public void doSaveOrUpdate(BzShelf bzShelf);

	public BzShelf findByBzProductId(Long bzProductId);

	public BzShelf findEmptyByMerchantId(Long bzMerchantId);

	public List<BzShelf> findByMerchantId(Long bzMerchantId);

}
