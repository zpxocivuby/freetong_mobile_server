package itaf.framework.persistence.cart.dao.impl;

import itaf.framework.domain.cart.BzCartItem;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.cart.dao.IBzCartItemDao;

import org.springframework.stereotype.Repository;

@Repository("bzCartItemDaoImpl")
public class BzCartItemDaoImpl extends BaseDaoImpl<BzCartItem> implements
		IBzCartItemDao {

}