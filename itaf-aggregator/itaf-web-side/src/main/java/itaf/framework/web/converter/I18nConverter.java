package itaf.framework.web.converter;

import itaf.framework.core.util.StringHelper;
import itaf.framework.web.util.LocalLanguageHelper;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "i18nConverter")
public class I18nConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		// TODO Auto-generated method stub
		return value;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		String i18n = value.toString();
		if (StringHelper.isNotEmpty(i18n)) {
			int p = i18n.indexOf(",");
			if (LocalLanguageHelper.isLocalEn()) {
				return i18n.substring(p + 1);
			} else {
				return i18n.substring(0, p);
			}
		}
		return "";
	}

}
