package itaf.framework.business.merchant.service.impl;

import itaf.framework.business.base.service.impl.BaseServiceImpl;
import itaf.framework.business.merchant.service.IBzMerchantRateService;
import itaf.framework.domain.merchant.BzMerchantRate;
import itaf.framework.persistence.merchant.dao.IBzMerchantRateDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bzMerchantRateServiceImpl")
public class BzMerchantRateServiceImpl extends BaseServiceImpl implements
		IBzMerchantRateService {

	@Autowired
	private IBzMerchantRateDao bzMerchantRateDao;

	public BzMerchantRate getById(Long bzMerchantRateId) {
		return bzMerchantRateDao.getById(bzMerchantRateId);
	}
	
	public void doSaveOrUpdate(BzMerchantRate bzMerchantRate){
		bzMerchantRateDao.saveOrUpdate(bzMerchantRate);
	}

}