/**********************************************************************
 * FILE : ScheduleManagerServiceImpl.java
 * CREATE DATE : 2009-1-8
 * DESCRIPTION :
 *		Schedule管理服务类
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
package itaf.framework.scheduler.service.impl;

import itaf.framework.business.base.service.impl.BaseServiceImpl;
import itaf.framework.exception.bean.AppException;
import itaf.framework.scheduler.service.SchedulerService;
import itaf.framework.scheduler.vo.TriggerVo;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.quartz.impl.SchedulerRepository;
import org.quartz.impl.matchers.GroupMatcher;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.quartz.impl.triggers.SimpleTriggerImpl;
import org.springframework.stereotype.Service;

/**
 * @author xiaoxiao
 *         <p>
 *         Schedule管理服务类
 */

@Service("schedulerServiceImpl")
public class SchedulerServiceImpl extends BaseServiceImpl implements
		SchedulerService {

	private String schedulerInstanceName = "Itaf_Scheduler_Instance";

	/**
	 * quartz的调度管理
	 */
	private Scheduler scheduler;

	private Scheduler getScheduler() {
		if (scheduler == null) {
			scheduler = SchedulerRepository.getInstance().lookup(
					this.getSchedulerInstanceName());
		}
		if (scheduler == null) {
			throw new AppException("调度程序没有启动!无法进行调度任务的获取!", "");
		}
		return scheduler;
	}

	/**
	 * <p>
	 * Starts the <code>Scheduler</code>'s threads that fire
	 * <code>{@link Trigger}s</code>. When a scheduler is first created it is in
	 * "stand-by" mode, and will not fire triggers. The scheduler can also be
	 * put into stand-by mode by calling the <code>standby()</code> method.
	 * </p>
	 * 
	 * <p>
	 * The misfire/recovery process will be started, if it is the initial call
	 * to this method on this scheduler instance.
	 * </p>
	 * 
	 * @throws SchedulerException
	 *             if <code>shutdown()</code> has been called, or there is an
	 *             error within the <code>Scheduler</code>.
	 * 
	 * @see #standby
	 * @see #shutdown
	 */
	public void start() throws SchedulerException {
		getScheduler().start();
	}

	/**
	 * 返回所有的Job列表信息
	 */
	public Collection<JobDetail> getAllJobs() {
		log.debug("获取AllJobs开始");
		Collection<JobDetail> result = new ArrayList<JobDetail>();
		try {
			List<String> jobGroupNames = getScheduler().getJobGroupNames();
			for (String jobGName : jobGroupNames) {
				GroupMatcher<JobKey> matcher = GroupMatcher
						.groupEquals(jobGName);
				Set<JobKey> jobNames = getScheduler().getJobKeys(matcher);
				for (JobKey jobKey : jobNames) {
					result.add(getScheduler().getJobDetail(jobKey));
				}
			}
		} catch (SchedulerException e) {
			log.error(e.getMessage(), e);
			throw new AppException("获取所有Job任务异常");
		}
		log.debug("获取AllJobs结束");
		return result;
	}

	/**
	 * 获取JobDetail信息
	 * 
	 * @param jobName
	 *            Job名称
	 * 
	 * @param jobGroup
	 *            Job组名，可以为空
	 */
	public JobDetail getJobDetail(String jobName, String jobGroup)
			throws SchedulerException {
		return getScheduler().getJobDetail(JobKey.jobKey(jobName, jobGroup));
	}

	/**
	 * 恢复一个trigger
	 * 
	 * @param name
	 *            Trigger名称
	 * @param group
	 *            组名称
	 * @throws SchedulerException
	 */
	public void resumeTrigger(String name, String group)
			throws SchedulerException {
		getScheduler().resumeTrigger(TriggerKey.triggerKey(name, group));
	}

	/**
	 * 停止调度trigger
	 * 
	 * @param name
	 *            Trigger名称
	 * @param group
	 *            组名称
	 * @throws SchedulerException
	 */
	public void unscheduleJob(String name, String group)
			throws SchedulerException {
		getScheduler().unscheduleJob(TriggerKey.triggerKey(name, group));
	}

	/**
	 * 获取所有的trigger列表信息
	 * 
	 * @return
	 */
	public Collection<TriggerVo> getAllTriggers() {
		log.debug("获取AllTriggers开始");
		Collection<TriggerVo> result = new ArrayList<TriggerVo>();
		try {
			List<String> groupNames = getScheduler().getTriggerGroupNames();
			if (groupNames == null) {
				return result;
			}
			for (String group : groupNames) {
				Set<TriggerKey> triggerKeys = getScheduler().getTriggerKeys(
						GroupMatcher.triggerGroupEquals(group));
				if (triggerKeys == null) {
					return result;
				}
				for (TriggerKey triggerKey : triggerKeys) {
					result.add(convertTriggerVo(getScheduler().getTrigger(
							triggerKey)));
				}
			}
		} catch (SchedulerException e) {
			log.error(e.getMessage(), e);
			// throw new AppException("获取定时任务列表错误!" + e.getMessage());
		}
		log.debug("获取AllTriggers结束");
		return result;
	}

	private TriggerVo convertTriggerVo(Trigger trigger) {
		TriggerVo tdo = new TriggerVo();
		tdo.setDescription(trigger.getDescription());
		tdo.setName(trigger.getKey().getName());
		tdo.setGroup(trigger.getKey().getGroup());
		tdo.setJobGroup(trigger.getJobKey().getGroup());
		tdo.setJobName(trigger.getJobKey().getName());
		tdo.setMayFireAgain(trigger.mayFireAgain());
		tdo.setPreviousFireTime(trigger.getPreviousFireTime());
		tdo.setNextFireTime(trigger.getNextFireTime());
		if (trigger instanceof SimpleTrigger) {
			tdo.setRepeatInterval(((SimpleTrigger) trigger).getRepeatInterval());
			tdo.setTriggerType(TriggerVo.TIGGER_TYPE_SAMPLE);
		} else if (trigger instanceof CronTrigger) {
			tdo.setCronExpression(((CronTrigger) trigger).getCronExpression());
			tdo.setTriggerType(TriggerVo.TIGGER_TYPE_CRON);
		}
		try {
			tdo.setTriggerStatus(tdo.convertTriggerStateMsg().get(
					getScheduler().getTriggerState(trigger.getKey())));
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		return tdo;
	}

	/**
	 * 获取指定的Trigger信息
	 * 
	 * @param name
	 *            Trigger名称
	 * @param group
	 *            trigger组信息，可以为空
	 * @return TriggerDataObject
	 * @throws SchedulerException
	 */
	public TriggerVo getTrigger(String name, String group) {
		try {
			Trigger trigger = getScheduler().getTrigger(
					TriggerKey.triggerKey(name, group));
			return convertTriggerVo(trigger);
		} catch (SchedulerException e) {
			log.error(e.getMessage(), e);
			throw new AppException("获取Trigger信息失败" + e.getMessage());
		}
	}

	/**
	 * <p>
	 * Trigger the identified <code>{@link org.quartz.JobDetail}</code> (execute
	 * it now) - the generated trigger will be non-volatile.
	 * </p>
	 */
	public void triggerJob(String jobName, String jobGroup)
			throws SchedulerException {
		getScheduler().triggerJob(JobKey.jobKey(jobName, jobGroup));
	}

	/**
	 * <p>
	 * Delete the identified <code>Job</code> from the Scheduler - and any
	 * associated <code>Trigger</code>s.
	 * </p>
	 * 
	 * @return true if the Job was found and deleted.
	 * @throws SchedulerException
	 *             if there is an internal Scheduler error.
	 */
	public boolean deleteJob(String jobName, String jobGroup)
			throws SchedulerException {
		return getScheduler().deleteJob(JobKey.jobKey(jobName, jobGroup));
	}

	/**
	 * <p>
	 * Add the given <code>Job</code> to the Scheduler - with no associated
	 * <code>Trigger</code>. The <code>Job</code> will be 'dormant' until it is
	 * scheduled with a <code>Trigger</code>, or
	 * <code>Scheduler.triggerJob()</code> is called for it.
	 * </p>
	 * 
	 * <p>
	 * The <code>Job</code> must by definition be 'durable', if it is not,
	 * SchedulerException will be thrown.
	 * </p>
	 * 
	 * @throws SchedulerException
	 *             if there is an internal Scheduler error, or if the Job is not
	 *             durable, or a Job with the same name already exists, and
	 *             <code>replace</code> is <code>false</code>.
	 */
	public void addJob(JobDetail jobDetail, boolean replace)
			throws SchedulerException {
		getScheduler().addJob(jobDetail, replace);
	}

	/**
	 * <p>
	 * Remove (delete) the <code>{@link org.quartz.Trigger}</code> with the
	 * given name, and store the new given one - which must be associated with
	 * the same job (the new trigger must have the job name & group specified) -
	 * however, the new trigger need not have the same name as the old trigger.
	 * </p>
	 * 
	 * @param triggerName
	 *            The name of the <code>Trigger</code> to be replaced.
	 * @param groupName
	 *            The group name of the <code>Trigger</code> to be replaced.
	 * @param newTrigger
	 *            The new <code>Trigger</code> to be stored.
	 * @return <code>null</code> if a <code>Trigger</code> with the given name &
	 *         group was not found and removed from the store, otherwise the
	 *         first fire time of the newly scheduled trigger.
	 */
	public Date rescheduleJob(String name, String group, TriggerVo tdo)
			throws SchedulerException {
		Trigger trigger = getScheduler().getTrigger(tdo.getTriggerKey());
		if (trigger == null) {
			return null;
		}
		if (trigger instanceof SimpleTriggerImpl) {
			SimpleTriggerImpl simpleTrigger = (SimpleTriggerImpl) trigger;
			simpleTrigger.setRepeatInterval(tdo.getRepeatInterval());
			return getScheduler().rescheduleJob(
					TriggerKey.triggerKey(name, group), simpleTrigger);
		} else if (trigger instanceof CronTriggerImpl) {
			CronTriggerImpl cronTrigger = (CronTriggerImpl) trigger;
			try {
				cronTrigger.setCronExpression(tdo.getCronExpression());
			} catch (ParseException e) {
				log.error(e.getMessage(), e);
				throw new AppException(e.getMessage());
			}
			return getScheduler().rescheduleJob(
					TriggerKey.triggerKey(name, group), cronTrigger);
		}
		return null;
	}

	/**
	 * <p>
	 * Add the given <code>{@link org.quartz.JobDetail}</code> to the Scheduler,
	 * and associate the given <code>{@link Trigger}</code> with it.
	 * </p>
	 * 
	 * <p>
	 * If the given Trigger does not reference any <code>Job</code>, then it
	 * will be set to reference the Job passed with it into this method.
	 * </p>
	 * 
	 * @throws SchedulerException
	 *             if the Job or Trigger cannot be added to the Scheduler, or
	 *             there is an internal Scheduler error.
	 */
	public Date scheduleJob(JobDetail jobDetail, Trigger trigger)
			throws SchedulerException {
		return getScheduler().scheduleJob(jobDetail, trigger);
	}

	/**
	 * <p>
	 * Schedule the given <code>{@link org.quartz.Trigger}</code> with the
	 * <code>Job</code> identified by the <code>Trigger</code>'s settings.
	 * </p>
	 * 
	 * @throws SchedulerException
	 *             if the indicated Job does not exist, or the Trigger cannot be
	 *             added to the Scheduler, or there is an internal Scheduler
	 *             error.
	 */
	public Date scheduleJobByTrigger(TriggerVo tdo) throws SchedulerException {
		Trigger trigger = getScheduler().getTrigger(tdo.getTriggerKey());
		if (trigger == null) {
			return null;
		}
		if (trigger instanceof SimpleTriggerImpl) {
			SimpleTriggerImpl simpleTrigger = (SimpleTriggerImpl) trigger;
			simpleTrigger.setRepeatInterval(tdo.getRepeatInterval());
			return getScheduler().scheduleJob(simpleTrigger);
		} else if (trigger instanceof CronTriggerImpl) {
			CronTriggerImpl simpleTrigger = (CronTriggerImpl) trigger;
			try {
				simpleTrigger.setCronExpression(tdo.getCronExpression());
			} catch (ParseException e) {
				log.error(e.getMessage(), e);
				throw new AppException(e.getMessage());
			}
			return getScheduler().scheduleJob(simpleTrigger);
		}
		return null;

	}

	/**
	 * <p>
	 * Pause the <code>{@link Trigger}</code> with the given name.
	 * </p>
	 * 
	 * @throws SchedulerException
	 * 
	 * @see #resumeTrigger(String, String)
	 */
	public void pauseTrigger(String name, String group)
			throws SchedulerException {
		getScheduler().pauseTrigger(TriggerKey.triggerKey(name, group));
	}

	public String getSchedulerInstanceName() {
		return schedulerInstanceName;
	}

	public void setSchedulerInstanceName(String schedulerInstanceName) {
		this.schedulerInstanceName = schedulerInstanceName;
	}

	/**
	 * <p>
	 * Halts the <code>Scheduler</code>'s firing of
	 * <code>{@link Trigger}s</code>, and cleans up all resources associated
	 * with the Scheduler. Equivalent to <code>shutdown(false)</code>.
	 * </p>
	 * 
	 * <p>
	 * The scheduler cannot be re-started.
	 * </p>
	 * 
	 * @see #shutdown(boolean)
	 */
	public void shutdown() throws SchedulerException {
		getScheduler().shutdown();
	}

	@Override
	public Collection<TriggerVo> getTriggersByGroup(String group) {
		log.debug("获取getTriggersByGroup开始");
		Collection<TriggerVo> result = new ArrayList<TriggerVo>();
		try {
			List<String> groupNames = getScheduler().getTriggerGroupNames();
			if (groupNames == null) {
				return result;
			}
			for (String groupName : groupNames) {
				if (!groupName.equals(group)) {
					continue;
				}
				Set<TriggerKey> triggerKeys = getScheduler().getTriggerKeys(
						GroupMatcher.triggerGroupEquals(groupName));
				if (triggerKeys == null) {
					return result;
				}
				for (TriggerKey triggerKey : triggerKeys) {
					result.add(convertTriggerVo(getScheduler().getTrigger(
							triggerKey)));
				}
			}
		} catch (SchedulerException e) {
			log.error(e.getMessage(), e);
			// throw new AppException("获取定时任务列表错误!" + e.getMessage());
		}
		log.debug("获取AllTriggers结束");
		return result;
	}

}
