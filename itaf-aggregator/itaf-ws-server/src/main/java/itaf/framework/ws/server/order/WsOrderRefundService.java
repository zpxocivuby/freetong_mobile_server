package itaf.framework.ws.server.order;

import itaf.framework.base.dto.WsPageResult;
import itaf.framework.order.dto.BzOrderRefundDto;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace = "itaf.framework.ws.server.order")
public interface WsOrderRefundService {

	public WsPageResult<BzOrderRefundDto> findPager(
			@WebParam(name = "roleType") String roleType,
			@WebParam(name = "roleTypeValue") Long roleTypeValue,
			@WebParam(name = "refundStatus") Long refundStatus,
			@WebParam(name = "currentIndex") int currentIndex,
			@WebParam(name = "pageSize") int pageSize);

	public WsPageResult<String> applyRefund(
			@WebParam(name = "bzConsumerId") Long bzConsumerId,
			@WebParam(name = "bzOrderId") Long bzOrderId);

	public WsPageResult<String> cancelRefund(
			@WebParam(name = "bzConsumerId") Long bzConsumerId,
			@WebParam(name = "bzOrderRefundId") Long bzOrderRefundId);

	public WsPageResult<String> acceptRefund(
			@WebParam(name = "bzMerchantId") Long bzMerchantId,
			@WebParam(name = "bzOrderRefundId") Long bzOrderRefundId);

	public WsPageResult<String> rejectRefund(
			@WebParam(name = "bzMerchantId") Long bzMerchantId,
			@WebParam(name = "bzOrderRefundId") Long bzOrderRefundId);

}
