package itaf.framework.security.service.impl;

import itaf.framework.business.base.service.impl.BaseServiceImpl;
import itaf.framework.business.log.service.ISysUserAccLogService;
import itaf.framework.business.platform.service.ISysBlackWhiteListService;
import itaf.framework.business.platform.service.ISysParameterService;
import itaf.framework.business.platform.service.ISysRoleService;
import itaf.framework.business.platform.service.ISysUserService;
import itaf.framework.cache.business.service.ICacheUserService;
import itaf.framework.core.util.SpringContextUtil;
import itaf.framework.domain.log.SysUserAccLog;
import itaf.framework.domain.platform.SysParameter;
import itaf.framework.im.server.xmpp.utils.XmppAccountManager;
import itaf.framework.persistence.im.dao.OfUserDao;
import itaf.framework.persistence.platform.dao.ISysParameterDao;
import itaf.framework.security.service.AuthenticationService;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Component;

@Component("authentiationService")
public class AuthenticationServiceImpl extends BaseServiceImpl implements
		AuthenticationService {

	@Autowired
	@Qualifier("customAuthenticationManager")
	private AuthenticationManager authenticationManager = null;

	@Autowired
	private ISysUserService userService = null;

	@Autowired
	private ICacheUserService ehCacheUserServiceImpl;

	@Autowired
	private ISysParameterDao tsParameterDao;

	@Autowired
	private ISysBlackWhiteListService whiteBlackListService;

	@Autowired
	private OfUserDao openfireOfUserDao;

	@Autowired
	private ISysParameterService parameterService;

	@Autowired
	private ISysRoleService roleService;

	@Autowired
	private ISysUserAccLogService sysUserAccLogService;

	private XmppAccountManager xmppAccountManager;

	public XmppAccountManager getXmppAccountManager() {
		if (xmppAccountManager == null) {
			xmppAccountManager = (XmppAccountManager) SpringContextUtil
					.getBean("xmppAccountManager");
		}
		return xmppAccountManager;
	}

	public void setXmppAccountManager(XmppAccountManager xmppAccountManager) {
		this.xmppAccountManager = xmppAccountManager;
	}

	public void doMobileAuthenticate(String username, String password,
			String telephone) {
		SysParameter tsParameter = tsParameterDao
				.findByType("WHITE_BLACK_LIST");
		// TODO
		if (tsParameter == null) {
			return;
		}
		whiteBlackListService.checkUser(username, telephone,
				tsParameter.getValue());

		/*
		 * List<OfUser> openfireOfUserList = openfireOfUserDao
		 * .findByUsername(username); if (openfireOfUserList == null ||
		 * openfireOfUserList.size() == 0) { Map<String, String> attMap = new
		 * HashMap<String, String>();
		 * this.getXmppAccountManager().createIMAccount(username, username,
		 * password, attMap); } else { openfireOfUserDao.changPassword(username,
		 * password);
		 * 
		 * }
		 */
		SysUserAccLog sysUserAccLog = new SysUserAccLog();
		sysUserAccLog.setUsername(username);
		sysUserAccLog.setLoginTime(new Date());
		sysUserAccLog.setRemoteAddr("11");
		sysUserAccLogService.doCreate(sysUserAccLog);
	}
}
