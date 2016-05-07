package itaf.framework.scheduler.base;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStoppedEvent;

public class SchedulerStarter implements ApplicationListener<ApplicationEvent> {

	private static final Log log = LogFactory.getLog(SchedulerStarter.class);

	private boolean started = false;

	private Scheduler schedulerFactoryBean;

	public void setSchedulerFactoryBean(Scheduler factoryBean) {
		this.schedulerFactoryBean = factoryBean;
	}

	public void onApplicationEvent(ApplicationEvent event) {
		if (event instanceof ContextRefreshedEvent) {
			try {
				if (!started && !schedulerFactoryBean.isStarted()) {
					started = true;
					log.debug("Try to start spring scheduler factory bean.");
					schedulerFactoryBean.start();
					log.info("Spring scheduler factory bean started.");
				}
			} catch (SchedulerException e) {
				log.error(e);
			}
		} else if (event instanceof ContextStoppedEvent
				|| event instanceof ContextClosedEvent) {
			try {
				if (schedulerFactoryBean.isStarted()) {
					schedulerFactoryBean.shutdown(true);
					log.info("Spring scheduler factory bean stopped.");
				}
			} catch (SchedulerException e) {
				log.error(e);
			}
		}
	}
}
