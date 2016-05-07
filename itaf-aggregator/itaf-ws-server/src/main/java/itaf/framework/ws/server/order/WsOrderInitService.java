package itaf.framework.ws.server.order;

import itaf.framework.base.dto.WsPageResult;
import itaf.framework.order.dto.BzOrderInitDto;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace = "itaf.framework.ws.server.order")
public interface WsOrderInitService {

	public WsPageResult<BzOrderInitDto> orderCreateInit(
			@WebParam(name = "userId") Long userId);

}
