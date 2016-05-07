package itaf.framework.core.util;

/**
 * 字符串工具类
 * 
 * @author XINXIN
 * 
 * @Date 2014年6月5日
 */
public final class StringsHelper {

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

}
