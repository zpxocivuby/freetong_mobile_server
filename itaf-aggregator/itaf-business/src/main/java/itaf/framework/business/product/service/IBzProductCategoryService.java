package itaf.framework.business.product.service;

import itaf.framework.core.common.PageResult;
import itaf.framework.core.common.QueryCriteria;
import itaf.framework.domain.product.BzProductCategory;

import java.util.List;

public interface IBzProductCategoryService {

	PageResult<BzProductCategory> findByCriteria(QueryCriteria criteria);

	public BzProductCategory getById(Long id);

	public List<BzProductCategory> getByIds(List<Long> ids);

}
