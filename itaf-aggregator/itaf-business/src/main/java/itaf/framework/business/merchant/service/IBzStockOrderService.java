package itaf.framework.business.merchant.service;

import itaf.framework.domain.merchant.BzStockOrder;

import java.util.List;

public interface IBzStockOrderService {

	public List<BzStockOrder> findList(Long bzMerchantId);

	public BzStockOrder getById(Long bzStockOrderId);

	public void doCreateStockOrder(Long bzMerchantId, String bzOrderItemIds);

	public void doFinishedStockOrder(Long bzStockOrderId);

}
