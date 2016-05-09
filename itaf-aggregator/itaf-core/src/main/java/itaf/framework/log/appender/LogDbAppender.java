package itaf.framework.log.appender;

import itaf.framework.log.bean.LogDbWorker;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

/**
 * Log4j的DB记录适配器,该记录适配器将log对象输出到Queue中
 * 
 * @author xiaoxiao
 */
public class LogDbAppender extends AppenderSkeleton {

	public LogDbAppender() {
		//
	}

	/**
	 * 添加log对象到Queue中
	 * 
	 * @param event
	 *            事件
	 * 
	 * 
	 */
	public void append(LoggingEvent event) {
		LogDbWorker.getWorker().getDbLogQueue().add(event);
	}

	/**
	 * DBAppender does't require a layout.
	 */
	public boolean requiresLayout() {
		return false;
	}

	/**
	 * 关闭资源
	 */
	public void close() {
		// TODO
	}

	/** closes the appender before disposal */
	public void finalize() {
		super.finalize();
		close();
	}

}
