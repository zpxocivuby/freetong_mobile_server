package itaf.framework.workflow.service.impl;

import itaf.framework.workflow.service.TraceService;
import itaf.framework.workflow.util.WorkflowUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.identity.User;
import org.activiti.engine.impl.bpmn.behavior.UserTaskActivityBehavior;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.delegate.ActivityBehavior;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.impl.task.TaskDefinition;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.stereotype.Service;

@Service("traceServiceImpl")
public class TraceServiceImpl implements TraceService {

	@Resource(name = "identityService")
	private IdentityService identityService;

	@Resource(name = "runtimeService")
	private RuntimeService runtimeService;

	@Resource(name = "historyService")
	private HistoryService historyService;

	@Resource(name = "taskService")
	private TaskService taskService;

	@Resource(name = "repositoryService")
	private RepositoryService repositoryService;

	public List<Map<String, Object>> traceProcess(String processInstanceId)
			throws Exception {
		Execution execution = runtimeService.createExecutionQuery()
				.executionId(processInstanceId).singleResult();// 执行实例
		Object property = PropertyUtils.getProperty(execution, "activityId");
		// 得到当前节点 activiti id
		String activityId = "";
		if (property != null) {
			activityId = property.toString();
		}

		ProcessInstance processInstance = runtimeService
				.createProcessInstanceQuery()
				.processInstanceId(processInstanceId).singleResult();
		// ProcessDefinitionEntity processDefinition = (ProcessDefinitionEntity)
		// ((RepositoryServiceImpl) repositoryService)
		// .getDeployedProcessDefinition(processInstance
		// .getProcessDefinitionId());
		ProcessDefinitionEntity processDefinition = (ProcessDefinitionEntity) repositoryService
				.getProcessDefinition(processInstance.getProcessDefinitionId());

		List<ActivityImpl> activitiList = processDefinition.getActivities();// 获得当前任务的所有节点

		List<Map<String, Object>> activityInfos = new ArrayList<Map<String, Object>>();

		for (ActivityImpl activity : activitiList) {
			boolean currentActiviti = false;
			String id = activity.getId();

			// 当前节点
			if (id.equals(activityId)) {
				currentActiviti = true;
			}

			Map<String, Object> activityImageInfo = packageSingleActivitiInfo(
					activity, processInstance, currentActiviti);

			activityInfos.add(activityImageInfo);
		}
		return activityInfos;
	}

	private Map<String, Object> packageSingleActivitiInfo(
			ActivityImpl activity, ProcessInstance processInstance,
			boolean currentActiviti) throws Exception {

		Map<String, Object> activityInfo = new HashMap<String, Object>();
		// 设置节点是否为当前节点
		activityInfo.put("currentActiviti", currentActiviti);
		// 设置节点坐标
		setPosition(activity, activityInfo);
		setWidthAndHeight(activity, activityInfo);

		Map<String, Object> properties = activity.getProperties();

		// 设置任务类型
		Map<String, Object> vars = new HashMap<String, Object>();
		vars.put("任务类型",
				WorkflowUtils.parseToZhType(properties.get("type").toString()));

		ActivityBehavior activityBehavior = activity.getActivityBehavior();

		if (activityBehavior instanceof UserTaskActivityBehavior) {

			Task currentTask = null;

			/*
			 * 当前节点的task
			 */
			if (currentActiviti) {
				currentTask = getCurrentTaskInfo(processInstance);
			}

			/*
			 * 当前任务的分配角色
			 */
			UserTaskActivityBehavior userTaskActivityBehavior = (UserTaskActivityBehavior) activityBehavior;
			TaskDefinition taskDefinition = userTaskActivityBehavior
					.getTaskDefinition();
			Set<Expression> candidateGroupIdExpressions = taskDefinition
					.getCandidateGroupIdExpressions();
			if (!candidateGroupIdExpressions.isEmpty()) {

				// 任务的处理角色
				setTaskGroup(vars, candidateGroupIdExpressions);

				// 当前处理人
				if (currentTask != null) {
					setCurrentTaskAssignee(vars, currentTask);
				}
			}
		}

		vars.put("节点说明", properties.get("documentation"));

		String description = activity.getProcessDefinition().getDescription();
		vars.put("描述", description);

		activityInfo.put("vars", vars);
		return activityInfo;
	}

	private void setTaskGroup(Map<String, Object> vars,
			Set<Expression> candidateGroupIdExpressions) {
		String roles = "";
		for (Expression expression : candidateGroupIdExpressions) {
			String expressionText = expression.getExpressionText();
			if (expressionText.startsWith("$")) {
				expressionText = expressionText.replace("${insuranceType}",
						"life");
			}
			String roleName = identityService.createGroupQuery()
					.groupId(expressionText).singleResult().getName();
			roles += roleName;
		}
		vars.put("任务所属角色", roles);
	}

	/**
	 * 设置当前处理人信息
	 * 
	 * @param vars
	 * @param currentTask
	 */
	private void setCurrentTaskAssignee(Map<String, Object> vars,
			Task currentTask) {
		String assignee = currentTask.getAssignee();
		if (assignee != null) {
			User assigneeUser = identityService.createUserQuery()
					.userId(assignee).singleResult();
			String userInfo = assigneeUser.getFirstName() + " "
					+ assigneeUser.getLastName();
			vars.put("当前处理人", userInfo);
		}
	}

	/**
	 * 获取当前节点信息
	 * 
	 * @param processInstance
	 * @return
	 */
	private Task getCurrentTaskInfo(ProcessInstance processInstance) {
		Task currentTask = null;
		try {
			String activitiId = (String) PropertyUtils.getProperty(
					processInstance, "activityId");

			currentTask = taskService.createTaskQuery()
					.processInstanceId(processInstance.getId())
					.taskDefinitionKey(activitiId).singleResult();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return currentTask;
	}

	/**
	 * 设置宽度、高度属性
	 * 
	 * @param activity
	 * @param activityInfo
	 */
	private void setWidthAndHeight(ActivityImpl activity,
			Map<String, Object> activityInfo) {
		activityInfo.put("width", activity.getWidth());
		activityInfo.put("height", activity.getHeight());
	}

	/**
	 * 设置坐标位置
	 * 
	 * @param activity
	 * @param activityInfo
	 */
	private void setPosition(ActivityImpl activity,
			Map<String, Object> activityInfo) {
		activityInfo.put("x", activity.getX());
		activityInfo.put("y", activity.getY());
	}
}
