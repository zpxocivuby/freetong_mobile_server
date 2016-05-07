package itaf.framework.business.order.service;

import itaf.framework.domain.merchant.BzMerchantRating;
import itaf.framework.domain.product.BzProductRating;

import java.util.List;

public interface IBzOrderRatingService {

	void doRating(Long bzOrderId, BzMerchantRating bzMerchantRating,
			List<BzProductRating> bzProductRatings);

}
