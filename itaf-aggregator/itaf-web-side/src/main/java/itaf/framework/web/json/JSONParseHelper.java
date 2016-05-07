package itaf.framework.web.json;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;
import net.sf.json.util.JSONUtils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class JSONParseHelper {
	private static final Log log = LogFactory.getLog(JSONParseHelper.class);

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List json2Java(String json, Class clz) {
		List list = new ArrayList();
		// try {
		if (json != null) {
			JSONArray array = JSONArray.fromObject(json);
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.setRootClass(clz);
			jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.NOPROP);
			for (int i = 0; i < array.size(); i++) {
				list.add(JSONObject.toBean(array.getJSONObject(i), jsonConfig));
			}
		}
		// } finally {
		// JSONObject.clearLinkIndex();
		// }

		return list;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List json2Java(String json, Class clz, Map classMap) {
		List list = new ArrayList();
		try {
			if (json != null) {
				JSONArray array = JSONArray.fromObject(json);
				JsonConfig jsonConfig = new JsonConfig();
				jsonConfig.setRootClass(clz);
				jsonConfig.setClassMap(classMap);

				jsonConfig
						.setCycleDetectionStrategy(CycleDetectionStrategy.NOPROP);
				for (int i = 0; i < array.size(); i++) {
					list.add(JSONObject.toBean(array.getJSONObject(i),
							jsonConfig));
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			// } finally {
			// JSONObject.clearLinkIndex();
		}
		return list;
	}

	/**
	 * Generate a default jsonconfig from given filter properties and
	 * datePattern
	 * 
	 * @param properties
	 *            the column names to include in the json parse.
	 * @param datePattern
	 *            date pattern for date conversion, could be null.
	 * @return a jsonConfig
	 */
	public static JsonConfig generateJsonConfig(final Set<String> properties,
			String datePattern) {
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setJsonPropertyFilter(new ExcludeOtherThanPropertyFilter(
				properties));
		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.NOPROP);

		jsonConfig.setIgnoreDefaultExcludes(false);
		jsonConfig.registerJsonValueProcessor(Date.class,
				new PatternStringDateJsonValueProcessor(datePattern));
		jsonConfig
				.setJsonBeanProcessorMatcher(new HibernateJsonBeanProcessorMatcher());
		return jsonConfig;
	}

	public static String java2Json(Object javaObject,
			final Set<String> properties, String datePattern) {

		String result = null;
		// try {

		if (JSONUtils.isArray(javaObject)) {
			JSONArray jsonArray = JSONArray.fromObject(javaObject,
					generateJsonConfig(properties, datePattern));
			result = jsonArray.toString();
		} else {
			JSONObject jsonObject = JSONObject.fromObject(javaObject,
					generateJsonConfig(properties, datePattern));
			result = jsonObject.toString();
		}

		if (log.isDebugEnabled()) {
			log.debug("JSON Conversion Result: " + result);
		}

		// } finally {
		// JSONObject.clearLinkIndex();
		// }
		return result;
	}

}
