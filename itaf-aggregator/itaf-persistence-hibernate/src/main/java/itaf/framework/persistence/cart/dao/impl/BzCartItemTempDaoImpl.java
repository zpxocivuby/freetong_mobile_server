package itaf.framework.persistence.cart.dao.impl;

import itaf.framework.domain.cart.BzCartItemTemp;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.cart.dao.IBzCartItemTempDao;

import org.springframework.stereotype.Repository;

@Repository("bzCartItemTempDaoImpl")
public class BzCartItemTempDaoImpl extends BaseDaoImpl<BzCartItemTemp>
		implements IBzCartItemTempDao {

}