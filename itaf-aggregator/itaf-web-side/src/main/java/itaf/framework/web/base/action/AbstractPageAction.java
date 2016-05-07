package itaf.framework.web.base.action;

import itaf.framework.core.app.AppContext;

import java.io.Serializable;

import javax.faces.context.FacesContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.cxf.common.util.StringUtils;

public class AbstractPageAction implements Serializable {

	private static final long serialVersionUID = 1L;

	private transient Log log = LogFactory.getLog(getClass());

	public static final String ACTION_SUCCESS = "success";
	public static final String ACTION_ERROR = "error";
	// action级别的消息
	private String actionMsg;

	protected Log getLog() {
		if (log != null) {
			return log;
		}
		return LogFactory.getLog(getClass());
	}

	protected Long getCurrUserId() {
		return AppContext.getSessionUser().getId();
	}

	protected FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}

	protected String getContextPath() {
		return FacesContext.getCurrentInstance().getExternalContext()
				.getRequestContextPath();
	}

	public String getActionMsg() {
		return actionMsg;
	}

	public void setActionMsg(String actionMsg) {
		this.actionMsg = actionMsg;
	}

	protected String toLower(String name) {
		if (!StringUtils.isEmpty(name)) {
			name = name.toLowerCase();
		}
		return name;
	}

}
