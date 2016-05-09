package itaf.framework.core.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * 字符串工具类
 * 
 * @author XINXIN
 * 
 * @Date 2014年6月5日
 */
public final class StringHelper {

	public static final char SEPARATOR = '|';

	public static String trimToEmpty(String value) {
		return (value == null) ? "" : value.trim();
	}

	public static boolean isEmpty(String value) {
		return value == null || "".equals(value.trim());
	}

	public static boolean isNotEmpty(String value) {
		return value != null && value.trim().length() > 0;
	}

	public static String longToString(Long str) {
		return str == null ? "" : str.toString();
	}

	public static List<Long> stringToLongList(String str) {
		return stringToLongList(str, ",");
	}

	public static List<Long> stringToLongList(String str, String sep) {
		if (str == null) {
			return null;
		}
		List<Long> ll = new ArrayList<Long>();
		for (String lstr : StringUtils.split(str, sep)) {
			ll.add(Long.valueOf(lstr));
		}
		return ll;
	}
}
