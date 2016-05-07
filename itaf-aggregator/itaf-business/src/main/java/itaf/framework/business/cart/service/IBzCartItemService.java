package itaf.framework.business.cart.service;

import itaf.framework.domain.cart.BzCartItem;

import java.util.List;

public interface IBzCartItemService {

	public BzCartItem doPutProductInCart(Long bzConsumerId, Long bzProductId,
			int putType);

	public void doUpdateItemNum(Long bzCartItemId, Long itemNum);

	public void doDelete(BzCartItem bzCartItem);

	public void doDeleteByIds(String bzCartItemIds);

	public BzCartItem getById(Long bzCartItemId);

	public List<BzCartItem> findList(Long userId);

	public void doMarkForValid(Long bzProductId);

	public void doMarkForInvalid(Long bzProductId);

}
