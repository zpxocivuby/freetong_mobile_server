package itaf.framework.ws.server.base.impl;

import itaf.framework.core.util.DateHelper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <p>
 * Base web service class is a super class for all web service implementor
 * classes.
 * 
 * <p>
 * This class is intended to be sub-class ,and also intended to be extended in
 * the future.
 * 
 * @author Danne
 */
public abstract class WsBaseImpl<T> {

	/** log instance. */
	protected final Log log = LogFactory.getLog(getClass());

	// WS获取List的时候必须有一个获取该对象的方法
	public abstract T getObject();

	/**
	 * 处理日期
	 * 
	 * @param dateString
	 *            需要处理的时间字符串
	 * @return java.util.Date
	 */
	protected Date processDate(String dateString) {
		return processDate(dateString, DateHelper.FORMAT_DATE_YYYY_MM_DD);
	}

	/**
	 * 获取开始时间
	 * 
	 * @param dateString
	 *            需要处理的时间字符串
	 * @return java.util.Date, 格式是:yyyy-MM-dd 00:00:00
	 */
	protected Date processStartDate(String dateString) {
		Date dateObj = processDate(dateString);
		if (dateObj == null) {
			return null;
		}
		return DateHelper.parse(
				DateHelper.formatDate(dateObj, DateHelper.FORMAT_DATE_DEFAULT)
						+ " 00:00:00",
				DateHelper.FORMAT_DATETIME_YYYY_MM_DD_HH_MM_SS);
	}

	/**
	 * 获取结束时间
	 * 
	 * @param dateString
	 *            需要处理的时间字符串
	 * @return java.util.Date, 格式是:yyyy-MM-dd 23:59:59
	 */
	protected Date processEndDate(String dateString) {
		Date dateObj = processDate(dateString);
		if (dateObj == null) {
			return null;
		}
		return DateHelper.parse(
				DateHelper.formatDate(dateObj, DateHelper.FORMAT_DATE_DEFAULT)
						+ " 23:59:59",
				DateHelper.FORMAT_DATETIME_YYYY_MM_DD_HH_MM_SS);
	}

	/**
	 * 处理日期
	 * 
	 * @param dateString
	 *            需要处理的字符串
	 * @param datePattern
	 *            处理为什么格式，默认格式DateUtil.FORMAT_DATE_YYYY_MM_DD
	 * @return java.util.Date
	 */
	protected Date processDate(String dateString, String datePattern) {
		// 如果数据为空，直接返回
		if (StringUtils.isEmpty(dateString)) {
			return null;
		}
		if (StringUtils.isEmpty(datePattern)) {
			datePattern = DateHelper.FORMAT_DATE_YYYY_MM_DD;
		}
		return StringUtils.trimToNull(dateString) == null ? null : DateHelper
				.parse(dateString, datePattern);
	}

	/**
	 * 处理字符串
	 * 
	 * @param likeStirng
	 *            需要处理的字符串
	 * @param likeWhere
	 *            1:left, 2:right, 3:both
	 * @return String
	 */
	protected String processStirngLike(String likeStirng, int likeWhere) {
		if (StringUtils.isEmpty(likeStirng)) {
			return null;
		}
		if (likeWhere == 1) {
			likeStirng = "%" + likeStirng;
		} else if (likeWhere == 2) {
			likeStirng = likeStirng + "%";
		} else if (likeWhere == 3) {
			likeStirng = "%" + likeStirng + "%";
		}
		return likeStirng;
	}

	protected String encodeBase64(Object obj) {
		ByteArrayOutputStream baos = null;
		ObjectOutputStream oos = null;
		try {
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(obj);
			oos.flush();
			return new String(Base64.encodeBase64(baos.toByteArray()));
		} catch (IOException e) {
			log.error(e);
		} finally {
			if (baos != null) {
				try {
					baos.close();
				} catch (IOException e) {
					//
				}
			}
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					//
				}
			}
		}
		return null;
	}

	protected Object decodeBase64(String base64String) {
		Object dto = null;
		ByteArrayInputStream bais = null;
		ObjectInputStream ois = null;
		try {
			bais = new ByteArrayInputStream(Base64.decodeBase64(base64String));
			ois = new ObjectInputStream(bais);
			dto = ois.readObject();
			return dto;
		} catch (IOException e) {
			log.error(e);
		} catch (ClassNotFoundException e) {
			log.error(e);
		} finally {
			if (bais != null) {
				try {
					bais.close();
				} catch (IOException e) {
					//
				}
			}
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					//
				}
			}
		}
		return dto;
	}

}