package itaf.framework.persistence.merchant.dao.impl;

import itaf.framework.domain.merchant.BzMerchantFavorite;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.merchant.dao.IBzMerchantFavoriteDao;

import org.springframework.stereotype.Repository;

@Repository("bzMerchantFavoriteDaoImpl")
public class BzMerchantFavoriteDaoImpl extends BaseDaoImpl<BzMerchantFavorite>
		implements IBzMerchantFavoriteDao {

}