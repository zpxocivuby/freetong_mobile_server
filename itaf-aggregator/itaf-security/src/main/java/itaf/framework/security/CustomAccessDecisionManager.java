package itaf.framework.security;

import itaf.framework.cache.business.service.ICacheUserService;
import itaf.framework.core.app.AppContext;
import itaf.framework.core.common.SessionUser;
import itaf.framework.core.util.SpringContextUtil;
import itaf.framework.domain.platform.SysUser;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

/**
 * 5验证权限
 * 
 * @author XINXIN
 * 
 * @update 2013-6-4
 */
public class CustomAccessDecisionManager implements AccessDecisionManager {

	private static final Log log = LogFactory
			.getLog(CustomAccessDecisionManager.class);

	public void decide(Authentication authentication, Object object,
			Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {
		if (configAttributes == null) {
			return;
		}
		// 所请求的资源拥有的权限(一个资源对多个权限)
		for (ConfigAttribute ca : configAttributes) {
			// 访问所请求资源所需要的权限
			log.info("needPermission is " + ca.getAttribute());
			// 用户所拥有的权限authentication
			for (GrantedAuthority ga : authentication.getAuthorities()) {
				if (ga.getAuthority().equals(ca.getAttribute())) {
					AppContext.setSessionUser(getSessionUser(authentication
							.getName()));
					return;
				}
			}
		}
		// 没有权限让我们去捕捉
		 throw new AccessDeniedException(" 没有权限访问！");
	}

	public boolean supports(ConfigAttribute attribute) {
		return true;
	}

	public boolean supports(Class<?> clazz) {
		return true;
	}

	private SessionUser getSessionUser(String username) {
		ICacheUserService ehCacheUserServiceImpl = (ICacheUserService) SpringContextUtil
				.getBean("ehCacheUserServiceImpl");
		SysUser user = ehCacheUserServiceImpl.getCacheByUsername(username);
		if (user == null) {
			return null;
		} else {
			SessionUser sessionUser = new SessionUser();
			sessionUser.setId(user.getId());
			sessionUser.setLoginId(username);
			sessionUser.setName(user.getUsername());
			sessionUser.setPassword(user.getPassword());
			return sessionUser;
		}
	}
}
