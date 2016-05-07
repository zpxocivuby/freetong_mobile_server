package itaf.framework.scheduler.web.action.base;

import itaf.framework.core.app.AppContext;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class AbstractPageAction implements Serializable {

	private static final long serialVersionUID = 7581219928294281336L;

	public static final String ACTION_SUCCESS = "success";
	public static final String ACTION_ERROR = "error";

	private String actionMsg;

	private transient Log log = LogFactory.getLog(getClass());

	protected Log getLog() {
		if (log != null) {
			return log;
		} else {
			return LogFactory.getLog(getClass());
		}
	}

	public Long getCurrentUserId() {
		return AppContext.getSessionUser().getId();
	}

	protected FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}

	protected String getHttpMethod() {
		HttpServletRequest request = (HttpServletRequest) getFacesContext()
				.getExternalContext().getRequest();
		return request.getMethod();
	}

	public String getActionMsg() {
		return actionMsg;
	}

	public void setActionMsg(String actionMsg) {
		this.actionMsg = actionMsg;
	}

}
