package itaf.framework.workflow.service;

import itaf.framework.core.common.PageResult;
import itaf.framework.workflow.vo.ApprovalInfoVo;
import itaf.framework.workflow.vo.ProcinstVo;
import itaf.framework.workflow.vo.WorkflowFormVo;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author XINXIN
 * 
 * @update 2013年1月22日
 */
public interface WorkflowProcessService {

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
	 * @return PageResult<ProcessInstanceVo>
	 */
	public PageResult<WorkflowFormVo> findProcessingWorkflows(Long userId,
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
	public PageResult<WorkflowFormVo> findFinishedWorkflows(Long userId,
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
	public PageResult<WorkflowFormVo> findHistoryWorkflows(Long userId,
			int currentIndex, int pageSize, Map<String, Object> variables);

	/**
	 * 查找审批信息
	 * 
	 * @param processInstanceId
	 *            流程实例Id
	 * @return List<ApprovalInfoVo>
	 */
	public List<ApprovalInfoVo> findApprovalInfos(String processInstanceId);

	/**
	 * 获取流程图
	 * 
	 * @param processInstanceId
	 *            流程实例Id
	 * @return InputStream
	 * @throws Exception
	 */
	public InputStream getWorkflowPicture(String processInstanceId)
			throws Exception;

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
	public void doApproveWorkflow(Long userId, String taskId,
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
	public void doRejectWorkflow(Long userId, String taskId,
			String approvalInfo, String userName);

	public void doDeleteProcessInstance(Long id, String processInstanceId);
	
	public PageResult<ProcinstVo> findActProcinst(int currentIndex, int pageSize, Map<String, Object> variables);

}
