package itaf.framework.core.app;

import itaf.framework.core.common.SessionUser;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * 应用Context,包含当前用户相关的所有信息
 * 
 * 
 */
public final class AppContext {

	/**
	 * 当前线程中的用户信息
	 */
	private static final ThreadLocal<SessionUser> currentUser = new ThreadLocal<SessionUser>();

	/**
	 * 当前线程中的request信息
	 */
	private static final ThreadLocal<HttpServletRequest> currentRequest = new ThreadLocal<HttpServletRequest>();

	/**
	 * 默认的Locale设置
	 */
	private static Locale DEFAULT_LOCALE = Locale.CHINA;

	/**
	 * 获取当前登录用户的locale
	 * 
	 * @return
	 */
	public Locale getCurrentLocale() {

		if (getSessionUser() == null) {
			return DEFAULT_LOCALE;
		} else {
			Locale locale = getSessionUser().getPreferredLocale();
			return (null == locale) ? DEFAULT_LOCALE : locale;
		}
	}

	/**
	 * 设置用户信息
	 * 
	 * @param userInfo
	 *            用户信息
	 */
	public static void setSessionUser(SessionUser userInfo) {
		currentUser.set(userInfo);
	}

	/**
	 * 返回当前用户信息
	 * 
	 * @return
	 */
	public static SessionUser getSessionUser() {
		if (currentUser != null && currentUser.get() != null) {
			return currentUser.get();
		} else {
			return new SessionUser();
		}

	}

	public static void cleanUser() {
		currentUser.set(null);
	}

	/**
	 * 设置request信息
	 * 
	 * @param request
	 *            request信息
	 */
	public static void setHttpServletRequest(HttpServletRequest request) {
		currentRequest.set(request);
	}

	/**
	 * 返回当前request信息
	 * 
	 * @return
	 */
	public static HttpServletRequest getHttpServletRequest() {
		if (currentRequest != null && currentRequest.get() != null) {
			return currentRequest.get();
		} else {
			return null;
		}

	}

}
