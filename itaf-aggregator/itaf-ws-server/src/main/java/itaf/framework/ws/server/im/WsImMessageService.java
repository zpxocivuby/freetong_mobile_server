package itaf.framework.ws.server.im;

import itaf.framework.base.dto.WsPageResult;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace = "itaf.framework.ws.server.im")
public interface WsImMessageService {
	
	public WsPageResult<String> pushImMessage(
			@WebParam(name = "username") String username,
			@WebParam(name = "subject") String subject,
			@WebParam(name = "message") String message);
}
