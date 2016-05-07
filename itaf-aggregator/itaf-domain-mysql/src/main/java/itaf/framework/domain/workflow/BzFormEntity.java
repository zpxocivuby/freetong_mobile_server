package itaf.framework.domain.workflow;

import static javax.persistence.GenerationType.IDENTITY;
import itaf.framework.domain.base.OperateEntity;
import itaf.framework.domain.platform.SysRole;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * 与表单一对一的关系，保存所有公共信息
 * 
 * @author
 * 
 * @update 2013年1月17日
 */
@Entity
@Table(name = "BZ_FORM_ENTITY")
@Inheritance(strategy = InheritanceType.JOINED)
public class BzFormEntity extends OperateEntity {

	private static final long serialVersionUID = 8577669953529750044L;

	private Long id;
	// 表单标题
	private String title;
	// 表单名称
	private String formName;
	// 提交时间
	private Date submitTime;
	// 流程定义名称
	private String processDefinitionName;
	// 流程定义Id
	private String processDefinitionId;
	// 流程实例Id
	private String processInstanceId;
	// 审批状态 1新建  2进行中  3 完成
	private Long approvalState;
	// 页面地址
	private String pageUrl;
	// 表单类型，存实体的class名称
	private String formType;
	// 表单类型，存实体的class名称
	private String createUserName;

	private SysRole firstApproval;

	private SysRole secondApproval;

	private SysRole thirdApproval;
	
	//审批结果 1通过  2不通过
	private String state;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "BZ_FORM_ENTITY_ID", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	@Column(name = "TITLE", length = 1000)
	public String getTitle() {
		return title;
	}

	@Column(name = "FORM_NAME", length = 300)
	public String getFormName() {
		return formName;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "SUBMIT_TIME")
	public Date getSubmitTime() {
		return submitTime;
	}

	@Column(name = "PROCESS_DEFINITION_NAME", length = 300)
	public String getProcessDefinitionName() {
		return processDefinitionName;
	}

	@Column(name = "PROCESS_DEFINITION_ID", length = 20)
	public String getProcessDefinitionId() {
		return processDefinitionId;
	}

	@Column(name = "PROCESS_INSTANCE_ID", length = 10)
	public String getProcessInstanceId() {
		return processInstanceId;
	}

	@Column(name = "APPROVAL_STATE", length = 1)
	public Long getApprovalState() {
		return approvalState;
	}

	@Column(name = "PAGE_URL", length = 1000)
	public String getPageUrl() {
		return pageUrl;
	}

	@Column(name = "FORM_TYPE", length = 30)
	public String getFormType() {
		return formType;
	}

	@Column(name = "CREATE_USERNAME", length = 20)
	public String getCreateUserName() {
		return createUserName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

	public void setSubmitTime(Date submitTime) {
		this.submitTime = submitTime;
	}

	public void setProcessDefinitionName(String processDefinitionName) {
		this.processDefinitionName = processDefinitionName;
	}

	public void setProcessDefinitionId(String processDefinitionId) {
		this.processDefinitionId = processDefinitionId;
	}

	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}

	public void setApprovalState(Long approvalState) {
		this.approvalState = approvalState;
	}

	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setFormType(String formType) {
		this.formType = formType;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}


	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FIRST_APPROVAL_ID")
	public SysRole getFirstApproval() {
		return firstApproval;
	}

	public void setFirstApproval(SysRole firstApproval) {
		this.firstApproval = firstApproval;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SECOND_APPROVAL_ID")
	public SysRole getSecondApproval() {
		return secondApproval;
	}

	public void setSecondApproval(SysRole secondApproval) {
		this.secondApproval = secondApproval;
	}
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "THIRD_APPROVAL_ID")
	public SysRole getThirdApproval() {
		return thirdApproval;
	}

	public void setThirdApproval(SysRole thirdApproval) {
		this.thirdApproval = thirdApproval;
	}

	@Column(name = "STATE", length = 10)
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	/************* Transient ***************/
	private String pageUrlAndParams;

	@Transient
	public String getPageUrlAndParams() {
		StringBuffer result = new StringBuffer();
		result.append(pageUrl);
		result.append("?id=").append(id);
		if (StringUtils.isNotEmpty(processInstanceId)) {
			result.append("&processInstanceId=").append(processInstanceId);
		}
		if (approvalState != null && approvalState > 0) {
			result.append("&approvalState=").append(approvalState);
		}
		pageUrlAndParams = result.toString();
		return pageUrlAndParams;
	}

	public void setPageUrlAndParams(String pageUrlAndParams) {
		this.pageUrlAndParams = pageUrlAndParams;
	}

	public String viewPageUrlAndParams;

	@Transient
	public String getViewPageUrlAndParams() {
		StringBuffer result = new StringBuffer();
		result.append(this.getPageUrl()).append("_view.xhtml");
		result.append("?id=").append(id);
		if (StringUtils.isNotEmpty(processInstanceId)) {
			result.append("&processInstanceId=").append(processInstanceId);
		}
		if (approvalState != null && approvalState > 0) {
			result.append("&approvalState=").append(approvalState);
		}
		viewPageUrlAndParams = result.toString();
		return viewPageUrlAndParams;
	}

	public void setViewPageUrlAndParams(String viewPageUrlAndParams) {
		this.viewPageUrlAndParams = viewPageUrlAndParams;
	}

	public String draftPageUrlAndParams;

	@Transient
	public String getDraftPageUrlAndParams() {
		StringBuffer result = new StringBuffer();
		if (this.getApprovalState() == 1) {
			result.append(this.getPageUrl()).append("_edit.xhtml");
		} else {
			result.append(this.getPageUrl()).append("_view.xhtml");
		}

		result.append("?id=").append(id);
		if (StringUtils.isNotEmpty(processInstanceId)) {
			result.append("&processInstanceId=").append(processInstanceId);
		}
		if (approvalState != null && approvalState > 0) {
			result.append("&approvalState=").append(approvalState);
		}
		draftPageUrlAndParams = result.toString();
		return draftPageUrlAndParams;
	}

	public void setDraftPageUrlAndParams(String draftPageUrlAndParams) {
		this.draftPageUrlAndParams = draftPageUrlAndParams;
	}
}
