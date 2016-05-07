/**
 * 
 */
package itaf.framework.workflow.service.impl;

import itaf.framework.core.common.PageResult;
import itaf.framework.core.constant.QueryConditionConstants;
import itaf.framework.workflow.service.TraceService;
import itaf.framework.workflow.service.WorkFlowService;
import itaf.framework.workflow.vo.ApprovalInfoVo;
import itaf.framework.workflow.vo.ProcinstVo;
import itaf.framework.workflow.vo.WorkflowFormVo;
import itaf.framework.workflow.vo.WorkflowMapDefine;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.impl.bpmn.diagram.ProcessDiagramGenerator;
import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.engine.impl.context.Context;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xiaoly
 * 
 */
@Service("workFlowServiceImpl")
public class WorkFlowServiceImpl implements WorkFlowService {

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

	@Autowired
	private TraceService traceService;
	
	@Autowired
	private SpringProcessEngineConfiguration processEngine;

	public Deployment deployment(String resourceName, InputStream inputStream) {
		Deployment deployment = repositoryService.createDeployment()
				.addInputStream(resourceName, inputStream).deploy();
		return deployment;
	}

	/**
	 * 启动工作流
	 */
	public ProcessInstance startWorkflow(String key, String businessKey,
			Map<String, Object> variables) {
		// 根据流程定义的key启动工作流
		ProcessInstance processInstance = runtimeService
				.startProcessInstanceByKey("leave", businessKey, variables);

		return processInstance;
	}

	/**
	 * 根据用户Id查询待办任务列表
	 * 
	 * @param userid
	 *            用户id
	 * @param processDefinitionKey
	 *            流程定义的key
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Task> findTask(String userid, String processDefinitionKey) {

		// 存放当前用户的所有任务
		List<Task> tasks = new ArrayList<Task>();

		// 根据当前用户的id查询代办任务列表(已经签收)
		List<Task> taskAssignees = taskService.createTaskQuery()
				.processDefinitionKey(processDefinitionKey)
				.taskAssignee(userid).orderByTaskPriority().desc()
				.orderByTaskCreateTime().desc().list();
		// 根据当前用户id查询未签收的任务列表
		List<Task> taskCandidates = taskService.createTaskQuery()
				.processDefinitionKey(processDefinitionKey)
				.taskCandidateUser(userid).orderByTaskPriority().desc()
				.orderByTaskCreateTime().desc().list();

		tasks.addAll(taskAssignees);// 添加已签收准备执行的任务(已经分配到任务的人)
		tasks.addAll(taskCandidates);// 添加还未签收的任务(任务的候选者)

		return tasks;
	}

	/**
	 * 查询运行中的流程实例
	 * 
	 * @param processDefinitionKey
	 *            流程定义的key
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public List<ProcessInstance> findRunningProcessInstaces(
			String processDefinitionKey) {

		List<ProcessInstance> processInstances = runtimeService
				.createProcessInstanceQuery()
				.processDefinitionKey(processDefinitionKey).list();

		return processInstances;
	}

	/**
	 * 查询已结束的流程实例
	 * 
	 * @param processDefinitionKey
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public List<HistoricProcessInstance> findFinishedProcessInstaces(
			String processDefinitionKey) {

		// 根据流程定义的key查询已经结束的流程实例(HistoricProcessInstance)
		List<HistoricProcessInstance> list = historyService
				.createHistoricProcessInstanceQuery().finished()
				.processDefinitionKey(processDefinitionKey).list();

		return list;
	}

	/**
	 * 根据流程定义Id查询流程定义
	 */
	public ProcessDefinition getProcessDefinition(String processDefinitionId) {
		ProcessDefinition processDefinition = repositoryService
				.createProcessDefinitionQuery()
				.processDefinitionId(processDefinitionId).singleResult();
		return processDefinition;
	}

	/**
	 * 根据任务Id查询任务
	 */
	public TaskEntity findTaskById(String taskId) throws Exception {
		TaskEntity task = (TaskEntity) taskService.createTaskQuery()
				.taskId(taskId).singleResult();
		if (task == null) {
			throw new Exception("任务实例未找到!");
		}
		return task;
	}

