package itaf.framework.log.bean;

import org.apache.log4j.Logger;

/**
 * log4j向DB写数据的操作类
 * 
 * @author xiaoxiao
 */
public class LogDbWorker extends Thread {

	/**
	 * log4j记录类
	 */
	private static Logger log = Logger.getLogger(LogDbWorker.class);

	/**
	 * Log4jDBLogWorker实例
	 */
	private static LogDbWorker worker = null;

	/**
	 * LogQueue 用于保存log操作的queue
	 */
	private LogQueue dbLogQueue;

	/**
	 * 停止标志
	 */
	private boolean stop = false;

	/**
	 * 构造函数
	 * 
	 */
	private LogDbWorker() {
		dbLogQueue = new LogQueue();
	}

	/**
	 * 
	 * 获取LogDbWorker实例对象
	 * 
	 * @return LogDbWorker对象
	 */
	public static synchronized LogDbWorker getWorker() {
		if (worker == null) {
			worker = new LogDbWorker();
			worker.start();
		}
		return worker;
	}

	/**
	 * 进行日志DB写操作
	 */
	public void run() {
		while (!stop) {
			try {
				//LoggingEvent event = (LoggingEvent) dbLogQueue.get();
				//Object msg = event.getMessage();
				//log.info(msg);
				// TODO
			} catch (Throwable t) {
				log.warn("Exception happened", t);
			}
		}
	}

	/**
	 * 
	 * 设置停止状态
	 */
	public void setStop(boolean stop) {
		this.stop = stop;
	}

	/**
	 * 
	 * get LogQueue方法
	 * 
	 * @return LogQueue
	 */
	public LogQueue getDbLogQueue() {
		return dbLogQueue;
	}

	/**
	 * 
	 * set LogQueue方法
	 * 
	 * @param queue
	 */
	public void setDbLogQueue(LogQueue queue) {
		this.dbLogQueue = queue;
	}

}
