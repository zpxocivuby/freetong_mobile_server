package itaf.framework.business.merchant.service;

import itaf.framework.core.common.PageResult;
import itaf.framework.core.common.QueryCriteria;
import itaf.framework.domain.merchant.BzServiceProviderType;

import java.util.Date;
import java.util.List;

public interface IBzServiceProviderTypeService {

	PageResult<BzServiceProviderType> findByCriteria(QueryCriteria criteria);

	public List<BzServiceProviderType> findByUpdateTime(Date date);

}
