package itaf.framework.business.merchant.service;

import itaf.framework.core.common.PageResult;
import itaf.framework.core.common.QueryCriteria;
import itaf.framework.domain.merchant.BzUserDeliveryAddress;

import java.util.List;

public interface IBzUserDeliveryAddressService {

	PageResult<BzUserDeliveryAddress> findByCriteria(QueryCriteria criteria);

	List<BzUserDeliveryAddress> findList(Long bzMerchantId);

	BzUserDeliveryAddress getById(Long bzUserDeliveryAddressId);

	void doCreate(BzUserDeliveryAddress bzUserDeliveryAddress);

	void doUpdate(BzUserDeliveryAddress bzUserDeliveryAddress);

	void doDelete(BzUserDeliveryAddress bzUserDeliveryAddress);

	void doDeleteById(Long bzUserDeliveryAddressId);
	
}