	public String doStartWorkflow(String userId, String key,
			String businessKey, Map<String, Object> variables) {
		List<ApprovalInfoVo> commentList = new ArrayList<ApprovalInfoVo>();
		variables.put(WorkflowMapDefine.COMMENT, commentList);
		// 设置流程的启动人员
		identityService.setAuthenticatedUserId(userId);
		// 启动流程
		ProcessInstance processInstance = runtimeService
				.startProcessInstanceByKey(key, businessKey, variables);

		if (processInstance != null) {
			return processInstance.getProcessInstanceId();
		}
		return null;
	}

	public void deleteProcessInstance(String processInstanceId) {
		runtimeService.deleteProcessInstance(processInstanceId, "");
		historyService.deleteHistoricProcessInstance(processInstanceId);
	}

	// 同意
	public void doApproveWorkflow(String userId, String taskId,
			String approvalInfo, String userName) {

		HistoricProcessInstance processInstance = getProcessByTaskId(taskId);
		runtimeService.setVariable(processInstance.getId(),
				WorkflowMapDefine.FINALAPPROVALSTATE, "1");

		Task task = taskService.createTaskQuery().taskId(taskId).singleResult();

		taskService.claim(task.getId(), String.valueOf(userId));

		// 设置通过变量
		runtimeService.setVariable(task.getProcessInstanceId(),
				WorkflowMapDefine.APPROVALSTATE, WorkflowMapDefine.APPROVE);
		// 完成任务
		taskService.complete(task.getId());
	}

	// 驳回
	public void doRejectWorkflow(String userId, String taskId,
			String approvalInfo, String userName) {
		HistoricProcessInstance processInstance = getProcessByTaskId(taskId);
		runtimeService.setVariable(processInstance.getId(),
				WorkflowMapDefine.FINALAPPROVALSTATE, "0");

		Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
		// 检出任务
		taskService.claim(task.getId(), String.valueOf(userId));

		// 设置通过变量
		runtimeService.setVariable(task.getProcessInstanceId(),
				WorkflowMapDefine.APPROVALSTATE, WorkflowMapDefine.REJECT);
		// 完成任务
		taskService.complete(task.getId());

	}

	@SuppressWarnings("unchecked")
	public List<ApprovalInfoVo> findApprovalInfos(String processInstanceId) {
		List<ApprovalInfoVo> comments = (List<ApprovalInfoVo>) runtimeService
				.getVariable(processInstanceId, WorkflowMapDefine.COMMENT);
		return comments;
	}

	public Task findFirstActTask(String userId, String processInstanceId) {
		StringBuffer processingSql = new StringBuffer();
		processingSql.append("SELECT DISTINCT RES.* FROM ACT_RU_TASK RES ");
		processingSql
				.append(" INNER JOIN ACT_RU_IDENTITYLINK I ON I.TASK_ID_ = RES.ID_ ");
		// processingSql.append(" INNER JOIN ACT_HI_PROCINST A on RES.PROC_INST_ID_ = A.PROC_INST_ID_ ");
		// processingSql.append(" INNER JOIN BZ_FORM_ENTITY T on T.PROCESS_INSTANCE_ID = A.PROC_INST_ID_ ");
		processingSql.append(" WHERE");
		String sql = " (I.USER_ID_ = '"
				+ userId
				+ "' or I.GROUP_ID_ IN (SELECT G.GROUP_ID_ FROM ACT_ID_MEMBERSHIP G WHERE G.USER_ID_ = '"
				+ userId + "')) AND RES.PROC_INST_ID_ = '" + processInstanceId
				+ "' ";

		List<Task> taskTotalList = taskService.createNativeTaskQuery()
				.sql(processingSql.toString() + sql).list();
		if (taskTotalList != null && taskTotalList.size() > 0) {
			return taskTotalList.get(0);
		}
		return null;
	}

