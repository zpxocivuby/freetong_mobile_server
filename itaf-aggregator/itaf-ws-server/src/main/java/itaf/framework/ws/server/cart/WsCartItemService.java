package itaf.framework.ws.server.cart;

import itaf.framework.base.dto.WsPageResult;
import itaf.framework.cart.dto.BzCartItemDto;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace = "itaf.framework.ws.server.cart")
public interface WsCartItemService {

	public WsPageResult<BzCartItemDto> findList(
			@WebParam(name = "bzConsumerId") Long bzConsumerId);

	public WsPageResult<String> deleteByIds(
			@WebParam(name = "bzCartItemIds") String bzCartItemIds);

	public WsPageResult<BzCartItemDto> putProductInCart(
			@WebParam(name = "bzConsumerId") Long bzConsumerId,
			@WebParam(name = "bzProductId") Long bzProductId,
			@WebParam(name = "putType") int putType);

	public WsPageResult<String> updateItemNum(
			@WebParam(name = "bzCartItemId") Long bzCartItemId,
			@WebParam(name = "itemNum") Long itemNum);

}
