package itaf.framework.scheduler.web.util;

import itaf.framework.core.util.DateHelper;
import itaf.framework.exception.bean.AppException;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 数据处理
 * 
 * @author XINXIN
 * 
 */
public class DataProcessHelper {

	private static final Log log = LogFactory.getLog(DataProcessHelper.class);

	/**
	 * 对日期的处理 如果是当天日期，就显示时分秒 如果不是当天日期，就只显示年月日
	 * 
	 * @param date
	 * @return
	 */
	public static String hightLightTime(Date date) {
		if (date == null) {
			return "";
		}
		String targetDate = DateHelper.formatDate(date,
				DateHelper.FORMAT_DATE_YYYY_MM_DD);
		String now = DateHelper.formatDate(new Date(),
				DateHelper.FORMAT_DATE_YYYY_MM_DD);
		if (now.equals(targetDate)) {
			return DateHelper.formatDate(date, DateHelper.FORMAT_TIME_HH_MM_SS);
		}
		return targetDate;
	}

	/**
	 * 截取指定长度的字符串:一个中文输入占3个字符长度
	 * 
	 * EG:target = "中",maxBytes = 1,return ""; EG:target = "中",maxBytes =
	 * 3,return "中"; EG:target = "中文",maxBytes = 5,return "中"; EG:target =
	 * "中文",maxBytes = 6,return "中文";
	 * 
	 * @param target
	 *            目标字符串
	 * @param maxBytes
	 *            需要截取的长度（包含）
	 * @return 指定长度的字符串
	 */
	public static String truncateWhenUTF8(String target, int maxBytes) {
		if (StringUtils.isNotEmpty(target)
				&& target.getBytes().length > maxBytes) {
			int b = 0;
			for (int i = 0; i < target.length(); i++) {
				char c = target.charAt(i);
				int skip = 0;
				int more;
				if (c <= 0x007f) {
					more = 1;
				} else if (c <= 0x07FF) {
					more = 2;
				} else if (c <= 0xd7ff) {
					more = 3;
				} else if (c <= 0xDFFF) {
					// surrogate area, consume next char as well
					more = 4;
					skip = 1;
				} else {
					more = 3;
				}
				if (b + more > maxBytes) {
					return target.substring(0, i);
				}
				b += more;
				i += skip;
			}
		}
		return target;
	}

	/**
	 * 对字符串进行编码
	 * 
	 * @param target
	 *            处理的目标对象
	 * @param enc
	 *            默认utf-8
	 * @return String
	 */
	public static String encode(String target, String enc) {
		if (StringUtils.isEmpty(target)) {
			return "";
		}
		if (StringUtils.isEmpty(enc)) {
			enc = "utf-8";
		}
		String result = "";
		try {
			result = java.net.URLEncoder.encode(target, enc);
		} catch (UnsupportedEncodingException e) {
			log.error(e.getMessage(), e);
			throw new AppException("字符串：" + target + "编码为：" + enc + "失败!");
		}
		return result;
	}

	/**
	 * 对字符串进行解码
	 * 
	 * @param target
	 *            处理的目标对象
	 * @param enc
	 *            默认utf-8
	 * @return String
	 */
	public static String decode(String target, String enc) {
		if (StringUtils.isEmpty(target)) {
			return "";
		}
		if (StringUtils.isEmpty(enc)) {
			enc = "utf-8";
		}
		String result = "";
		try {
			result = java.net.URLDecoder.decode(target, enc);
		} catch (UnsupportedEncodingException e) {
			log.error(e.getMessage(), e);
			throw new AppException("字符串：" + target + "解码为：" + enc + "失败!");
		}
		return result;
	}

}
