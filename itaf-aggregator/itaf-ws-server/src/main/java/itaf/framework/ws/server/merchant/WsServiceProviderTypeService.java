package itaf.framework.ws.server.merchant;

import itaf.framework.base.dto.WsPageResult;
import itaf.framework.merchant.dto.BzServiceProviderTypeDto;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace = "itaf.framework.ws.server.merchant")
public interface WsServiceProviderTypeService {
	public WsPageResult<BzServiceProviderTypeDto> syncToClient(@WebParam(name = "updateTime") String updateTime);
}
