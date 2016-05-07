package itaf.framework.workflow.vo;

import itaf.framework.core.domain.BaseEntity;

import java.util.Date;

/**
 * 
 * @author XINXIN
 * 
 * @update 2013年1月22日
 */
public class WorkflowFormVo extends BaseEntity {

	private static final long serialVersionUID = 1L;

	// 为了分页,存放businessKey
	private Long id;
	// 流程实例Id
	private String processInstanceId;
	// 表单对象Id
	private String businessKey;
	// 表单名称
	private String formName;
	// 发起人的用户名
	private String draftUsername;
	// 流程开始时间
	private Date submitTime;
	// 当前任务ID
	private String taskId;
	// 标题
	private String title;
	// 调用页面的URL
	private String pageUrl;

	private String viewPageUrl;

	private String state;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getViewPageUrl() {
		return viewPageUrl;
	}

	public void setViewPageUrl(String viewPageUrl) {
		this.viewPageUrl = viewPageUrl;
	}

	public Long getId() {
		return id;
	}

	public String getProcessInstanceId() {
		return processInstanceId;
	}

	public String getBusinessKey() {
		return businessKey;
	}

	public String getFormName() {
		return formName;
	}

	public String getDraftUsername() {
		return draftUsername;
	}

	public Date getSubmitTime() {
		return submitTime;
	}

	public String getTaskId() {
		return taskId;
	}

	public String getTitle() {
		return title;
	}

	public String getPageUrl() {
		return pageUrl;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}

	public void setBusinessKey(String businessKey) {
		this.businessKey = businessKey;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

	public void setDraftUsername(String draftUsername) {
		this.draftUsername = draftUsername;
	}

	public void setSubmitTime(Date submitTime) {
		this.submitTime = submitTime;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}

}
