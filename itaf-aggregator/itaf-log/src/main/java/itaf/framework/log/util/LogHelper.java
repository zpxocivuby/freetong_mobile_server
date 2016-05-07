package itaf.framework.log.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <p>
 * 该类是ITAF的日志输出工具类，该类是提供给开发人员方便的输出日志信息。
 * <p>
 * 为了控制输出的详细格式，可以在该类内进行格式的增加
 * 
 * @author xiaoxiao
 */
public class LogHelper {
	/**
	 * 
	 * 输出error级别的日志信息
	 * 
	 * @param logger
	 *            日志的logger
	 * @param obj
	 *            需要进行日志的对象
	 */
	public static void error(Log logger, Object obj) {
		// TODO 这里可以添加对Login User的支持
		logger.error(obj);
	}

	/**
	 * 输出error级别的日志信息
	 * 
	 * @param logger
	 *            日志的logger
	 * @param obj
	 *            需要进行日志的对象
	 * @param throwable
	 *            异常的抛出点
	 */
	public static void error(Log logger, Object obj, Throwable throwable) {
		// TODO 这里可以添加对Login User的支持
		logger.error(obj, throwable);
	}

	/**
	 * 
	 * 输出info级别的日志信息
	 * 
	 * @param logger
	 *            日志的logger
	 * @param obj
	 *            需要进行日志的对象
	 */
	public static void info(Log logger, Object obj) {
		// TODO 这里可以添加对Login User的支持
		if (logger.isInfoEnabled()) {
			logger.info(obj);
		}
	}

	/**
	 * 
	 * 输出info级别的日志信息
	 * 
	 * @param logger
	 *            日志的logger
	 * @param obj
	 *            需要进行日志的对象
	 * @param throwable
	 *            异常的抛出点
	 */
	public static void info(Log logger, Object obj, Throwable throwable) {
		// TODO 这里可以添加对Login User的支持
		if (logger.isInfoEnabled()) {
			logger.info(obj, throwable);
		}
	}

	/**
	 * 
	 * 输出debug级别的日志信息
	 * 
	 * @param logger
	 *            日志的logger
	 * @param obj
	 *            需要进行日志的对象
	 * 
	 */
	public static void debug(Log logger, Object obj) {
		// TODO 这里可以添加对Login User的支持
		if (logger.isDebugEnabled()) {
			logger.debug(obj);
		}
	}

	/**
	 * 
	 * 输出debug级别的日志信息
	 * 
	 * @param logger
	 *            日志的logger
	 * @param obj
	 *            需要进行日志的对象
	 * @param throwable
	 * 
	 *            异常的抛出点
	 */
	public static void debug(Log logger, Object obj, Throwable throwable) {
		// TODO 这里可以添加对Login User的支持
		if (logger.isDebugEnabled()) {
			logger.debug(obj, throwable);
		}
	}

	/**
	 * 
	 * 获取common logging 的log
	 * 
	 * @param class1
	 * @return
	 */
	public static Log getLog(Class<?> class1) {
		return LogFactory.getLog(class1);
	}

	/**
	 * 
	 * 获取common logging 的log
	 * 
	 * @param class1
	 * @return
	 */
	public static Log getLog(String class1) {
		return LogFactory.getLog(class1);
	}

}
