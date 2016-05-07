package itaf.framework.business.merchant.service;

import itaf.framework.domain.merchant.BzMerchantRate;

public interface IBzMerchantRateService {

	BzMerchantRate getById(Long bzMerchantRateId);
	
	void doSaveOrUpdate(BzMerchantRate bzMerchantRate);
	
}
