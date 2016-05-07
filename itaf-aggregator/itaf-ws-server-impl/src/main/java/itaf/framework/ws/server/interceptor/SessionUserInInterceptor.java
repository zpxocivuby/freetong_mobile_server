package itaf.framework.ws.server.interceptor;

import itaf.framework.core.app.AppContext;
import itaf.framework.core.common.SessionUser;
import itaf.framework.core.constant.Constants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.transport.http.AbstractHTTPDestination;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;

/**
 * 
 * SessionUser拦截器
 *
 * @author XINXIN
 *
 * @UpdateDate 2014年8月21日
 */
public class SessionUserInInterceptor extends WSS4JInInterceptor {

	@Autowired
	@Qualifier("customAuthenticationManager")
	private AuthenticationManager authenticationManager = null;

	public SessionUserInInterceptor() {
		//
	}

	@Override
	public void handleMessage(SoapMessage msg) throws Fault {
		// TODO处理Session超时
		HttpServletRequest httprequest = (HttpServletRequest) msg
				.get(AbstractHTTPDestination.HTTP_REQUEST);
		AppContext.setHttpServletRequest(httprequest);
		HttpSession session = httprequest.getSession();
		SessionUser sessionUser = (SessionUser) session
				.getAttribute(Constants.USER_KEY);
		AppContext.setSessionUser(sessionUser);
	}

	public void setAuthenticationManager(
			AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

}
