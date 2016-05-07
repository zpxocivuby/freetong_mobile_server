package itaf.framework.ws.server.order;

import itaf.framework.base.dto.WsPageResult;
import itaf.framework.order.dto.BzPaymentTypeDto;

import javax.jws.WebService;

@WebService(targetNamespace = "itaf.framework.ws.server.order")
public interface WsPaymentTypeService {
	public WsPageResult<BzPaymentTypeDto> findList();
}
