package itaf.framework.ws.server.merchant;

import itaf.framework.base.dto.WsPageResult;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace = "itaf.framework.ws.server.merchant")
public interface WsCollectionOrderService {

	public WsPageResult<String> confirmCollection(
			@WebParam(name = "bzCollectionOrderId") Long bzCollectionOrderId,
			@WebParam(name = "actualAmountString") String actualAmountString);

}
