package itaf.framework.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * 1验证用户名和密码并验证
 * 
 * @author XINXIN
 * 
 * @update 2013-6-4
 */
public class CustomAuthenticationFilter extends
		UsernamePasswordAuthenticationFilter {

	private static final Log log = LogFactory
			.getLog(CustomAuthenticationFilter.class);

	private static final String USERNAME = "j_username";
	private static final String PASSWORD = "j_password";
	private static final String CAPTCHA = "j_captcha";

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request,
			HttpServletResponse response) throws AuthenticationException {
		if (!request.getMethod().equals("POST")) {
			throw new AuthenticationServiceException(
					"Authentication method not supported: "
							+ request.getMethod());
		}

		// 验证码验证 add@2014-04-29
		String captcha = (String) request.getSession().getAttribute(
				com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		String jCaptcha = obtainCaptcha(request).trim();
		// skip
		if (captcha == null) {
			// why?
		} else {
			if (jCaptcha == null || !jCaptcha.equalsIgnoreCase(captcha)) {
				// 验证码不正确
				// throw new InsufficientAuthenticationException("Bad captcha");
			}
		}

		String username = obtainUsername(request).trim();
		String password = obtainPassword(request).trim();
		log.debug("username is " + username);

		// 实现 Authentication
		UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
				username, password);
		Authentication auth = this.getAuthenticationManager().authenticate(
				authRequest);
		// 允许子类设置详细属性
		setDetails(request, authRequest);

		request.getSession().setAttribute("userPassword", password);

		// 运行UserDetailsService的loadUserByUsername 再次封装Authentication
		return auth;
	}

	protected String obtainCaptcha(HttpServletRequest request) {
		Object obj = request.getParameter(CAPTCHA);
		return null == obj ? "" : obj.toString();
	}

	@Override
	protected String obtainUsername(HttpServletRequest request) {
		Object obj = request.getParameter(USERNAME);
		return null == obj ? "" : obj.toString();
	}

	@Override
	protected String obtainPassword(HttpServletRequest request) {
		Object obj = request.getParameter(PASSWORD);
		return null == obj ? "" : obj.toString();
	}

	@Override
	protected void setDetails(HttpServletRequest request,
			UsernamePasswordAuthenticationToken authRequest) {
		super.setDetails(request, authRequest);
	}
}
