package itaf.framework.security.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;

public interface AuthenticationService {

	/**
	 * 验证userName是否具有resCode权限
	 * 
	 * @param userName
	 *            用户登录名
	 * @param resCode
	 *            资源代码
	 * @return 有权限返回true否则false
	 */

	/*
	 * mobile app登陆验证方法
	 */
	//public boolean hasPermission(String userName, String resCode);
	/*public Authentication doMobileAuthenticate(String username,
			String password, String telephone,
			HttpServletRequest httpServletRequest);*/
	public void doMobileAuthenticate(String username,
			String password, String telephone);
}
