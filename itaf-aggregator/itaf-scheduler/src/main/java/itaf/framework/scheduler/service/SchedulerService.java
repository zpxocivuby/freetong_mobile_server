/**********************************************************************
 * FILE : ScheduleManagerService.java
 * CREATE DATE : 2009-1-8
 * DESCRIPTION :
 *		
 *      Schedule管理服务类
 * CHANGE HISTORY LOG
 *---------------------------------------------------------------------
 * NO.|    DATE    |     NAME     |     REASON     | DESCRIPTION
 *---------------------------------------------------------------------
 * 1  | 2009-1-8 |  xiaoxiao  |    创建草稿版本
 *---------------------------------------------------------------------              
 **********************************************************************
 */
package itaf.framework.scheduler.service;

import itaf.framework.scheduler.vo.TriggerVo;

import java.util.Collection;
import java.util.Date;

import org.quartz.JobDetail;
import org.quartz.SchedulerException;
import org.quartz.Trigger;

/**
 * @author xiaoxiao
 *         <p>
 *         Schedule管理服务类
 */

public interface SchedulerService {

	/**
	 * <p>
	 * Starts the <code>Scheduler</code>'s threads that fire
	 * <code>{@link Trigger}s</code>. When a scheduler is first created it is in
	 * "stand-by" mode, and will not fire triggers. The scheduler can also be
	 * put into stand-by mode by calling the <code>standby()</code> method.
	 * </p>
	 * 
	 * <p>
	 * The miss fire/recovery process will be started, if it is the initial call
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
	public void start() throws SchedulerException;

	/**
	 * 返回所有的Job列表信息
	 */
	public Collection<JobDetail> getAllJobs();

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
			throws SchedulerException;

	/**
	 * 获取所有的trigger列表信息
	 * 
	 * @return
	 */
	public Collection<TriggerVo> getAllTriggers();

	/**
	 * 查找组的trigger
	 * 
	 * @param group
	 *            trigger的组名称
	 * @return Collection<TriggerVo>
	 */
	public Collection<TriggerVo> getTriggersByGroup(String group);

	/**
	 * 获取指定的Trigger信息
	 * 
	 * @param name
	 *            trigger名称
	 * @param group
	 *            trigger组信息，可以为空
	 * @return
	 * @throws SchedulerException
	 */
	public TriggerVo getTrigger(String name, String group);

	/**
	 * 
	 * 触发某一job
	 * 
	 * @param jobName
	 *            名称
	 * @param jobGroup
	 *            组名称
	 * @throws SchedulerException
	 * 
	 */
	public void triggerJob(String jobName, String jobGroup)
			throws SchedulerException;

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
			throws SchedulerException;

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
			throws SchedulerException;

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
			throws SchedulerException;

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
			throws SchedulerException;

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
	public Date rescheduleJob(String name, String group, TriggerVo newTrigger)
			throws SchedulerException;

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
			throws SchedulerException;

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
	public Date scheduleJobByTrigger(TriggerVo tdo) throws SchedulerException;

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
			throws SchedulerException;

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
	public void shutdown() throws SchedulerException;
}
