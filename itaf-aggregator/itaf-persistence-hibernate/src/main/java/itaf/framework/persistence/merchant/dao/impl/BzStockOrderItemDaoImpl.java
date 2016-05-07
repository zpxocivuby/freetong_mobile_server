package itaf.framework.persistence.merchant.dao.impl;

import itaf.framework.domain.merchant.BzStockOrderItem;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.merchant.dao.IBzStockOrderItemDao;

import org.springframework.stereotype.Repository;

@Repository("bzStockOrderItemDaoImpl")
public class BzStockOrderItemDaoImpl extends BaseDaoImpl<BzStockOrderItem>
		implements IBzStockOrderItemDao {

}