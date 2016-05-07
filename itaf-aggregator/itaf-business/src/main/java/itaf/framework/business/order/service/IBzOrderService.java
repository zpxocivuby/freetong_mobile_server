package itaf.framework.business.order.service;

import itaf.framework.core.common.PageResult;
import itaf.framework.core.common.QueryCriteria;
import itaf.framework.domain.order.BzOrder;

import java.util.List;

public interface IBzOrderService {

	PageResult<BzOrder> findByCriteria(QueryCriteria criteria);

	List<BzOrder> findByIds(String bzOrderIds);

	BzOrder getById(Long bzOrderId);

	void doSubmitOrder(BzOrder bzOrder, List<Long> bzCartItemIds);

	void doUpdateStatus(Long bzOrderId, Long orderStatus);

	void doConfirmReceived(Long bzOrderId);

}
