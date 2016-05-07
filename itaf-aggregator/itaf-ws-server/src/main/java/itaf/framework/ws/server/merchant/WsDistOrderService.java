package itaf.framework.ws.server.merchant;

import itaf.framework.base.dto.WsPageResult;
import itaf.framework.merchant.dto.BzDistOrderDto;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace = "itaf.framework.ws.server.merchant")
public interface WsDistOrderService {

	public WsPageResult<BzDistOrderDto> findPager(
			@WebParam(name = "queryMapString") String queryMapString,
			@WebParam(name = "currentIndex") int currentIndex,
			@WebParam(name = "pageSize") int pageSize);

	public WsPageResult<BzDistOrderDto> getById(
			@WebParam(name = "bzDistOrderId") Long bzDistOrderId);

	public WsPageResult<String> startDist(
			@WebParam(name = "bzDistOrderId") Long bzDistOrderId);

}
