package itaf.framework.scheduler.web.util;

import itaf.framework.core.common.QueryCriteria;
import itaf.framework.core.util.DateHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.faces.context.FacesContext;

import org.apache.commons.lang.StringUtils;

/**
 * Action中ProcessQueryCondiction的工具类
 * 
 * @author XINXIN 用来简化处理参数
 */
public class ProcessQueryUtil {

	/**
	 * 获取表单提交过来的值
	 * 
	 * @param value
	 * @return String
	 */
	public static String getValueOfForm(String value) {
		if (StringUtils.isEmpty(value)) {
			return "";
		}
		Map<String, String> paramsMap = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap();
		String result = paramsMap.get(value);
		if (StringUtils.isEmpty(result)) {
			String formId = getFormId(paramsMap, value);
			if (StringUtils.isNotEmpty(formId)) {
				result = paramsMap.get(formId + ":" + value);
			}
		}
		if (result == null) {
			result = "";
		}
		return result.trim();
	}

	/**
	 * 根据分隔符获取List
	 * 
	 * @param value
	 *            目标字符串
	 * @param regex
	 *            分隔符
	 * @return List<Long>
	 */
	public static List<Long> getIdsOfForm(String value, String regex) {
		String tagetIds = getValueOfForm(value);
		List<Long> result = null;
		if (StringUtils.isEmpty(tagetIds)) {
			return result;
		}
		result = new ArrayList<Long>();
		String[] tagetIdArr = tagetIds.split(regex);
		for (String tagetId : tagetIdArr) {
			if (StringUtils.trimToNull(tagetId) != null) {
				result.add(Long.valueOf(tagetId));
			}
		}
		return result;
	}

	private static String getFormId(Map<String, String> paramsMap, String value) {
		String formId = null;
		value = ":" + value;
		int len = value.length();
		Set<String> keys = paramsMap.keySet();
		for (Iterator<String> iterator = keys.iterator(); iterator.hasNext();) {
			String key = (String) iterator.next();
			if (key.endsWith(value)) {
				formId = key.substring(0, key.length() - len);
				break;
			}
		}
		return formId;
	}

	/**
	 * 处理日期
	 * 
	 * @param dateName
	 *            需要处理字符串名称
	 * @param pattern
	 *            处理为什么格式，默认格式DateUtil.FORMAT_DATE_YYYY_MM_DD
	 * @return 返回java.util.Date
	 */
	public static Date processDate(QueryCriteria queryCriteria, String dateName) {
		return processDate(queryCriteria, dateName,
				DateHelper.FORMAT_DATE_YYYY_MM_DD);
	}

	/**
	 * 获取开始时间
	 * 
	 * @param queryCriteria
	 * @param target
	 *            需要处理字符串名称
	 * @return 返回java.util.Date, 格式是:yyyy-MM-dd 00:00:00
	 */
	public static Date processStartDate(QueryCriteria queryCriteria,
			String target) {
		Date dateObj = processDate(queryCriteria, target);
		if (dateObj != null) {
			String resultString = DateHelper.formatDate(dateObj,
					DateHelper.FORMAT_DATE_DEFAULT);
			return DateHelper.parse(resultString + " 00:00:00",
					DateHelper.FORMAT_DATETIME_YYYY_MM_DD_HH_MM_SS);
		}
		return null;
	}

	/**
	 * 获取结束时间
	 * 
	 * @param queryCriteria
	 * @param target
	 *            需要处理字符串名称
	 * @return 返回java.util.Date, 格式是:yyyy-MM-dd 23:59:59
	 */
	public static Date processEndDate(QueryCriteria criteria, String target) {
		Date dateObj = processDate(criteria, target);
		if (dateObj == null) {
			dateObj = new Date();
		}
		String resultString = DateHelper.formatDate(dateObj,
				DateHelper.FORMAT_DATE_DEFAULT);
		return DateHelper.parse(resultString + " 23:59:59",
				DateHelper.FORMAT_DATETIME_YYYY_MM_DD_HH_MM_SS);
	}

	/**
	 * 处理日期
	 * 
	 * @param dateName
	 *            需要处理字符串名称
	 * @param pattern
	 *            处理为什么格式，默认格式DateUtil.FORMAT_DATE_YYYY_MM_DD
	 * @return 返回java.util.Date
	 */
	public static Date processDate(QueryCriteria queryCriteria,
			String dateName, String pattern) {
		// 如果数据为空，直接返回
		if (queryCriteria.getQueryCondition().get(dateName) == null) {
			return null;
		}
		Object dateNameObj = queryCriteria.getQueryCondition().get(dateName);
		if (StringUtils.isEmpty(pattern)) {
			pattern = DateHelper.FORMAT_DATE_YYYY_MM_DD;
		}
		String resultString = null;
		// 判断是不是java.util.Date的，如果是先格式化一下
		if (dateNameObj instanceof java.util.Date) {
			resultString = DateHelper.formatDate((java.util.Date) dateNameObj,
					pattern);
		} else if (dateNameObj instanceof java.lang.String) {
			resultString = dateNameObj.toString();
		}
		return StringUtils.trimToNull(resultString) == null ? null : DateHelper
				.parse(resultString, pattern);
	}

