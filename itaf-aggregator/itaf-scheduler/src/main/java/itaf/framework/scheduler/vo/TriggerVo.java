/**
 * 
 */
/**********************************************************************
 * FILE : SWTMonthChooser.java
 * CREATE DATE : 2008-12-10
 * DESCRIPTION :
 *		
 *      
 * CHANGE HISTORY LOG
 *---------------------------------------------------------------------
 * NO.|    DATE    |     NAME     |     REASON     | DESCRIPTION
 *---------------------------------------------------------------------
 * 1  | 2008-10-10 |  lyh  |    create draft version
 *---------------------------------------------------------------------              
 ***********************************************************************/
package itaf.framework.scheduler.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.Trigger.TriggerState;
import org.quartz.TriggerKey;

/**
 * @author xiaoxiao
 * 
 */
public class TriggerVo implements Serializable {

	private static final long serialVersionUID = -3364336249719123452L;

	public Map<TriggerState, String> triggerStateAndShowMsg;

	public static final int TIGGER_TYPE_SAMPLE = 1;
	public static final int TIGGER_TYPE_CRON = 2;

	private String name;
	private String group = Scheduler.DEFAULT_GROUP;
	private String jobName;
	private String jobGroup = Scheduler.DEFAULT_GROUP;
	private String description;
	private Date previousFireTime;
	private Date nextFireTime;
	private boolean mayFireAgain;
	private String cronExpression;
	private Long repeatInterval;
	private int triggerType = TIGGER_TYPE_SAMPLE;
	private String triggerStatus = "";
	private TriggerKey triggerKey;
	private JobKey jobKey;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getJobGroup() {
		return jobGroup;
	}

	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public boolean isMayFireAgain() {
		return mayFireAgain;
	}

	public void setMayFireAgain(boolean mayFireAgain) {
		this.mayFireAgain = mayFireAgain;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getPreviousFireTime() {
		return previousFireTime;
	}

	public void setPreviousFireTime(Date previousFireTime) {
		this.previousFireTime = previousFireTime;
	}

	public Date getNextFireTime() {
		return nextFireTime;
	}

	public void setNextFireTime(Date nextFireTime) {
		this.nextFireTime = nextFireTime;
	}

	public String getCronExpression() {
		return cronExpression;
	}

	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}

	public Long getRepeatInterval() {
		return repeatInterval;
	}

	public void setRepeatInterval(Long repeatInterval) {
		this.repeatInterval = repeatInterval;
	}

	public int getTriggerType() {
		return triggerType;
	}

	public void setTriggerType(int triggerType) {
		this.triggerType = triggerType;
	}

	public String getTriggerStatus() {
		return triggerStatus;
	}

	public void setTriggerStatus(String triggerStatus) {
		this.triggerStatus = triggerStatus;
	}

	public Map<TriggerState, String> convertTriggerStateMsg() {
		if (triggerStateAndShowMsg == null) {
			triggerStateAndShowMsg = new HashMap<TriggerState, String>();
			triggerStateAndShowMsg.put(TriggerState.NONE, "创建");
			triggerStateAndShowMsg.put(TriggerState.NORMAL, "就绪");
			triggerStateAndShowMsg.put(TriggerState.PAUSED, "暂停");
			triggerStateAndShowMsg.put(TriggerState.COMPLETE, "完成");
			triggerStateAndShowMsg.put(TriggerState.ERROR, "错误");
			triggerStateAndShowMsg.put(TriggerState.BLOCKED, "阻塞");
		}
		return triggerStateAndShowMsg;
	}

	public TriggerKey getTriggerKey() {
		triggerKey = TriggerKey.triggerKey(name, group);
		return triggerKey;
	}

	public void setTriggerKey(TriggerKey triggerKey) {
		this.triggerKey = triggerKey;
	}

	public JobKey getJobKey() {
		jobKey = JobKey.jobKey(jobName, jobGroup);
		return jobKey;
	}

	public void setJobKey(JobKey jobKey) {
		this.jobKey = jobKey;
	}

}
