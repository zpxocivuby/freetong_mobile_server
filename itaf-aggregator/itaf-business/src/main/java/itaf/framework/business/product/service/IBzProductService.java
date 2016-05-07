package itaf.framework.business.product.service;

import itaf.framework.core.common.PageResult;
import itaf.framework.core.common.QueryCriteria;
import itaf.framework.domain.product.BzProduct;

public interface IBzProductService {

	public PageResult<BzProduct> findByCriteria(QueryCriteria criteria);

	public BzProduct findById(Long bzProductId);

	public BzProduct getById(Long bzProductId);

	public void doSaveOrUpdate(BzProduct bzProduct, Long shelfNum, Long stockNum);

	public void doMarkForDelete(BzProduct bzProduct);

	public void doMarkForDeleteById(Long bzProductId);

	public void doMarkForDeleteByIds(String bzProductIds);

	public void doPutProductOnShelf(Long bzProductId, Long onShelfNumber);

	public void doPutProductsOnShelf(String bzProductIds);

	public void doRemoveProductFromShelf(Long bzProductId);

	public void doRemoveProductsFromShelf(String bzProductIds);

}
