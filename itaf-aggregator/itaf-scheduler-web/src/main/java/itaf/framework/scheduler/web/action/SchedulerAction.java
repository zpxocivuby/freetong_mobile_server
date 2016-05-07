package itaf.framework.scheduler.web.action;

import itaf.framework.scheduler.service.SchedulerService;
import itaf.framework.scheduler.vo.TriggerVo;
import itaf.framework.scheduler.web.action.base.AbstractPageAction;
import itaf.framework.scheduler.web.util.ProcessQueryUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.SchedulerException;

/**
 * 任务管理控制层
 * 
 * @author XINXIN
 * 
 * @Date 2014年7月11日
 */
@ManagedBean(name = "schedulerAction")
@ViewScoped
public class SchedulerAction extends AbstractPageAction {

	private static final long serialVersionUID = 1L;
	private Log log = LogFactory.getLog(SchedulerAction.class);

	@ManagedProperty(value = "#{schedulerServiceImpl}")
	private SchedulerService schedulerService;

	private SelectItem[] groups;

	private List<TriggerVo> triggers;

	public List<TriggerVo> getTriggers() {
		String group = ProcessQueryUtil.getValueOfForm("queryGroup");
		triggers = new ArrayList<TriggerVo>();
		Collection<TriggerVo> triggerVos = null;
		if (StringUtils.isEmpty(group)) {
			triggerVos = getSchedulerService().getAllTriggers();
		} else {
			triggerVos = getSchedulerService().getTriggersByGroup(group);
		}
		if (triggerVos != null) {
			triggers.addAll(triggerVos);
		}
		return triggers;
	}

	/**
	 * 获取任务组名称
	 * 
	 * @return
	 */
	public SelectItem[] getGroups() {
		if (groups == null || groups.length <= 0) {
			groups = new SelectItem[4];
			groups[0] = new SelectItem("", "全部");
			groups[1] = new SelectItem("DEFAULT", "DEFAULT");
			groups[2] = new SelectItem("AttachmentGroup", "AttachmentGroup");
			groups[3] = new SelectItem("BaseTaskGroup", "BaseTaskGroup");
		}
		return groups;
	}

	public void setGroups(SelectItem[] groups) {
		this.groups = groups;
	}

	/**
	 * 恢复一个触发器
	 * 
	 * @throws SchedulerException
	 */
	public void resumeTrigger() throws SchedulerException {
		String name = ProcessQueryUtil.getValueOfForm("name");
		String group = ProcessQueryUtil.getValueOfForm("group");
		schedulerService.resumeTrigger(name, group);
	}

	/**
	 * 停止调度触发器 暂停 trigger
	 * 
	 * @throws SchedulerException
	 */
	public void pauseTrigger() throws SchedulerException {
		String name = ProcessQueryUtil.getValueOfForm("name");
		String group = ProcessQueryUtil.getValueOfForm("group");
		schedulerService.pauseTrigger(name, group);
	}

	/**
	 * 立即执行
	 * 
	 * @throws SchedulerException
	 */
	public void immediateExecution() throws SchedulerException {
		String jobName = ProcessQueryUtil.getValueOfForm("jobName");
		String jobGroup = ProcessQueryUtil.getValueOfForm("jobGroup");
		schedulerService.triggerJob(jobName, jobGroup);
	}

	/**
	 * 关闭，结束触发器
	 */
	public void shutdown() {
		try {
			schedulerService.shutdown();// 关闭触发器
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	/**
	 * 开始，触发器启动
	 */
	public void start() {
		try {
			schedulerService.start();// 开启一个触发器
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	public void setTriggers(List<TriggerVo> triggers) {
		this.triggers = triggers;
	}

	public SchedulerService getSchedulerService() {
		return schedulerService;
	}

	public void setSchedulerService(SchedulerService schedulerService) {
		this.schedulerService = schedulerService;
	}

}