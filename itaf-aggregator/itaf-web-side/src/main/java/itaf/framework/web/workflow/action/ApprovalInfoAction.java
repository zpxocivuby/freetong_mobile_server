package itaf.framework.web.workflow.action;

import itaf.framework.core.util.SpringContextUtil;
import itaf.framework.web.base.action.BaseAction;
import itaf.framework.web.util.ProcessQueryUtil;
import itaf.framework.workflow.service.ApprovalInfoService;
import itaf.framework.workflow.service.WorkflowProcessService;
import itaf.framework.workflow.vo.ApprovalInfoVo;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang.StringUtils;

/**
 * 审批信息列表
 * 
 * @author XINXIN
 * 
 * @update 2013年1月28日
 */
@ManagedBean(name = "approvalInfoAction")
@ViewScoped
public class ApprovalInfoAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{workflowProcessServiceImpl}")
	private WorkflowProcessService workflowProcessService;

	public ApprovalInfoService getApprovalInfoService() {
		return approvalInfoService;
	}

	public void setApprovalInfoService(ApprovalInfoService approvalInfoService) {
		this.approvalInfoService = approvalInfoService;
	}

	public void setWorkflowProcessService(
			WorkflowProcessService workflowProcessService) {
		this.workflowProcessService = workflowProcessService;
	}

	@ManagedProperty(value = "#{approvalInfoServiceImpl}")
	private ApprovalInfoService approvalInfoService;

	private List<ApprovalInfoVo> approvalInfoVos;

	public List<ApprovalInfoVo> getApprovalInfoVos() {
		workflowProcessService = this.getWorkflowProcessService();
		String processInstanceId = ProcessQueryUtil
				.getValueOfForm("processInstanceId");
		if (StringUtils.trimToNull(processInstanceId) != null) {
			approvalInfoVos = approvalInfoService
					.findApprovalInfos(processInstanceId);
		}
		return approvalInfoVos;
	}

	private WorkflowProcessService getWorkflowProcessService() {
		if (workflowProcessService == null) {
			workflowProcessService = (WorkflowProcessService) SpringContextUtil
					.getBean("workflowProcessServiceImpl");
		}
		return workflowProcessService;
	}

	public void setApprovalInfoVos(List<ApprovalInfoVo> approvalInfoVos) {
		this.approvalInfoVos = approvalInfoVos;
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		
	}

}