/**
 * 
 */
package itaf.framework.workflow.service;

import itaf.framework.core.common.PageResult;
import itaf.framework.workflow.vo.ApprovalInfoVo;
import itaf.framework.workflow.vo.ProcinstVo;
import itaf.framework.workflow.vo.WorkflowFormVo;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

/**
 * @author xiaoly
 * 
 */
public interface WorkFlowService {
	/**
	 * 启动工作流
	 * 
	 * @param key
	 * @param businessKey
	 * @param variables
	 * @return
	 */
	public ProcessInstance startWorkflow(String key, String businessKey,
			Map<String, Object> variables);

	/**
	 * 根据用户Id查询待办任务列表
	 * 
	 * @param userid
	 *            用户id
	 * @param processDefinitionKey
	 *            流程定义的key
	 * @return
	 */
	public List<Task> findTask(String userid, String processDefinitionKey);

	/**
	 * 查询运行中的流程实例
	 * 
	 * @param processDefinitionKey
	 *            流程定义的key
	 * @return
	 */
	public List<ProcessInstance> findRunningProcessInstaces(
			String processDefinitionKey);

	/**
	 * 查询已结束的流程实例
	 * 
	 * @param processDefinitionKey
	 * @return
	 */
	public List<HistoricProcessInstance> findFinishedProcessInstaces(
			String processDefinitionKey);

	/**
	 * 根据流程定义Id查询流程定义
	 * 
	 * @param processDefinitionId
	 * @return
	 */
	public ProcessDefinition getProcessDefinition(String processDefinitionId);

	public TaskEntity findTaskById(String taskId) throws Exception;

	/**
	 * 启动流程
	 * 
	 * @param userId
	 *            用户Id
	 * @param key
	 *            流程定义Id
	 * @param businessKey
	 *            表单实例Id
	 * @return 流程实例Id
	 */
	public String doStartWorkflow(String userId, String key,
			String businessKey, Map<String, Object> variables);

	/**
	 * 审批通过
	 * 
	 * @param userId
	 *            用户Id
	 * @param taskId
	 *            任务Id
	 * @param rejectInfo
	 *            approvalInfo
	 */
	public void doApproveWorkflow(String userId, String taskId,
			String approvalInfo, String userName);

	/**
	 * 审批驳回
	 * 
	 * @param userId
	 *            用户Id
	 * @param taskId
	 *            任务Id
	 * @param rejectInfo
	 *            approvalInfo
	 */
	public void doRejectWorkflow(String userId, String taskId,
			String approvalInfo, String userName);

	/** 
	 * 我的待办列表
	 * 
	 * @param userId
	 *            用户Id
	 * @param currentIndex
	 *            当前第几条
	 * @param pageSize
	 *            取的条数
	 * @param variables
	 *            查询条件
	 * 
	 * @return PageResult<ProcessInstanceVo>
	 */
	public PageResult<WorkflowFormVo> findProcessingWorkflows(String userId,
			int currentIndex, int pageSize, Map<String, Object> variables);

	/**
	 * 我的已办列表
	 * 
	 * @param userId
	 *            用户Id
	 * @param currentIndex
	 *            当前第几条
	 * @param pageSize
	 *            取的条数
	 * @param variables
	 *            查询条件
	 * @return PageResult<ProcessInstanceVo>
	 */
	public PageResult<WorkflowFormVo> findFinishedWorkflows(String userId,
			int currentIndex, int pageSize, Map<String, Object> variables);

	/**
	 * 我的办结列表
	 * 
	 * @param userId
	 *            用户Id
	 * @param currentIndex
	 *            当前第几条
	 * @param pageSize
	 *            取的条数
	 * @param variables
	 *            查询条件
	 * @return PageResult<ProcessInstanceVo>
	 */
	public PageResult<WorkflowFormVo> findHistoryWorkflows(String userId,
			int currentIndex, int pageSize, Map<String, Object> variables);

	/**
	 * 查找审批信息
	 * 
	 * @param processInstanceId
	 *            流程实例Id
	 * @return List<ApprovalInfoVo>
	 */
	public List<ApprovalInfoVo> findApprovalInfos(String processInstanceId);

	// /**
	// * 获取流程图
	// *
	// * @param processInstanceId
	// * 流程实例Id
	// * @return InputStream
	// * @throws Exception
	// */
	// public InputStream loadByProcessInstance(String processInstanceId)
	// throws Exception;
	//
	// /**
	// * 获取流程图的详细信息
	// *
	// * @param processInstanceId
	// * 流程实例Id
	// * @return List<Map<String, Object>>
	// * @throws Exception
	// */
	// public List<Map<String, Object>> traceProcess(String processInstanceId)
	// throws Exception;

	/**
	 * 获取高亮的流程图流程图
	 * 
	 * @param processInstanceId
	 *            流程实例Id
	 * @return InputStream
	 * @throws Exception
	 */
	public InputStream getWorkflowPicture(String processInstanceId)
			throws IOException;

	public void deleteProcessInstance(String processInstanceId);

	public HistoricProcessInstance getProcessByTaskId(String taskId);

	public Task getTaskByTaskId(String taskId);

	public List<Map<String, Object>> traceProcess(String processInstanceId)
			throws Exception;

	public Task findFirstActTask(String userId, String processInstanceId);

	public PageResult<ProcinstVo> findActProcinst(int currentIndex,
			int pageSize, Map<String, Object> variables);
	
	public Deployment deployment(String resourceName,InputStream inputStream);
}
