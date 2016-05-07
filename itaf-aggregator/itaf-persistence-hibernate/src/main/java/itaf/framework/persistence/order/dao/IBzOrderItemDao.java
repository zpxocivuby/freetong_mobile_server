package itaf.framework.persistence.order.dao;

import itaf.framework.domain.order.BzOrderItem;
import itaf.framework.persistence.base.dao.IBaseDao;

import java.util.List;

public interface IBzOrderItemDao extends IBaseDao<BzOrderItem> {

	public List<BzOrderItem> findByIds(List<Long> bzOrderItemIds);

}
