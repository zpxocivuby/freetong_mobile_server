package itaf.framework.business.merchant.service;

import java.math.BigDecimal;

import itaf.framework.domain.merchant.BzCollectionOrder;

public interface IBzCollectionOrderService {

	public BzCollectionOrder getById(Long id);

	public void doSaveOrUpdate(BzCollectionOrder bzCollectionOrder);

	public void doConfirmCollection(Long bzCollectionOrderId,
			BigDecimal actualAmount);

}
