package itaf.framework.ws.server.order;

import itaf.framework.base.dto.WsPageResult;
import itaf.framework.order.dto.BzOrderDto;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace = "itaf.framework.ws.server.order")
public interface WsOrderService {

	public WsPageResult<BzOrderDto> findPager(
			@WebParam(name = "roleType") String roleType,
			@WebParam(name = "roleTypeValue") Long roleTypeValue,
			@WebParam(name = "orderStatus") Long orderStatus,
			@WebParam(name = "currentIndex") int currentIndex,
			@WebParam(name = "pageSize") int pageSize);

	public WsPageResult<BzOrderDto> getById(
			@WebParam(name = "bzOrderId") Long bzOrderId);

	public WsPageResult<BzOrderDto> submitOrder(
			@WebParam(name = "dtoString") String dtoString);

	public WsPageResult<String> confirmReceived(
			@WebParam(name = "bzOrderId") Long bzOrderId);

	public WsPageResult<String> orderRating(
			@WebParam(name = "bzOrderId") Long bzOrderId,
			@WebParam(name = "dtoString") String dtoString);

}
