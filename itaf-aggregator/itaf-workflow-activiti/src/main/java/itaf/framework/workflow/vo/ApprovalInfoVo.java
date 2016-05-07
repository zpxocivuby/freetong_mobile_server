package itaf.framework.workflow.vo;

import itaf.framework.domain.platform.SysAttachment;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author XINXIN
 * 
 * @update 2013年1月22日
 */
public class ApprovalInfoVo implements Serializable {

	private static final long serialVersionUID = 1L;

	// 流程实例ID
	private String processInstanceId;
	// 任务ID
	private String taskId;
	// 业务主键
	private String bussinessKey;
	// 节点名称
	private String activityName;
	// 审批用户名称
	private String approvalName;
	// 审批状态
	private String approvalState;
	// 审批意见
	private String approvalInfo;
	// 审批时间
	private Date approvalTime;

	private List<SysAttachment> attachments;

	public String getProcessInstanceId() {
		return processInstanceId;
	}

	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getBussinessKey() {
		return bussinessKey;
	}

	public void setBussinessKey(String bussinessKey) {
		this.bussinessKey = bussinessKey;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getApprovalName() {
		return approvalName;
	}

	public void setApprovalName(String approvalName) {
		this.approvalName = approvalName;
	}

	public String getApprovalState() {
		return approvalState;
	}

	public void setApprovalState(String approvalState) {
		this.approvalState = approvalState;
	}

	public String getApprovalInfo() {
		return approvalInfo;
	}

	public void setApprovalInfo(String approvalInfo) {
		this.approvalInfo = approvalInfo;
	}

	public Date getApprovalTime() {
		return approvalTime;
	}

	public void setApprovalTime(Date approvalTime) {
		this.approvalTime = approvalTime;
	}

	public List<SysAttachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<SysAttachment> attachments) {
		this.attachments = attachments;
	}

}