	// 待办
	public PageResult<WorkflowFormVo> findProcessingWorkflows(String userId,
			int currentIndex, int pageSize, Map<String, Object> variables) {
		// 查询条件
		String processDefinitionId = (String) variables
				.get(QueryConditionConstants.PROCESSDEFINITIONID);
		Date startTime = (Date) variables
				.get(QueryConditionConstants.STARTTIME);
		Date endTime = (Date) variables.get(QueryConditionConstants.ENDTIME);

		String title = (String) variables.get(QueryConditionConstants.TITLE);

		List<Task> taskTotalList = new ArrayList<Task>();// 总条数
		List<Task> taskList = new ArrayList<Task>();// 分页条数

		// 当前人在候选人或者候选组范围之内
		StringBuffer processingSql = new StringBuffer();
		processingSql.append("SELECT DISTINCT RES.* FROM ACT_RU_TASK RES ");
		processingSql
				.append(" INNER JOIN ACT_RU_IDENTITYLINK I ON I.TASK_ID_ = RES.ID_ ");
		processingSql
				.append(" INNER JOIN ACT_HI_PROCINST A on RES.PROC_INST_ID_ = A.PROC_INST_ID_ ");
		processingSql
				.append(" INNER JOIN BZ_FORM_ENTITY T on T.PROCESS_INSTANCE_ID = A.PROC_INST_ID_ ");
		processingSql.append(" WHERE");
		processingSql.append(" RES.ASSIGNEE_ IS NULL ");

		/*if (processDefinitionId != null && !processDefinitionId.equals("")) {
			processingSql
					.append(" AND A.PROC_DEF_ID_ IN (SELECT D.ID_ FROM ACT_RE_PROCDEF D WHERE D.KEY_=#{processDefinitionId})");
		}*/
		if (startTime != null) {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String st = df.format(startTime);
			String et = df.format(endTime);
			processingSql
					.append(" and A.START_TIME_ <= '"+ et + " 23:59:59'" + " and A.START_TIME_ >= '" + st + " 00:00:00'");
		}
		if (title != null && !title.equals("")) {
			processingSql.append(" AND T.TITLE LIKE '%" + title + "%'");
		}
		if (processDefinitionId != null && !processDefinitionId.equals("")) {
			processingSql
					.append(" AND T.FORM_TYPE=#{processDefinitionId}");
		}
		processingSql
				.append(" AND ( I.USER_ID_ = #{userId} or I.GROUP_ID_ IN (SELECT G.GROUP_ID_ FROM ACT_ID_MEMBERSHIP G WHERE G.USER_ID_ = #{userId}))");

		// 得到总条数
		taskTotalList = taskService.createNativeTaskQuery()
				.sql(processingSql.toString())
				.parameter("processDefinitionId", processDefinitionId)
				.parameter("userId", userId).list();

		if (taskTotalList == null || taskTotalList.size() == 0) {
			return new PageResult<WorkflowFormVo>();
		} else {
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT * FROM");
			sql.append("(SELECT A.* FROM");
			sql.append("(" + processingSql.toString());
			sql.append(") AS A LIMIT #{startIndex},#{endIndex}) MID2");

			taskList = taskService.createNativeTaskQuery().sql(sql.toString())
					.parameter("processDefinitionId", processDefinitionId)
					.parameter("userId", userId)
					.parameter("endIndex", currentIndex + pageSize)
					.parameter("startIndex", currentIndex).list();
		}

		return this.createTaskResult(taskList, currentIndex, pageSize,
				taskTotalList.size());
	}

