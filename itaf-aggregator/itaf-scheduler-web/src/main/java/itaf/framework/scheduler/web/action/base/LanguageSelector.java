package itaf.framework.scheduler.web.action.base;

import itaf.framework.scheduler.web.util.LocalLanguageHelper;

import java.io.Serializable;
import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 * 改变系统语言
 * 
 * @author XINXIN
 * 
 * @Date 2014年7月7日
 */
@ManagedBean(name = "languageSelector")
@SessionScoped
public class LanguageSelector implements Serializable {

	private static final long serialVersionUID = 1L;

	public String selectLanguageZH() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.getViewRoot().setLocale(Locale.CHINESE);
		HttpServletRequest request = (HttpServletRequest) facesContext
				.getExternalContext().getRequest();
		request.getSession().setAttribute(
				LocalLanguageHelper.CURR_LOCAL_LANGUAGE, Locale.CHINESE);
		return "";
	}

	public String selectLanguageEN() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.getApplication().setDefaultLocale(Locale.ENGLISH);
		HttpServletRequest request = (HttpServletRequest) facesContext
				.getExternalContext().getRequest();
		request.getSession().setAttribute(
				LocalLanguageHelper.CURR_LOCAL_LANGUAGE, Locale.ENGLISH);
		return "";
	}

}
