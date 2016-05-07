package itaf.framework.persistence.merchant.dao.impl;

import itaf.framework.domain.merchant.BzStockOrder;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.merchant.dao.IBzStockOrderDao;

import org.springframework.stereotype.Repository;

@Repository("bzStockOrderDaoImpl")
public class BzStockOrderDaoImpl extends BaseDaoImpl<BzStockOrder> implements
		IBzStockOrderDao {

}