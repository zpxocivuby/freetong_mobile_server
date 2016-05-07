package itaf.framework.business.order.service;

import itaf.framework.domain.order.BzOrderItem;

import java.util.List;

public interface IBzOrderItemService {

	public List<BzOrderItem> findByIds(String bzOrderItemIds);

}
