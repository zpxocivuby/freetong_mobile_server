package itaf.framework.ws.server.merchant;

import itaf.framework.base.dto.WsPageResult;
import itaf.framework.merchant.dto.BzStockOrderDto;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace = "itaf.framework.ws.server.merchant")
public interface WsStockOrderService {

	public WsPageResult<BzStockOrderDto> getList(
			@WebParam(name = "bzMerchantId") Long bzMerchantId);

	public WsPageResult<BzStockOrderDto> getById(
			@WebParam(name = "bzStockOrderId") Long bzStockOrderId);

	public WsPageResult<String> createStockOrder(
			@WebParam(name = "bzMerchantId") Long bzMerchantId,
			@WebParam(name = "bzOrderItemIds") String bzOrderItemIds);

	public WsPageResult<String> finishedStockOrder(
			@WebParam(name = "bzStockOrderId") Long bzStockOrderId);

}
