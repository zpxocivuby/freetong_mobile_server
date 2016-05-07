package itaf.framework.business.consumer.service;

import itaf.framework.core.common.PageResult;
import itaf.framework.core.common.QueryCriteria;
import itaf.framework.domain.consumer.BzUserAddress;

import java.util.List;

public interface IBzUserAddressService {

	PageResult<BzUserAddress> findByCriteria(QueryCriteria criteria);

	List<BzUserAddress> findList(Long bzConsumerId);

	BzUserAddress getById(Long bzUserAddressId);

	void doCreate(BzUserAddress bzUserAddress);

	void doUpdate(BzUserAddress bzUserAddress);

	void doDelete(BzUserAddress bzUserAddress);

	void doDeleteById(Long bzUserAddressId);

}
