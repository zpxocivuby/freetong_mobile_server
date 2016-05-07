package itaf.framework.web.converter;

import itaf.framework.core.util.StringHelper;
import itaf.framework.web.util.CodeListHelper;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * 
 * 
 * @author XINXIN
 * 
 * @Date 2014年6月10日
 */
@FacesConverter(value = "codeListConverter")
public class CodeListConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		return value;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		String typeAndCode = value.toString();
		if (StringHelper.isNotEmpty(typeAndCode)) {
			String codeType = typeAndCode
					.substring(0, typeAndCode.indexOf(","));
			String codeValue = typeAndCode
					.substring(typeAndCode.indexOf(",") + 1);
			return CodeListHelper.getNameByCodeValue(codeType, codeValue);
		}
		return "";
	}

}
