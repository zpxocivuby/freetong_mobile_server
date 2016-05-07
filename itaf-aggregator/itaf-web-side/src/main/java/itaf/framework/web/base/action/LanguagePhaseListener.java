package itaf.framework.web.base.action;

import itaf.framework.web.util.LocalLanguageHelper;

import java.util.Locale;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpServletRequest;

/**
 * 从Session中获取系统设置的语言，然后在beforePhase中重新设置给UIViewRoot
 * 
 * @author XINXIN
 * 
 * @Date 2014年7月8日
 */
public class LanguagePhaseListener implements PhaseListener {

	private static final long serialVersionUID = 1L;

	@Override
	public void afterPhase(PhaseEvent event) {
		// TODO Auto-generated method stub
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		// 呈现响应阶段,设置自选语言环境
		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		Locale locale = (Locale) request.getSession().getAttribute(
				LocalLanguageHelper.CURR_LOCAL_LANGUAGE);
		if (locale != null) {
			FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
		}

	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RENDER_RESPONSE;
	}

}
