package itaf.framework.log.bean;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * log4j的日志队列,IMES系统的单独实现
 * 
 * @author xiaoxiao
 */
public class LogQueue {

	/**
	 * log4j的日志记录类
	 */
	private final Logger log = Logger.getLogger(getClass());

	/**
	 * 用于保存log对象的list
	 */
	private List<Object> container = new LinkedList<Object>();

	/**
	 * 
	 * 移除一个log对象
	 * 
	 * @return log对象
	 */
	public synchronized Object get() {
		while (container.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException ie) {
				log.debug("exception happened", ie);
			}
		}
		return container.remove(0);
	}

	/**
	 * 
	 * 添加一个log对象
	 * 
	 * @param obj
	 *            被添加的log对象
	 */
	public synchronized void add(Object obj) {
		if (obj == null) {
			return;
		}
		container.add(obj);
		notify();
	}
}