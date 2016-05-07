package itaf.framework.persistence.order.dao;

import java.util.List;

import itaf.framework.domain.order.BzOrder;
import itaf.framework.persistence.base.dao.IBaseDao;

public interface IBzOrderDao extends IBaseDao<BzOrder> {

	public List<BzOrder> findByIds(List<Long> bzOrderIds);
	
}
