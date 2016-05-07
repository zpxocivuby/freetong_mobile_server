package itaf.framework.persistence.merchant.dao.impl;

import itaf.framework.domain.merchant.BzMerchantRating;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.merchant.dao.IBzMerchantRatingDao;

import org.springframework.stereotype.Repository;

@Repository("bzMerchantRatingDaoImpl")
public class BzMerchantRatingDaoImpl extends BaseDaoImpl<BzMerchantRating>
		implements IBzMerchantRatingDao {

}