package itaf.framework.domain.workflow;

import static javax.persistence.GenerationType.IDENTITY;
import itaf.framework.domain.base.OperateEntity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * 流程审批信息
 * 
 * @author
 * 
 * @update 2013年2月1日
 */
@Entity
@Table(name = "BZ_APPROVAL_INFO")
public class BzApprovalInfo extends OperateEntity {

	private static final long serialVersionUID = 7505033766464511388L;

	// ID
	private Long id;
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

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "BZ_APPROVAL_INFO_ID", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	@Column(name = "PROCESS_INSTANCE_ID", length = 10)
	public String getProcessInstanceId() {
		return processInstanceId;
	}

	@Column(name = "TASK_ID", length = 10)
	public String getTaskId() {
		return taskId;
	}

	@Column(name = "BUSSINESS_KEY", length = 10)
	public String getBussinessKey() {
		return bussinessKey;
	}

	@Column(name = "ACTIVITY_NAME", length = 100)
	public String getActivityName() {
		return activityName;
	}

	@Column(name = "APPROVAL_NAME", length = 100)
	public String getApprovalName() {
		return approvalName;
	}

	@Column(name = "APPROVAL_STATE", length = 10)
	public String getApprovalState() {
		return approvalState;
	}

	@Column(name = "APPROVAL_INFO", length = 3000)
	public String getApprovalInfo() {
		return approvalInfo;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "APPROVAL_TIME", updatable = false)
	public Date getApprovalTime() {
		return approvalTime;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public void setBussinessKey(String bussinessKey) {
		this.bussinessKey = bussinessKey;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public void setApprovalName(String approvalName) {
		this.approvalName = approvalName;
	}

	public void setApprovalState(String approvalState) {
		this.approvalState = approvalState;
	}

	public void setApprovalInfo(String approvalInfo) {
		this.approvalInfo = approvalInfo;
	}

	public void setApprovalTime(Date approvalTime) {
		this.approvalTime = approvalTime;
	}

}
