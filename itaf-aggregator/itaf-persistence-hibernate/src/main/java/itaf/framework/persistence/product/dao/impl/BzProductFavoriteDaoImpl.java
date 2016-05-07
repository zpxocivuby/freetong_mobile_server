package itaf.framework.persistence.product.dao.impl;

import itaf.framework.domain.product.BzProductFavorite;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.product.dao.IBzProductFavoriteDao;

import org.springframework.stereotype.Repository;

@Repository("bzProductFavoriteDaoImpl")
public class BzProductFavoriteDaoImpl extends BaseDaoImpl<BzProductFavorite>
		implements IBzProductFavoriteDao {

}