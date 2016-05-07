package itaf.framework.workflow.service.impl;

import itaf.framework.core.common.PageResult;
import itaf.framework.domain.workflow.BzApprovalInfo;
import itaf.framework.domain.workflow.BzFormEntity;
import itaf.framework.persistence.workflow.dao.BzApprovalInfoDao;
import itaf.framework.workflow.base.service.impl.BaseServiceImpl;
import itaf.framework.workflow.service.ApprovalInfoService;
import itaf.framework.workflow.service.FormEntityService;
import itaf.framework.workflow.service.WorkFlowService;
import itaf.framework.workflow.service.WorkflowProcessService;
import itaf.framework.workflow.util.FormConstants;
import itaf.framework.workflow.vo.ApprovalInfoVo;
import itaf.framework.workflow.vo.ProcinstVo;
import itaf.framework.workflow.vo.WorkflowFormVo;

import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author XINXIN
 * 
 * @update 2013年1月22日
 */
@Service("workflowProcessServiceImpl")
public class WorkflowProcessServiceImpl extends BaseServiceImpl implements
		WorkflowProcessService {

	@Autowired
	private WorkFlowService workFlowService;
	@Autowired
	private FormEntityService formEntityService;
	@Autowired
	private BzApprovalInfoDao approvalInfoDao;
	@Autowired
	private ApprovalInfoService approvalInfoService;


	public PageResult<WorkflowFormVo> findProcessingWorkflows(Long userId,
			int currentIndex, int pageSize, Map<String, Object> variables) {
		PageResult<WorkflowFormVo> result = workFlowService
				.findProcessingWorkflows(String.valueOf(userId), currentIndex,
						pageSize, variables);
		List<WorkflowFormVo> content = (List<WorkflowFormVo>) result
				.getContent();
		processContent(content);
		return result;
	}

	public PageResult<WorkflowFormVo> findFinishedWorkflows(Long userId,
			int currentIndex, int pageSize, Map<String, Object> variables) {
		PageResult<WorkflowFormVo> result = workFlowService
				.findFinishedWorkflows(String.valueOf(userId), currentIndex,
						pageSize, variables);
		List<WorkflowFormVo> content = (List<WorkflowFormVo>) result
				.getContent();
		processContent(content);
		return result;
	}

	public PageResult<WorkflowFormVo> findHistoryWorkflows(Long userId,
			int currentIndex, int pageSize, Map<String, Object> variables) {
		PageResult<WorkflowFormVo> result = workFlowService
				.findHistoryWorkflows(String.valueOf(userId), currentIndex,
						pageSize, variables);
		List<WorkflowFormVo> content = (List<WorkflowFormVo>) result
				.getContent();
		processContent(content);
		return result;
	}
	
	public PageResult<ProcinstVo> findActProcinst(int currentIndex, int pageSize, Map<String, Object> variables) {
		PageResult<ProcinstVo> result = workFlowService
				.findActProcinst(currentIndex,
						pageSize, variables);
		return result;
	}

	private void processContent(List<WorkflowFormVo> content) {
		if (content != null && content.size() > 0) {
			Set<Long> ids = new HashSet<Long>();
			for (WorkflowFormVo vo : content) {
				ids.add(Long.valueOf(vo.getBusinessKey()));
			}
			List<BzFormEntity> formEntitys = formEntityService.findByIds(ids);
			Map<String, BzFormEntity> mapContent = new HashMap<String, BzFormEntity>();
			for (BzFormEntity formEntity : formEntitys) {
				mapContent.put(String.valueOf(formEntity.getId()), formEntity);
			}
			for (WorkflowFormVo vo : content) {
				BzFormEntity formEntity = mapContent.get(vo.getBusinessKey());
				vo.setId(formEntity.getId());
				vo.setDraftUsername(formEntity.getCreateUserName());
				vo.setFormName(formEntity.getFormName());
				vo.setPageUrl(formEntity.getPageUrlAndParams());
				vo.setSubmitTime(formEntity.getSubmitTime());
				vo.setTitle(formEntity.getTitle());
				vo.setViewPageUrl(formEntity.getViewPageUrlAndParams());
				vo.setState(formEntity.getState());
			}
		}
	}

	public List<ApprovalInfoVo> findApprovalInfos(String processInstanceId) {
		List<ApprovalInfoVo> result = workFlowService
				.findApprovalInfos(processInstanceId);
		return result;
	}

	public InputStream getWorkflowPicture(String processInstanceId)
			throws Exception {
		return workFlowService.getWorkflowPicture(processInstanceId);
	}

	public void doApproveWorkflow(Long userId, String taskId,
			String approvalInfo, String userName) {
		Task task = workFlowService.getTaskByTaskId(taskId);
		HistoricProcessInstance processInstance = workFlowService
				.getProcessByTaskId(taskId);
		BzApprovalInfo approval = approvalInfoService
				.getApprovalInfoByTaskId(taskId);
		BzApprovalInfo approvalObject;
		// 新建
		if (approval == null) {
			approvalObject = new BzApprovalInfo();
			approvalObject.setActivityName(task.getName());
			approvalObject.setApprovalName(String.valueOf(userId));
			approvalObject.setApprovalInfo(approvalInfo);
			approvalObject.setApprovalState("通过");
			approvalObject.setTaskId(task.getId());
			approvalObject.setProcessInstanceId(processInstance.getId());
			approvalObject.setBussinessKey(processInstance.getBusinessKey());
			approvalObject.setApprovalTime(new Date());
		} else {
			approvalObject = approvalInfoService.getApprovalInfoById(approval
					.getId());
			approvalObject.setApprovalInfo(approvalInfo);
			approvalObject.setApprovalTime(new Date());
			approvalObject.setApprovalState("通过");
		}
		approvalInfoService.doSaveObject(approvalObject);

		workFlowService.doApproveWorkflow(String.valueOf(userId), taskId,
				approvalInfo, userName);
		/*if(task.getName().equals("责任人审批")){
			BzOtrCreate bzOtrCreate = bzOtrCreateService.findById(Long.valueOf(processInstance.getBusinessKey()));
			bzOtrCreate.setApprovalState(FormConstants.FORM_STATE_FINISH);
			bzOtrCreateService.doSave(bzOtrCreate);
		}*/
	}

	public void doRejectWorkflow(Long userId, String taskId,
			String approvalInfo, String userName) {
		Task task = workFlowService.getTaskByTaskId(taskId);
		HistoricProcessInstance processInstance = workFlowService
				.getProcessByTaskId(taskId);
		BzApprovalInfo approval = approvalInfoService
				.getApprovalInfoByTaskId(task.getId());
		BzApprovalInfo approvalObject;
		// 新建
		if (approval == null) {
			approvalObject = new BzApprovalInfo();
			approvalObject.setActivityName(task.getName());
			approvalObject.setApprovalName(String.valueOf(userId));
			approvalObject.setApprovalInfo(approvalInfo);
			approvalObject.setApprovalState("退回");
			approvalObject.setTaskId(task.getId());
			approvalObject.setProcessInstanceId(processInstance.getId());
			approvalObject.setBussinessKey(processInstance.getBusinessKey());
			approvalObject.setApprovalTime(new Date());
		} else {
			approvalObject = approvalInfoService.getApprovalInfoById(approval
					.getId());
			approvalObject.setApprovalInfo(approvalInfo);
			approvalObject.setApprovalTime(new Date());
			approvalObject.setApprovalState("退回");
		}
		approvalInfoService.doSaveObject(approvalObject);

		workFlowService.doRejectWorkflow(String.valueOf(userId), taskId,
				approvalInfo, userName);
		/*if(task.getName().equals("直属领导审批")){
			BzOtrCreate bzOtrCreate = bzOtrCreateService.findById(Long.valueOf(processInstance.getBusinessKey()));
			bzOtrCreate.setApprovalState(FormConstants.FORM_STATE_FINISH);
			bzOtrCreateService.doSave(bzOtrCreate);
		}*/
	}

	public void doDeleteProcessInstance(Long id, String processInstanceId) {
		workFlowService.deleteProcessInstance(processInstanceId);
		BzFormEntity formEntity = formEntityService.findById(id);
		formEntity.setApprovalState(FormConstants.FORM_STATE_DRAFT);
		formEntity.setProcessInstanceId(null);
		formEntity.setSubmitTime(null);
		formEntityService.doSave(formEntity);
	}

}
