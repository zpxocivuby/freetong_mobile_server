package itaf.framework.persistence.product.dao.impl;

import itaf.framework.domain.product.BzProductRating;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.product.dao.IBzProductRatingDao;

import org.springframework.stereotype.Repository;

@Repository("bzProductRatingDaoImpl")
public class BzProductRatingDaoImpl extends BaseDaoImpl<BzProductRating>
		implements IBzProductRatingDao {

}