	/**
	 * 处理字符串
	 * 
	 * @param strName
	 *            需要处理字符串名称
	 * @return String
	 */
	public static String processString(QueryCriteria queryCriteria,
			String strName) {
		if (queryCriteria == null || queryCriteria.getQueryCondition() == null
				|| queryCriteria.getQueryCondition().isEmpty()
				|| queryCriteria.getQueryCondition().get(strName) == null) {
			return null;
		}
		return queryCriteria.getQueryCondition().get(strName).toString().trim();
	}

	/**
	 * 处理页面上的h:selectBooleanCheckbox值
	 * 
	 * @param queryCriteria
	 * @param strName
	 *            需要处理字符串名称
	 * @return 选中 true 未选中 false
	 */
	public static boolean processCheckbox(QueryCriteria queryCriteria,
			String strName) {
		boolean result = false;
		if (queryCriteria == null || queryCriteria.getQueryCondition() == null
				|| queryCriteria.getQueryCondition().isEmpty()
				|| queryCriteria.getQueryCondition().get(strName) == null) {
			return false;
		}
		result = (Boolean) queryCriteria.getQueryCondition().get(strName);
		return result;
	}

	/**
	 * 处理字符串
	 * 
	 * @param strName
	 *            需要处理字符串名称
	 * @param likeWhere
	 *            1:left, 2:right 3:all
	 * @return String
	 */
	public static String processStirngLike(QueryCriteria queryCriteria,
			String strName, int likeWhere) {
		String resultString = processString(queryCriteria, strName);
		if (StringUtils.isEmpty(resultString)) {
			return null;
		}
		if (likeWhere == 1) {
			resultString = "%" + resultString;
		} else if (likeWhere == 2) {
			resultString = resultString + "%";
		} else if (likeWhere == 3) {
			resultString = "%" + resultString + "%";
		}
		return resultString;
	}

	/**
	 * 
	 * @param strName
	 *            需要处理字符串名称
	 * @param likeWhere
	 *            1:left, 2:right 3:all
	 * @param lowerCase
	 *            1 返回小写， 2 返回大写
	 * @return String
	 */
	public static String processStirngLike(QueryCriteria queryCriteria,
			String strName, int likeWhere, int lowerCase) {
		String resultString = processStirngLike(queryCriteria, strName,
				likeWhere);
		if (StringUtils.isEmpty(resultString)) {
			return null;
		}
		if (lowerCase == 1) {
			return resultString.toLowerCase();
		} else if (lowerCase == 2) {
			return resultString.toUpperCase();
		} else {
			return resultString;
		}
	}

	public static Long processLong(QueryCriteria queryCriteria, String strName) {
		String strNameValue = processString(queryCriteria, strName);
		if (StringUtils.isEmpty(strNameValue)) {
			return null;
		}
		return Long.valueOf(strNameValue);
	}

	public static Integer processInteger(QueryCriteria queryCriteria,
			String strName) {
		String strNameValue = processString(queryCriteria, strName);
		if (StringUtils.isEmpty(strNameValue) || "0".equals(strNameValue)) {
			return null;
		}
		return Integer.valueOf(strNameValue);
	}

	/**
	 * 
	 * @param queryCriteria
	 * @param strName
	 * @param sign
	 *            >,>=,==,<,<=,!=
	 * 
	 * @return Long
	 */
	public static Long processLong(QueryCriteria queryCriteria, String strName,
			String sign) {
		String strNameValue = processString(queryCriteria, strName);
		if (StringUtils.isNotEmpty(strNameValue)) {
			Long result = Long.valueOf(strNameValue);

			if (StringUtils.trimToNull(sign) == null) {
				return processLong(queryCriteria, strNameValue);
			}
			sign = sign.trim();
			if (">".equals(sign) && result > 0) {
				return result;
			}
			if (">=".equals(sign) && result >= 0) {
				return result;
			}
			if ("==".equals(sign) && result == 0) {
				return result;
			}
			if ("!=".equals(sign) && result != 0) {
				return result;
			}
			if ("<".equals(sign) && result < 0) {
				return result;
			}
			if ("<=".equals(sign) && result <= 0) {
				return result;
			}
		}
		return null;
	}
}