	// 已办
	public PageResult<WorkflowFormVo> findFinishedWorkflows(String userId,
			int currentIndex, int pageSize, Map<String, Object> variables) {
		// 查询条件
		String processDefinitionId = (String) variables
				.get(QueryConditionConstants.PROCESSDEFINITIONID);
		Date startTime = (Date) variables
				.get(QueryConditionConstants.STARTTIME);
		Date endTime = (Date) variables.get(QueryConditionConstants.ENDTIME);

		String title = (String) variables.get(QueryConditionConstants.TITLE);

		StringBuffer finishedTotalSql = new StringBuffer();
		finishedTotalSql.append("SELECT * FROM ACT_HI_ACTINST A ");
		finishedTotalSql
				.append(" INNER JOIN ACT_HI_PROCINST P ON A.PROC_INST_ID_=P.PROC_INST_ID_");
		finishedTotalSql
				.append(" INNER JOIN BZ_FORM_ENTITY T on T.PROCESS_INSTANCE_ID = P.PROC_INST_ID_ ");
		finishedTotalSql
				.append(" WHERE A.ASSIGNEE_=#{userId} AND P.END_ACT_ID_ IS NULL");

		String conditionSql = "";

		if ((processDefinitionId != null && !processDefinitionId.equals(""))) {
			conditionSql = " AND A.PROC_DEF_ID_ IN (SELECT D.ID_ FROM ACT_RE_PROCDEF D WHERE D.KEY_=#{processDefinitionId})";
		}

		if (startTime != null) {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String st = df.format(startTime);
			String et = df.format(endTime);
			conditionSql += " AND A.START_TIME_ <= TO_DATE('"
					+ et
					+ " 23:59:59"
					+ "', 'YYYY-MM-DD HH24:MI:SS') and A.START_TIME_ >=  TO_DATE('"
					+ st + " 00:00:00" + "', 'YYYY-MM-DD HH24:MI:SS') ";
		}
		if (title != null && !title.equals("")) {
			conditionSql += " AND T.TITLE LIKE '%" + title + "%'";
		}

		finishedTotalSql.append(conditionSql);

		// 得到totalsize
		List<HistoricTaskInstance> finishedTotalList = historyService
				.createNativeHistoricTaskInstanceQuery()
				.sql(finishedTotalSql.toString())
				.parameter("processDefinitionId", processDefinitionId)
				.parameter("userId", userId).list();

		List<HistoricTaskInstance> finishedTaskList = new ArrayList<HistoricTaskInstance>();

		if (finishedTotalList == null || finishedTotalList.size() == 0) {
			return new PageResult<WorkflowFormVo>();
		} else {
			StringBuffer finishedSql = new StringBuffer();
			finishedSql.append("SELECT * FROM");
			finishedSql.append("(SELECT A.*,rownum rn FROM(");
			finishedSql.append(finishedTotalSql.toString());
			finishedSql.append(") a where rownum<=#{endIndex})");
			finishedSql.append(" where rn>=#{startIndex}");

			finishedTaskList = historyService
					.createNativeHistoricTaskInstanceQuery()
					.sql(finishedSql.toString()).parameter("userId", userId)
					.parameter("processDefinitionId", processDefinitionId)
					.parameter("endIndex", currentIndex + pageSize)
					.parameter("startIndex", currentIndex).list();

		}

		return this.createFinishedTaskResult(finishedTaskList, currentIndex,
				pageSize, finishedTotalList.size());
	}

	// 办结
	public PageResult<WorkflowFormVo> findHistoryWorkflows(String userId,
			int currentIndex, int pageSize, Map<String, Object> variables) {
		// 查询条件
		String processDefinitionId = (String) variables
				.get(QueryConditionConstants.PROCESSDEFINITIONID);
		Date startTime = (Date) variables
				.get(QueryConditionConstants.STARTTIME);
		Date endTime = (Date) variables.get(QueryConditionConstants.ENDTIME);

		String title = (String) variables.get(QueryConditionConstants.TITLE);

		StringBuffer historyTotalSql = new StringBuffer();
		historyTotalSql.append("SELECT * FROM ACT_HI_ACTINST A  ");
		historyTotalSql
				.append(" INNER JOIN ACT_HI_PROCINST P ON A.PROC_INST_ID_=P.PROC_INST_ID_");
		historyTotalSql
				.append(" INNER JOIN BZ_FORM_ENTITY T on T.PROCESS_INSTANCE_ID = P.PROC_INST_ID_ ");
		historyTotalSql
				.append(" WHERE A.ASSIGNEE_=#{userId} AND P.END_ACT_ID_ IS NOT NULL");

		String conditionSql = "";

		if ((processDefinitionId != null && !processDefinitionId.equals(""))) {
			conditionSql = " AND A.PROC_DEF_ID_ IN (SELECT D.ID_ FROM ACT_RE_PROCDEF D WHERE D.KEY_=#{processDefinitionId})";
		}

		if (startTime != null) {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String st = df.format(startTime);
			String et = df.format(endTime);
			conditionSql += " AND A.START_TIME_ <= TO_DATE('"
					+ et
					+ " 23:59:59"
					+ "', 'YYYY-MM-DD HH24:MI:SS') and A.START_TIME_ >=  TO_DATE('"
					+ st + " 00:00:00" + "', 'YYYY-MM-DD HH24:MI:SS') ";
		}
		if (title != null && !title.equals("")) {
			conditionSql += " AND T.TITLE LIKE '%" + title + "%'";
		}

		historyTotalSql.append(conditionSql);

		// 得到totalsize
		List<HistoricTaskInstance> historyTotalList = historyService
				.createNativeHistoricTaskInstanceQuery()
				.sql(historyTotalSql.toString())
				.parameter("processDefinitionId", processDefinitionId)
				.parameter("userId", userId).list();

		List<HistoricTaskInstance> historyList = new ArrayList<HistoricTaskInstance>();

		if (historyTotalList == null || historyTotalList.size() == 0) {
			return new PageResult<WorkflowFormVo>();
		} else {
			StringBuffer historySql = new StringBuffer();
			historySql.append("SELECT * FROM ");
			historySql.append(" (SELECT T.*,rownum rn FROM ");
			historySql
					.append(" (SELECT B.* FROM ACT_HI_ACTINST B,(SELECT MAX(A.ID_) AS ID_ ");
			historySql.append(" FROM ACT_HI_ACTINST A ");
			historySql
					.append(" INNER JOIN ACT_HI_PROCINST P ON A.PROC_INST_ID_=P.PROC_INST_ID_  ");
			historySql
					.append(" INNER JOIN BZ_FORM_ENTITY T on T.PROCESS_INSTANCE_ID = P.PROC_INST_ID_  ");
			historySql
					.append(" WHERE A.ASSIGNEE_=#{userId} AND P.END_ACT_ID_ IS NOT NULL ");
			historySql.append(conditionSql);
			historySql.append(" GROUP BY A.PROC_INST_ID_) C ");
			historySql.append(" WHERE B.ID_=C.ID_) T ");
			historySql.append(" where rownum<=#{endIndex}) ");
			historySql.append(" where rn>=#{startIndex} ");

			historyList = historyService
					.createNativeHistoricTaskInstanceQuery()
					.sql(historySql.toString())
					.parameter("processDefinitionId", processDefinitionId)
					.parameter("userId", userId)
					.parameter("endIndex", currentIndex + pageSize)
					.parameter("startIndex", currentIndex).list();
		}
		return this.createHistoryTaskResult(historyList, currentIndex,
				pageSize, historyTotalList.size());
	}

