package itaf.framework.web.workflow.action;

import itaf.framework.core.common.PageResult;
import itaf.framework.core.util.SpringContextUtil;
import itaf.framework.domain.workflow.BzFormEntity;
import itaf.framework.web.base.action.BaseRichFacesDataGridAction;
import itaf.framework.web.util.ProcessQueryUtil;
import itaf.framework.workflow.service.FormEntityService;

import java.util.Date;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

/**
 * 我的草稿
 * 
 * @author XINXIN
 * 
 * @update 2013年1月23日
 */

@ManagedBean(name = "draftWorkflowAction")
@SessionScoped
public class DraftWorkflowAction extends
		BaseRichFacesDataGridAction<BzFormEntity> {

	public void setFormEntityService(FormEntityService formEntityService) {
		this.formEntityService = formEntityService;
	}

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{formEntityServiceImpl}")
	private FormEntityService formEntityService;

	private SelectItem[] approvalStateItems;

	protected PageResult<BzFormEntity> getPageContent() {
		processQueryCondiction();
		PageResult<BzFormEntity> pr = this.getFormEntityService()
				.findByCriteria(queryCriteria);
		return pr;
	}

	public void delete() {
		Long id = Long.valueOf(ProcessQueryUtil.getValueOfForm("id"));
		formEntityService.doDeleteById(id);
	}

	private void processQueryCondiction() {
		Map<String, Object> condition = queryCriteria.getQueryCondition();
		condition.put("userId", getCurrUserId());
		condition.put("title",
				ProcessQueryUtil.processStirngLike(queryCriteria, "title", 3));
		condition
				.put("approvalState", ProcessQueryUtil.processInteger(
						queryCriteria, "approvalState"));
		Date startDate = null;
		Date endDate = null;
		if (ProcessQueryUtil.processDate(queryCriteria, "startDate") != null) {
			startDate = ProcessQueryUtil.processStartDate(queryCriteria,
					"startDate");
			
		}
		if (ProcessQueryUtil.processDate(queryCriteria, "endDate") != null) {
			endDate = ProcessQueryUtil.processEndDate(queryCriteria, "endDate");
		}
		condition.put("startDate", startDate);
		condition.put("endDate", endDate);
		condition.put("processDefinitionId", ProcessQueryUtil.processString(
				queryCriteria, "processDefinitionId"));
		condition.put("isDeleted", false);
	}

	private FormEntityService getFormEntityService() {
		if (formEntityService == null) {
			formEntityService = (FormEntityService) SpringContextUtil
					.getBean("formEntityServiceImpl");
		}
		return formEntityService;
	}

	public SelectItem[] getApprovalStateItems() {
		approvalStateItems = new SelectItem[4];
		approvalStateItems[0] = new SelectItem("", "全部");
		approvalStateItems[1] = new SelectItem("1", "拟稿");
		approvalStateItems[2] = new SelectItem("2", "运行中");
		approvalStateItems[3] = new SelectItem("3", "完结");
		return approvalStateItems;
	}

	public void setApprovalStateItems(SelectItem[] approvalStateItems) {
		this.approvalStateItems = approvalStateItems;
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		
	}
}
