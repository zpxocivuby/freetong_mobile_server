package itaf.framework.security.filter;

import itaf.framework.business.log.service.ISysUserAccLogService;
import itaf.framework.business.platform.service.ISysUserService;
import itaf.framework.core.app.AppContext;
import itaf.framework.core.common.SessionUser;
import itaf.framework.core.util.SpringContextUtil;
import itaf.framework.domain.log.SysUserAccLog;
import itaf.framework.domain.platform.SysUser;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 * 用户访问记录filter,用于记录每个访问用户的IP，时间等信息
 *
 *
 * @author XINXIN
 *
 * @UpdateDate 2014年8月4日
 */
public class WebAccessLogFilter implements javax.servlet.Filter {

	public static String ENABLE_LOG = "ENABLE_LOG";

	public static String ENABLE_LOG_FALSE = "false";

	public static String ENABLE_LOG_TRUE = "true";

	private String enableLog = "false";

	/**
	 * log4j 日志信息输出类
	 */
	private static Logger logger = Logger.getLogger(WebAccessLogFilter.class);

	/**
	 * 消亡方法
	 */
	public void destroy() {
		if (logger.isInfoEnabled()) {
			logger.info("UserAccessUrlLogFilter destroyed!");
		}
	}

	/*
	 * 进行Filter操作
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		if (ENABLE_LOG_TRUE.equals(enableLog)) {

			HttpServletRequest httpRequest = (HttpServletRequest) request;

			String fromIP = "";
			// 获取日志信息
			if (httpRequest != null) {
				String URL = httpRequest.getRequestURL().toString();
				fromIP = httpRequest.getLocalAddr();
				if (logger.isDebugEnabled()) {
					logger.debug("fromIP:" + fromIP);
					logger.debug("URL:" + URL);
				}
				String sessionId = httpRequest.getRequestedSessionId();
				String userName = httpRequest.getParameter("j_username");

				// 退出
				if (URL.indexOf("/j_spring_security_logout") > 0
						&& StringUtils.isNotEmpty(sessionId)) {
					SessionUser sysUser = AppContext.getSessionUser();
					if (sysUser != null) {
						SysUserAccLog sua = getISysUserAccLogService()
								.findBySessionIdAndUserName(sessionId,
										sysUser.getUsername());
						if (sua != null) {
							sua.setLogoutTime(new Date());
							getISysUserAccLogService().doCreate(sua);
						}
					}

				}
				// 登录
				if (URL.indexOf("/j_spring_security_check") > 0
						&& StringUtils.isNotEmpty(userName)) {
					SysUserAccLog sysUserAccLog = getISysUserAccLogService()
							.findBySessionIdAndUserName(sessionId, userName);
					if (sysUserAccLog == null) {
						sysUserAccLog = new SysUserAccLog();
						sysUserAccLog
								.setLoginResult(SysUserAccLog.LOGIN_RESULT_SUCCESS);
						sysUserAccLog.setLoginTime(new Date());
						sysUserAccLog.setRemoteAddr(URL);
						sysUserAccLog.setSessionId(sessionId);
						SysUser sysUser = getUserService().findByUsername(
								userName);
						if (sysUser != null) {
							sysUserAccLog.setSysUserId(sysUser.getId());
						} else {
							sysUserAccLog.setSysUserId(0L);
							sysUserAccLog
									.setLoginResult(SysUserAccLog.LOGIN_RESULT_FAILS);
						}
						sysUserAccLog.setTryCount(1L);
						sysUserAccLog.setUsername(userName);
						getISysUserAccLogService().doCreate(sysUserAccLog);
					} else {
						sysUserAccLog
								.setTryCount(sysUserAccLog.getTryCount() + 1);
						getISysUserAccLogService().doCreate(sysUserAccLog);
					}

				}
			}
		}
		chain.doFilter(request, response);
	}

	private ISysUserService getUserService() {
		ISysUserService userService = (ISysUserService) SpringContextUtil
				.getBean("sysUserServiceImpl");
		return userService;
	}

	private ISysUserAccLogService getISysUserAccLogService() {
		ISysUserAccLogService tlSysUserAccLogService = (ISysUserAccLogService) SpringContextUtil
				.getBean("sysUserAccLogServiceImpl");
		return tlSysUserAccLogService;
	}

	public String getEnableLog() {
		return enableLog;
	}

	/**
	 * 初始化
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		enableLog = filterConfig.getInitParameter(ENABLE_LOG);
		if (logger.isInfoEnabled()) {
			logger.info("UserAccessUrlLogFilter initialized!");
		}
	}

	public void setEnableLog(String enableLog) {
		this.enableLog = enableLog;
	}
}
