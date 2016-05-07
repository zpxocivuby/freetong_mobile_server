package itaf.framework.web.workflow.action;

import itaf.framework.core.app.AppContext;
import itaf.framework.domain.workflow.BzApprovalInfo;
import itaf.framework.web.base.action.BaseAction;
import itaf.framework.web.util.ProcessQueryUtil;
import itaf.framework.workflow.service.ApprovalInfoService;
import itaf.framework.workflow.service.WorkFlowService;
import itaf.framework.workflow.service.WorkflowProcessService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.task.Task;

/**
 * 
 * @author XINXIN
 * 
 * @update 2013年2月5日
 */

@ManagedBean(name = "baseFormAction")
@ViewScoped
public class BaseFormAction extends BaseAction {

	public WorkflowProcessService getWorkflowProcessService() {
		return workflowProcessService;
	}

	public void setWorkflowProcessService(
			WorkflowProcessService workflowProcessService) {
		this.workflowProcessService = workflowProcessService;
	}

	public WorkFlowService getWorkFlowService() {
		return workFlowService;
	}

	public void setWorkFlowService(WorkFlowService workFlowService) {
		this.workFlowService = workFlowService;
	}

	public ApprovalInfoService getApprovalInfoService() {
		return approvalInfoService;
	}

	public void setApprovalInfoService(ApprovalInfoService approvalInfoService) {
		this.approvalInfoService = approvalInfoService;
	}

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{workflowProcessServiceImpl}")
	private WorkflowProcessService workflowProcessService;

	@ManagedProperty(value = "#{workFlowServiceImpl}")
	private WorkFlowService workFlowService;

	@ManagedProperty(value = "#{approvalInfoServiceImpl}")
	private ApprovalInfoService approvalInfoService;

	private SelectItem[] formNameItems;
	private String taskId;
	private String processInstanceId;

	private String approveInfo;

	public String getApproveInfo() {
		String taskId = ProcessQueryUtil.getValueOfForm("taskId");
		BzApprovalInfo approvalInfo = approvalInfoService
				.getApprovalInfoByTaskId(taskId);
		if (approvalInfo == null) {
			return "同意";
		}
		approveInfo = approvalInfo.getApprovalInfo();
		return approveInfo;
	}

	public void setApproveInfo(String approveInfo) {
		this.approveInfo = approveInfo;
	}

	public SelectItem[] getFormNameItems() {
		formNameItems = new SelectItem[5];
		formNameItems[0] = new SelectItem("", "全部");
		formNameItems[1] = new SelectItem("otr", "otr");
		formNameItems[3] = new SelectItem("secondLevel", "工作事项二级审批");
		formNameItems[4] = new SelectItem("thirdLevel", "工作事项三级审批");
		return formNameItems;
	}

	public void setFormNameItems(SelectItem[] formNameItems) {
		this.formNameItems = formNameItems;
	}

	public void doSaveApprove() {
		String approvalInfo = ProcessQueryUtil.getValueOfForm("approvalInfo");
		String taskId = ProcessQueryUtil.getValueOfForm("taskId");
		Task task = workFlowService.getTaskByTaskId(taskId);
		HistoricProcessInstance processInstance = workFlowService
				.getProcessByTaskId(taskId);
		approvalInfoService.doSaveApprove(processInstance, task, approvalInfo,
				getCurrUserId());
	}

	public void doSaveReject() {
		String approvalInfo = ProcessQueryUtil.getValueOfForm("approvalInfo");
		String taskId = ProcessQueryUtil.getValueOfForm("taskId");
		Task task = workFlowService.getTaskByTaskId(taskId);
		HistoricProcessInstance processInstance = workFlowService
				.getProcessByTaskId(taskId);
		approvalInfoService.doSaveReject(processInstance, task, approvalInfo,
				getCurrUserId());
	}

	public void approve() {
		String approvalInfo = ProcessQueryUtil.getValueOfForm("approvalInfo");
		workflowProcessService.doApproveWorkflow(getCurrUserId(), this
				.getTaskId(), approvalInfo, AppContext.getSessionUser()
				.getUsername());
	}

	public void reject() {
		String approvalInfo = ProcessQueryUtil.getValueOfForm("approvalInfo");
		workflowProcessService.doRejectWorkflow(getCurrUserId(), this
				.getTaskId(), approvalInfo, AppContext.getSessionUser()
				.getUsername());
	}

	public void deleteProcessInstance() {
		Long id = Long.valueOf(ProcessQueryUtil.getValueOfForm("id"));
		workflowProcessService.doDeleteProcessInstance(id,
				this.getProcessInstanceId());
	}

	public String getProcessInstanceId() {
		processInstanceId = ProcessQueryUtil
				.getValueOfForm("processInstanceId");
		return processInstanceId;
	}

	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}

	public String getTaskId() {
		taskId = ProcessQueryUtil.getValueOfForm("taskId");
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		
	}

}
