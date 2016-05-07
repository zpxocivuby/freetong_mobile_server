package itaf.framework.business.merchant.service.impl;

import itaf.framework.business.base.service.impl.BaseServiceImpl;
import itaf.framework.business.merchant.service.IBzMerchantRateService;
import itaf.framework.business.merchant.service.IBzMerchantRatingService;
import itaf.framework.domain.merchant.BzMerchantRate;
import itaf.framework.domain.merchant.BzMerchantRating;
import itaf.framework.persistence.merchant.dao.IBzMerchantRatingDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bzMerchantRatingServiceImpl")
public class BzMerchantRatingServiceImpl extends BaseServiceImpl implements
		IBzMerchantRatingService {

	@Autowired
	private IBzMerchantRatingDao bzMerchantRatingDao;
	@Autowired
	private IBzMerchantRateService bzMerchantRateService;

	@Override
	public void doRating(BzMerchantRating bzMerchantRating) {
		bzMerchantRatingDao.saveOrUpdate(bzMerchantRating);
		BzMerchantRate bzMerchantRate = bzMerchantRateService
				.getById(bzMerchantRating.getBzMerchantId());
		if (bzMerchantRate == null) {
			bzMerchantRate = new BzMerchantRate();
			bzMerchantRate.setId(bzMerchantRating.getBzMerchantId());
			bzMerchantRate.setDescriptionScore(0L);
			bzMerchantRate.setAttitudeScore(0L);
			bzMerchantRate.setDeliveryScore(0L);
			bzMerchantRate.setLogisticsScore(0L);
			bzMerchantRate.setRatingNumber(0L);
			bzMerchantRateService.doSaveOrUpdate(bzMerchantRate);
		}
		bzMerchantRate.setDescriptionScore(bzMerchantRate.getDescriptionScore()
				+ bzMerchantRating.getDescriptionScore());
		bzMerchantRate.setAttitudeScore(bzMerchantRate.getAttitudeScore()
				+ bzMerchantRating.getAttitudeScore());
		bzMerchantRate.setDeliveryScore(bzMerchantRate.getDeliveryScore()
				+ bzMerchantRating.getDeliveryScore());
		bzMerchantRate.setLogisticsScore(bzMerchantRate.getLogisticsScore()
				+ bzMerchantRating.getLogisticsScore());
		bzMerchantRate.setRatingNumber(bzMerchantRate.getRatingNumber() + 1);
		bzMerchantRateService.doSaveOrUpdate(bzMerchantRate);
	}

}