/**********************************************************************
 * FILE : ITAFBaseJob.java
 * CREATE DATE : 2009-1-8
 * DESCRIPTION :
 *		ITAF base job bean extends QuartzJobBean and implements StatefulJob for 
 *		<p>
 *		 execute one by one
 *      
 * CHANGE HISTORY LOG
 *---------------------------------------------------------------------
 * NO.|    DATE    |     NAME     |     REASON     | DESCRIPTION
 *---------------------------------------------------------------------
 * 1  | 2009-1-8 |  xiaoxiao  |    创建草稿版本
 *---------------------------------------------------------------------              
 **********************************************************************
 */
/**
 * 
 */
package itaf.framework.scheduler.job;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * <p>
 * IMES base job bean extends QuartzJobBean for
 * <p>
 * execute one by one
 * 
 * @author xiaoxiao
 */
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public abstract class AbstractSchedulerJob extends QuartzJobBean {
	/**
	 * logger for log4j logging
	 */
	protected final Log log = LogFactory.getLog(getClass());

	/**
	 * execute job time out ,when execute time after value of timeOut the job
	 * logger will warnning
	 */
	private int timeout = 0;

	/**
	 * Setter called after the ExampleJob is instantiated with the value from
	 * the JobDetailBean (5)
	 */
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	/**
	 * 
	 * getter for timeOut
	 * 
	 * @return
	 */
	public int getTimeout() {
		return timeout;
	}

	/**
	 * service name which register in spring container
	 */
	private String serviceName = "";

	/**
	 * 
	 * setter for serviceName
	 * 
	 * @return
	 */
	public String getServiceName() {
		return serviceName;
	}

	/**
	 * 
	 * getter for serviceName
	 * 
	 * @param serviceName
	 */
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	/**
	 * Execute the actual job. The job data map will already have been applied
	 * as bean property values by execute. The contract is exactly the same as
	 * for the standard Quartz execute method.
	 * 
	 * @see #execute
	 */
	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		long startTime = System.currentTimeMillis();
		String name = context.getJobDetail().getKey().getName();
		if (log.isDebugEnabled()) {
			log.debug("Starting job <<" + name + ">> at " + startTime);
		}
		try {
			this.executeBzInternal(context);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}
		long endTime = System.currentTimeMillis();
		if (log.isDebugEnabled()) {
			log.debug("Finished job  <<" + name + ">> at :" + endTime);
		}
		if (timeout > 0 && endTime - startTime > timeout) {
			log.info("Job <<" + name + ">> runned timeout (" + getTimeout()
					+ ").");
		}

	}

	/**
	 * 
	 * 需要业务job实现的方法，在该方法中调用相应的BO或者service
	 * 
	 * @param context
	 *            quartz的执行上下文
	 * @throws JobExecutionException
	 *             job执行异常
	 */
	protected abstract void executeBzInternal(JobExecutionContext context)
			throws JobExecutionException;

}
