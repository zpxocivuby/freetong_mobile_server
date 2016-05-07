package itaf.framework.business.product.service.impl;

import itaf.framework.business.base.service.impl.BaseServiceImpl;
import itaf.framework.business.product.service.IBzProductRatingService;
import itaf.framework.domain.product.BzProductRating;
import itaf.framework.persistence.product.dao.IBzProductRatingDao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bzProductRatingServiceImpl")
public class BzProductRatingServiceImpl extends BaseServiceImpl implements
		IBzProductRatingService {

	@Autowired
	private IBzProductRatingDao bzProductRatingDao;

	@Override
	public void doRating(BzProductRating bzProductRating) {
		bzProductRatingDao.saveOrUpdate(bzProductRating);
	}

	@Override
	public void doRating(List<BzProductRating> bzProductRatings) {
		for (BzProductRating bzProductRating : bzProductRatings) {
			doRating(bzProductRating);
		}
	}

}