	private PageResult<WorkflowFormVo> createTaskResult(List<Task> taskList,
			int currentIndex, int pageSize, int totalCount) {
		if (taskList == null || taskList.size() == 0) {
			return new PageResult<WorkflowFormVo>();
		}

		List<WorkflowFormVo> workflowFormVoList = new ArrayList<WorkflowFormVo>();

		for (int i = 0; i < taskList.size(); i++) {
			Task task = taskList.get(i);
			ProcessInstance processInstance = runtimeService
					.createProcessInstanceQuery()
					.processInstanceId(task.getProcessInstanceId())
					.singleResult();
			WorkflowFormVo workflowFormVo = new WorkflowFormVo();
			workflowFormVo.setBusinessKey(processInstance.getBusinessKey());
			workflowFormVo.setProcessInstanceId(processInstance.getId());
			workflowFormVo.setTaskId(task.getId());
			workflowFormVoList.add(workflowFormVo);
		}

		PageResult<WorkflowFormVo> pageResult = new PageResult<WorkflowFormVo>();
		pageResult.setContent(workflowFormVoList);
		pageResult.setCurrentIndex(currentIndex);
		pageResult.setPageSize(pageSize);
		pageResult.setTotalCount(totalCount);
		if (0 != pageSize) {
			pageResult.setTotalPage((int) ((pageResult.getTotalCount()
					+ pageSize - 1) / pageSize));
			pageResult
					.setCurrentPage((int) ((pageResult.getCurrentIndex() + pageSize) / pageSize));
		}

		return pageResult;
	}

