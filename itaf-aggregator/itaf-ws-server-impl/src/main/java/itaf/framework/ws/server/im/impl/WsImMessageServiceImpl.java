package itaf.framework.ws.server.im.impl;

import itaf.framework.base.dto.WsPageResult;
import itaf.framework.business.base.service.impl.BaseServiceImpl;
import itaf.framework.business.platform.service.ISysUserService;
import itaf.framework.core.util.SpringContextUtil;
import itaf.framework.domain.platform.SysUser;
import itaf.framework.im.server.xmpp.XmppConnectionManager;
import itaf.framework.im.server.xmpp.utils.XmppMessageUtils;
import itaf.framework.ws.server.im.WsImMessageService;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("wsImMessageServiceImpl")
@WebService(endpointInterface = "itaf.framework.ws.server.im.WsImMessageService", serviceName="WsImMessageService")
public class WsImMessageServiceImpl extends BaseServiceImpl implements
		WsImMessageService {

	@Autowired
	ISysUserService userService;

	@Autowired
	private XmppConnectionManager connectionManager;

	public XmppConnectionManager getConnectionManager() {
		if (connectionManager == null) {
			connectionManager = (XmppConnectionManager) SpringContextUtil
					.getBean("xmppConnectionManager");
		}
		return connectionManager;
	}

	public void setConnectionManager(XmppConnectionManager connectionManager) {
		this.connectionManager = connectionManager;
	}

	XmppMessageUtils xmppMessageUtils;

	public XmppMessageUtils getXmppMessageUtils() {
		if (xmppMessageUtils == null) {
			xmppMessageUtils = (XmppMessageUtils) SpringContextUtil
					.getBean("xmppMessageUtils");
		}
		return xmppMessageUtils;
	}

	public void setXmppMessageUtils(XmppMessageUtils xmppMessageUtils) {
		this.xmppMessageUtils = xmppMessageUtils;
	}

	public WsPageResult<String> pushImMessage(
			@WebParam(name = "username") String username,
			@WebParam(name = "subject") String subject,
			@WebParam(name = "message") String message) {
		WsPageResult<String> pr = new WsPageResult<String>();
		SysUser user = null;
		String adminPassword = "";
		String adminUsername = "";
		boolean isSuccess = true;
		String errorMessage = "";
		try {
			user = userService.findByUsername(username); 
			if (user == null) {
				throw new Exception("no user");
			}

			// 发送
			this.getConnectionManager().doLogon(adminUsername, adminPassword);
			this.getXmppMessageUtils().sendMessageToUser(adminUsername,
					username, message, subject);
			this.getConnectionManager().doLogout(adminUsername, "");

		} catch (Exception e) {
			log.error(e.toString());
			isSuccess = false;
			errorMessage = e.toString();
		}

		if (isSuccess) {
			pr.setStatus("1");
		} else {
			pr.setStatus("0");
			pr.setStatusCode(errorMessage);
		}
		return pr;
	}
}
