package itaf.framework.web.workflow.action;

import itaf.framework.core.common.PageResult;
import itaf.framework.core.constant.CodeListConstant;
import itaf.framework.core.constant.QueryConditionConstants;
import itaf.framework.core.util.SpringContextUtil;
import itaf.framework.web.base.action.BaseRichFacesDataGridAction;
import itaf.framework.web.util.CodeListHelper;
import itaf.framework.web.util.ProcessQueryUtil;
import itaf.framework.workflow.service.WorkflowProcessService;
import itaf.framework.workflow.vo.WorkflowFormVo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

/**
 * 我的代办
 * 
 * @author XINXIN
 * 
 * @update 2013年1月23日
 */

@ManagedBean(name = "processingWorkflowAction")
@RequestScoped
public class ProcessingWorkflowAction extends
		BaseRichFacesDataGridAction<WorkflowFormVo> {

	private static final long serialVersionUID = 1L;

	public void setWorkflowProcessService(
			WorkflowProcessService workflowProcessService) {
		this.workflowProcessService = workflowProcessService;
	}

	@ManagedProperty(value = "#{workflowProcessServiceImpl}")
	private WorkflowProcessService workflowProcessService;
	
	private List<SelectItem> checkBoxItemsProcessDefinitionChecked;
	
	public List<SelectItem> getCheckBoxItemsProcessDefinitionChecked() {
		this.checkBoxItemsProcessDefinitionChecked = CodeListHelper
				.initCheckBox(CodeListConstant.PROCESSDEFINITION);
		return checkBoxItemsProcessDefinitionChecked;
	}

	public void setCheckBoxItemsProcessDefinitionChecked(
			List<SelectItem> checkBoxItemsProcessDefinitionChecked) {
		this.checkBoxItemsProcessDefinitionChecked = checkBoxItemsProcessDefinitionChecked;
	}

	protected PageResult<WorkflowFormVo> getPageContent() {
		workflowProcessService = this.getWorkflowProcessService();
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put(QueryConditionConstants.STARTTIME,
				ProcessQueryUtil.processDate(queryCriteria, "startTime"));
		variables.put(QueryConditionConstants.ENDTIME,
				ProcessQueryUtil.processDate(queryCriteria, "endTime"));
		variables.put(QueryConditionConstants.PROCESSDEFINITIONID, ProcessQueryUtil.processString(queryCriteria, "processDefinitionId"));
		variables.put(QueryConditionConstants.TITLE,
				ProcessQueryUtil.processString(queryCriteria, "title"));
		return workflowProcessService.findProcessingWorkflows(
				getCurrUserId(), queryCriteria.getStartIndex(),
				queryCriteria.getPageSize(), variables);
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