	private PageResult<WorkflowFormVo> createFinishedTaskResult(
			List<HistoricTaskInstance> taskList, int currentIndex,
			int pageSize, int totalCount) {
		if (taskList == null || taskList.size() == 0) {
			return new PageResult<WorkflowFormVo>();
		}

		List<WorkflowFormVo> workflowFormVoList = new ArrayList<WorkflowFormVo>();

		for (int i = 0; i < taskList.size(); i++) {
			HistoricTaskInstance task = taskList.get(i);
			ProcessInstance processInstance = runtimeService
					.createProcessInstanceQuery()
					.processInstanceId(task.getProcessInstanceId())
					.singleResult();
			WorkflowFormVo workflowFormVo = new WorkflowFormVo();
			workflowFormVo.setBusinessKey(processInstance.getBusinessKey());
			workflowFormVo.setProcessInstanceId(processInstance.getId());
			workflowFormVo.setTaskId(task.getId());
			workflowFormVoList.add(workflowFormVo);
		}

		PageResult<WorkflowFormVo> pageResult = new PageResult<WorkflowFormVo>();
		pageResult.setContent(workflowFormVoList);
		pageResult.setCurrentIndex(currentIndex);
		pageResult.setPageSize(pageSize);
		pageResult.setTotalCount(totalCount);
		if (0 != pageSize) {
			pageResult.setTotalPage((int) ((pageResult.getTotalCount()
					+ pageSize - 1) / pageSize));
			pageResult
					.setCurrentPage((int) ((pageResult.getCurrentIndex() + pageSize) / pageSize));
		}

		return pageResult;
	}

	private PageResult<WorkflowFormVo> createHistoryTaskResult(
			List<HistoricTaskInstance> taskList, int currentIndex,
			int pageSize, int totalCount) {
		if (taskList == null || taskList.size() == 0) {
			return new PageResult<WorkflowFormVo>();
		}

		List<WorkflowFormVo> workflowFormVoList = new ArrayList<WorkflowFormVo>();

		for (int i = 0; i < taskList.size(); i++) {
			HistoricTaskInstance task = taskList.get(i);
			HistoricProcessInstance processInstance = historyService
					.createHistoricProcessInstanceQuery()
					.processInstanceId(task.getProcessInstanceId())
					.singleResult();

			WorkflowFormVo workflowFormVo = new WorkflowFormVo();
			workflowFormVo.setBusinessKey(processInstance.getBusinessKey());
			workflowFormVo.setProcessInstanceId(processInstance.getId());
			workflowFormVo.setTaskId(task.getId());
			workflowFormVoList.add(workflowFormVo);
		}

		PageResult<WorkflowFormVo> pageResult = new PageResult<WorkflowFormVo>();
		pageResult.setContent(workflowFormVoList);
		pageResult.setCurrentIndex(currentIndex);
		pageResult.setPageSize(pageSize);
		pageResult.setTotalCount(totalCount);
		if (0 != pageSize) {
			pageResult.setTotalPage((int) ((pageResult.getTotalCount()
					+ pageSize - 1) / pageSize));
			pageResult
					.setCurrentPage((int) ((pageResult.getCurrentIndex() + pageSize) / pageSize));
		}

		return pageResult;
	}

	public InputStream getWorkflowPicture(String processInstanceId)
			throws IOException {
		// 查询流程实例
		ProcessInstance pi = this.runtimeService.createProcessInstanceQuery()
				.processInstanceId(processInstanceId).singleResult();
		ProcessEngineConfigurationImpl processEngineConfigurationImpl = ((ProcessEngineConfigurationImpl) this.processEngine);
		Context.setProcessEngineConfiguration(processEngineConfigurationImpl);
		BpmnModel bpmnModel = null;
		if (pi != null) {
			bpmnModel = repositoryService.getBpmnModel(pi
					.getProcessDefinitionId());
		} else {
			HistoricProcessInstance processInstance = historyService
					.createHistoricProcessInstanceQuery()
					.processInstanceId(processInstanceId).singleResult();
			ProcessDefinition processDefinition = repositoryService
					.createProcessDefinitionQuery()
					.processDefinitionId(
							processInstance.getProcessDefinitionId())
					.singleResult();
			bpmnModel = repositoryService.getBpmnModel(processDefinition
					.getId());
			return ProcessDiagramGenerator.generateJpgDiagram(bpmnModel);
		}
		// 转换为输入流
		InputStream is = ProcessDiagramGenerator.generateDiagram(bpmnModel,
				"png", runtimeService.getActiveActivityIds(processInstanceId));
		return is;

	}

	public HistoricProcessInstance getProcessByTaskId(String taskId) {
		Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
		HistoricProcessInstance historicProcessInstance = historyService
				.createHistoricProcessInstanceQuery()
				.processInstanceId(task.getProcessInstanceId()).singleResult();
		return historicProcessInstance;
	}

	public Task getTaskByTaskId(String taskId) {
		Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
		return task;
	}

