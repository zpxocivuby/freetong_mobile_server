package itaf.framework.scheduler.web.util;

import java.util.Locale;

import javax.faces.context.FacesContext;

/**
 * <p>
 * Web用户帮助类，用来获取当前用户的相关信息</br>该类适用于Action层
 * </p>
 * 
 * @author XINXIN
 * 
 */
public class LocalLanguageHelper {

	public static final String CURR_LOCAL_LANGUAGE = "curr_local_language";

	/**
	 * 判断当前语言是否为英文,尽量避免使用在service层，如果使用在service层会照成测试困难
	 * 
	 * @return true 英文， false 中文
	 */
	public static boolean isLocalEn() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		String bundleName = facesContext.getApplication().getMessageBundle();
		if (bundleName != null) {
			Locale locale = facesContext.getViewRoot().getLocale();
			return !"zh".equalsIgnoreCase(locale.getLanguage());
		}
		return false;
	}

}
