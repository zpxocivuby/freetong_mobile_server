package itaf.framework.ws.server.account;

import itaf.framework.account.dto.BzAccountDto;
import itaf.framework.base.dto.WsPageResult;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace = "itaf.framework.ws.server.account")
public interface WsAccountService {

	public WsPageResult<BzAccountDto> getById(
			@WebParam(name = "bzAccountId") Long bzAccountId);

}