	// // 得到各节点信息
	public List<Map<String, Object>> traceProcess(String processInstanceId)
			throws Exception {
		List<Map<String, Object>> activityInfos = traceService
				.traceProcess(processInstanceId);
		return activityInfos;
	}

	public PageResult<ProcinstVo> findActProcinst(int currentIndex,
			int pageSize, Map<String, Object> variables) {
		String processDefinitionId = (String) variables
				.get(QueryConditionConstants.PROCESSDEFINITIONID);
		Date startTime = (Date) variables
				.get(QueryConditionConstants.STARTTIME);
		Date endTime = (Date) variables.get(QueryConditionConstants.ENDTIME);

		String totalSql = "SELECT * FROM ACT_HI_PROCINST A WHERE A.END_ACT_ID_ IS NULL ";
		if (processDefinitionId != null && !processDefinitionId.equals("")) {
			totalSql += " AND A.PROC_DEF_ID_ LIKE '%" + processDefinitionId
					+ "%' ";
		}
		if (startTime != null) {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String st = df.format(startTime);
			String et = df.format(endTime);
			totalSql += " AND A.START_TIME_ <= TO_DATE('"
					+ et
					+ " 23:59:59"
					+ "', 'YYYY-MM-DD HH24:MI:SS') AND A.START_TIME_ >=  TO_DATE('"
					+ st + " 00:00:00" + "', 'YYYY-MM-DD HH24:MI:SS') ";
		}

		List<HistoricProcessInstance> processInstanceTotalList = historyService
				.createNativeHistoricProcessInstanceQuery().sql(totalSql)
				.list();

		List<HistoricProcessInstance> processInstanceList = new ArrayList<HistoricProcessInstance>();

		if (processInstanceTotalList == null
				|| processInstanceTotalList.size() == 0) {
			return new PageResult<ProcinstVo>();
		} else {
			StringBuffer finishedSql = new StringBuffer();
			finishedSql.append("SELECT * FROM");
			finishedSql.append("(SELECT A.*,rownum rn FROM(");
			finishedSql.append(totalSql.toString());
			finishedSql.append(") a where rownum<=#{endIndex})");
			finishedSql.append(" where rn>=#{startIndex}");

			processInstanceList = historyService
					.createNativeHistoricProcessInstanceQuery()
					.sql(finishedSql.toString())
					.parameter("endIndex", currentIndex + pageSize)
					.parameter("startIndex", currentIndex).list();

		}

		return this.createHistoryProcessResult(processInstanceList,
				currentIndex, pageSize, processInstanceTotalList.size());
	}

	private PageResult<ProcinstVo> createHistoryProcessResult(
			List<HistoricProcessInstance> processList, int currentIndex,
			int pageSize, int totalCount) {
		if (processList == null || processList.size() == 0) {
			return new PageResult<ProcinstVo>();
		}

		List<ProcinstVo> procinstVoList = new ArrayList<ProcinstVo>();

		for (int i = 0; i < processList.size(); i++) {
			HistoricProcessInstance ProcessInstance = processList.get(i);
			ProcinstVo procinstVo = new ProcinstVo();
			procinstVo.setBusinessKey(ProcessInstance.getBusinessKey());
			procinstVo.setStartUserId(ProcessInstance.getStartUserId());
			procinstVo.setStartTime(ProcessInstance.getStartTime());
			procinstVo.setId(Long.valueOf(ProcessInstance.getId()));
			String[] sp = ProcessInstance.getProcessDefinitionId().split(":");
			procinstVo.setType(sp[0]);
			procinstVo.setVersion(sp[1]);
			procinstVo.setDefId(sp[2]);
			procinstVoList.add(procinstVo);
		}

		PageResult<ProcinstVo> pageResult = new PageResult<ProcinstVo>();
		pageResult.setContent(procinstVoList);
		pageResult.setCurrentIndex(currentIndex);
		pageResult.setPageSize(pageSize);
		pageResult.setTotalCount(totalCount);
		if (0 != pageSize) {
			pageResult.setTotalPage((int) ((pageResult.getTotalCount()
					+ pageSize - 1) / pageSize));
			pageResult
					.setCurrentPage((int) ((pageResult.getCurrentIndex() + pageSize) / pageSize));
		}

		return pageResult;

	}

}
