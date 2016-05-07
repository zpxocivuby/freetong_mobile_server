package itaf.framework.business.product.service;

import itaf.framework.domain.product.BzProductRating;

import java.util.List;

public interface IBzProductRatingService {

	void doRating(BzProductRating bzProductRating);

	void doRating(List<BzProductRating> bzProductRatings);

}
