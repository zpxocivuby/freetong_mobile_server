package itaf.framework.scheduler.job;

import itaf.framework.core.util.SpringContextUtil;
import itaf.framework.scheduler.service.SchedulerTestService;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

public class SchedulerTestJob extends AbstractSchedulerJob {

	@Autowired
	private SchedulerTestService schedulerTestService;

	@Override
	protected void executeBzInternal(JobExecutionContext context)
			throws JobExecutionException {
		String name = context.getJobDetail().getKey().getName();
		log.debug("Job <<" + name + ">> runned with service:"
				+ getServiceName() + ".");
		try {
			getSchedulerTestService().doTest();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	public SchedulerTestService getSchedulerTestService() {
		if (schedulerTestService == null) {
			schedulerTestService = (SchedulerTestService) SpringContextUtil
					.getBean(getServiceName());
		}
		return schedulerTestService;
	}

	public void setSchedulerTestService(
			SchedulerTestService schedulerTestService) {
		this.schedulerTestService = schedulerTestService;
	}
}
