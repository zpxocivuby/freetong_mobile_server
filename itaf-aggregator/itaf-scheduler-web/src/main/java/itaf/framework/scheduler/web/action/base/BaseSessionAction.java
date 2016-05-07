package itaf.framework.scheduler.web.action.base;

import java.io.Serializable;
import java.util.Enumeration;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * 
 * 
 * 
 * @author XINXIN
 * 
 * @updateDate 2014年2月28日
 */
@ManagedBean(name = "baseSession")
@SessionScoped
public class BaseSessionAction implements Serializable {

	private static final long serialVersionUID = 1130785257122033726L;

	private static Log log = LogFactory.getLog(BaseSessionAction.class);

	public BaseSessionAction() {
		log.debug("Base Session Inited");
	}

	private String contextPath = null;

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}

	/**
	 * 返回当前FacesContext所在应用的根目录，格式如：/itaf
	 * 
	 * @return context root
	 */
	public String getContextPath() {
		if (contextPath == null) {
			contextPath = FacesContext.getCurrentInstance()
					.getExternalContext().getRequestContextPath();
		}
		return contextPath;
	}

	/**
	 * Servlet API Convenience method
	 * 
	 * @return HttpServletRequest from the FacesContext
	 */
	public HttpServletRequest getRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance()
				.getExternalContext().getRequest();
	}

	/**
	 * 获得当前页面调用的参数，即url的?及之后的部分
	 * 
	 * @return 格式为"?param1=value1&param2=value2"
	 */
	@SuppressWarnings("unchecked")
	public String getParamStr() {
		Enumeration<String> name_enums = getRequest().getParameterNames();
		int k = 0;
		String param_str = "";

		while (name_enums.hasMoreElements()) {
			String param_name = name_enums.nextElement();
			String param_value = getRequest().getParameter(param_name);
			if (k > 0)
				param_str += "&";
			param_str += param_name + "=" + param_value;
			k++;
		}

		if (param_str.length() > 0)
			param_str = "?" + param_str;

		return param_str;
	}

}
