package itaf.framework.business.order.service.impl;

import itaf.framework.business.base.service.impl.BaseServiceImpl;
import itaf.framework.business.merchant.service.IBzMerchantRatingService;
import itaf.framework.business.order.service.IBzOrderRatingService;
import itaf.framework.business.order.service.IBzOrderService;
import itaf.framework.business.product.service.IBzProductRatingService;
import itaf.framework.domain.merchant.BzMerchantRating;
import itaf.framework.domain.product.BzProductRating;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bzOrderRatingServiceImpl")
public class BzOrderRatingServiceImpl extends BaseServiceImpl implements
		IBzOrderRatingService {

	@Autowired
	private IBzOrderService bzOrderService;
	@Autowired
	private IBzMerchantRatingService bzMerchantRatingService;
	@Autowired
	private IBzProductRatingService bzProductRatingService;

	public void doRating(Long bzOrderId, BzMerchantRating bzMerchantRating,
			List<BzProductRating> bzProductRatings) {
		bzOrderService.doUpdateStatus(bzOrderId, 7L);
		bzMerchantRatingService.doRating(bzMerchantRating);
		bzProductRatingService.doRating(bzProductRatings);
	}

}