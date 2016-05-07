package itaf.framework.persistence.order.dao.impl;

import itaf.framework.domain.order.BzOrderHistory;
import itaf.framework.persistence.base.dao.impl.BaseDaoImpl;
import itaf.framework.persistence.order.dao.IBzOrderHistoryDao;

import org.springframework.stereotype.Repository;

@Repository("bzOrderHistoryDaoImpl")
public class BzOrderHistoryDaoImpl extends BaseDaoImpl<BzOrderHistory>
		implements IBzOrderHistoryDao {

}