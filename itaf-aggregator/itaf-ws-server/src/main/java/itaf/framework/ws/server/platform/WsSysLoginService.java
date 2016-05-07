package itaf.framework.ws.server.platform;

import itaf.framework.base.dto.WsPageResult;
import itaf.framework.platform.dto.SysUserDto;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace = "itaf.framework.ws.server.platform")
public interface WsSysLoginService {

	public WsPageResult<SysUserDto> login(
			@WebParam(name = "username") String username,
			@WebParam(name = "password") String password,
			@WebParam(name = "mobile") String mobile);

}