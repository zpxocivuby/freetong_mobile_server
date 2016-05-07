package itaf.framework.web.workflow.action;

import itaf.framework.core.common.PageResult;
import itaf.framework.core.constant.QueryConditionConstants;
import itaf.framework.core.util.SpringContextUtil;
import itaf.framework.web.base.action.BaseRichFacesDataGridAction;
import itaf.framework.web.util.ProcessQueryUtil;
import itaf.framework.workflow.service.WorkflowProcessService;
import itaf.framework.workflow.vo.WorkflowFormVo;

import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 * 我的已办
 * 
 * @author XINXIN
 * 
 * @update 2013年1月23日
 */
@ManagedBean(name = "finishedWorkflowAction")
@ViewScoped
public class FinishedWorkflowAction extends
		BaseRichFacesDataGridAction<WorkflowFormVo> {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{workflowProcessServiceImpl}")
	private WorkflowProcessService workflowProcessService;

	public void setWorkflowProcessService(
			WorkflowProcessService workflowProcessService) {
		this.workflowProcessService = workflowProcessService;
	}

	protected PageResult<WorkflowFormVo> getPageContent() {
		workflowProcessService = this.getWorkflowProcessService();
		int currentIndex = queryCriteria.getStartIndex();
		int pageSize = queryCriteria.getPageSize();
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put(QueryConditionConstants.STARTTIME,
				ProcessQueryUtil.processDate(queryCriteria, "startTime"));
		variables.put(QueryConditionConstants.ENDTIME,
				ProcessQueryUtil.processDate(queryCriteria, "endTime"));
		variables.put(QueryConditionConstants.PROCESSDEFINITIONID,
				ProcessQueryUtil.processString(queryCriteria,
						"processDefinitionId"));
		variables.put(QueryConditionConstants.TITLE,
				ProcessQueryUtil.processString(queryCriteria, "title"));
		return workflowProcessService.findFinishedWorkflows(getCurrUserId(),
				currentIndex, pageSize, variables);
	}

	private WorkflowProcessService getWorkflowProcessService() {
		if (workflowProcessService == null) {
			workflowProcessService = (WorkflowProcessService) SpringContextUtil
					.getBean("workflowProcessServiceImpl");
		}
		return workflowProcessService;
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		
	}

}
