package itaf.framework.ws.server.platform.impl;

import itaf.framework.base.dto.WsPageResult;
import itaf.framework.business.log.service.ISysUserAccLogService;
import itaf.framework.business.platform.service.ISysUserService;
import itaf.framework.domain.log.SysUserAccLog;
import itaf.framework.domain.platform.SysUser;
import itaf.framework.ws.server.base.impl.WsBaseImpl;
import itaf.framework.ws.server.platform.WsSysLogoutService;

import java.util.Date;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Service;

@Service("wsSysLogoutServiceImpl")
@WebService(endpointInterface = "itaf.framework.ws.server.platform.WsSysLogoutService", serviceName = "WsSysLogoutService")
public class WsSysLogoutServiceImpl extends WsBaseImpl<String> implements
		WsSysLogoutService {

	@Autowired
	private SessionRegistry sessionRegistry;

	@Autowired
	private ISysUserAccLogService sysUserAccLogService;

	@Autowired
	private ISysUserService userService = null;

	public WsPageResult<String> logout(Long userId) {
		WsPageResult<String> pr = new WsPageResult<String>();
		try {
			SysUser user = userService.findById(userId);
			SysUserAccLog sysUserAccLog = new SysUserAccLog();
			sysUserAccLog.setUsername(user.getUsername());
			sysUserAccLog.setLogoutTime(new Date());
			sysUserAccLog.setRemoteAddr("");
			sysUserAccLogService.doCreate(sysUserAccLog);
			pr.setStatus(WsPageResult.STATUS_SUCCESS);
		} catch (Exception e) {
			log.error(e);
			pr.setStatus(WsPageResult.STATUS_ERROR);
			pr.setErrorMsg("");
		}
		return pr;
	}

	@Override
	public String getObject() {
		return new String();
	}
}
