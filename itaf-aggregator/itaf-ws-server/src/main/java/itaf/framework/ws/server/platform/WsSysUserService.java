package itaf.framework.ws.server.platform;

import itaf.framework.base.dto.WsPageResult;
import itaf.framework.platform.dto.SysUserDto;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace = "itaf.framework.ws.server.platform")
public interface WsSysUserService {

	public WsPageResult<SysUserDto> getById(
			@WebParam(name = "sysUserId") Long sysUserId);

}
