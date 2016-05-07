package itaf.framework.ws.server.platform;

import itaf.framework.base.dto.WsPageResult;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace = "itaf.framework.ws.server.platform")
public interface WsSysLogoutService {
	public WsPageResult<String> logout(@WebParam(name = "userId") Long userId);
}
