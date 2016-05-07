package itaf.framework.domain.certificate;

// Generated Sep 2, 2014 4:45:05 PM by Hibernate Tools 3.4.0.CR1

import itaf.framework.domain.common.BzAttachment;
import itaf.framework.domain.platform.SysUser;
import itaf.framework.domain.workflow.BzFormEntity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * 
 * 配送服务申请单
 * 
 * @author
 * 
 * @UpdateDate 2014年9月4日
 */
@Entity
@Table(name = "BZ_APPLY_DIST_CERTIFICATE", catalog = "itaf")
@PrimaryKeyJoinColumn(name = "BZ_APPLY_DIST_CERTIFICATE_ID")
public class BzApplyDistCertificate extends BzFormEntity {

	private static final long serialVersionUID = -2702463827279001266L;

	private Long sysUserId;
	private SysUser sysUser;
	private Long bzAttachmentId;
	private BzAttachment bzAttachment;
	private String companyName;
	private String companyAddress;
	private Long serviceType;
	private Long serviceCoverage;
	private Long approvalStatus;
	private Long bzWorkflowId;
	private Set<BzMerchantCertificate> bzMerchantCertificates = new HashSet<BzMerchantCertificate>(
			0);

	public BzApplyDistCertificate() {
	}

	@Column(name = "SYS_USER_ID", nullable = false)
	public Long getSysUserId() {
		return this.sysUserId;
	}

	public void setSysUserId(Long sysUserId) {
		this.sysUserId = sysUserId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SYS_USER_ID", nullable = false, updatable = false, insertable = false)
	public SysUser getSysUser() {
		return this.sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	@Column(name = "BZ_ATTACHMENT_ID", nullable = false)
	public Long getBzAttachmentId() {
		return this.bzAttachmentId;
	}

	public void setBzAttachmentId(Long bzAttachmentId) {
		this.bzAttachmentId = bzAttachmentId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BZ_ATTACHMENT_ID", nullable = false, updatable = false, insertable = false)
	public BzAttachment getBzAttachment() {
		return bzAttachment;
	}

	public void setBzAttachment(BzAttachment bzAttachment) {
		this.bzAttachment = bzAttachment;
	}

	@Column(name = "COMPANY_NAME", length = 200)
	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Column(name = "COMPANY_ADDRESS", length = 1000)
	public String getCompanyAddress() {
		return this.companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	@Column(name = "SERVICE_TYPE")
	public Long getServiceType() {
		return this.serviceType;
	}

	public void setServiceType(Long serviceType) {
		this.serviceType = serviceType;
	}

	@Column(name = "SERVICE_COVERAGE")
	public Long getServiceCoverage() {
		return this.serviceCoverage;
	}

	public void setServiceCoverage(Long serviceCoverage) {
		this.serviceCoverage = serviceCoverage;
	}

	@Column(name = "APPROVAL_STATUS")
	public Long getApprovalStatus() {
		return this.approvalStatus;
	}

	public void setApprovalStatus(Long approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	@Column(name = "BZ_WORKFLOW_ID")
	public Long getBzWorkflowId() {
		return this.bzWorkflowId;
	}

	public void setBzWorkflowId(Long bzWorkflowId) {
		this.bzWorkflowId = bzWorkflowId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bzDistServiceApply")
	public Set<BzMerchantCertificate> getBzMerchantCertificates() {
		return this.bzMerchantCertificates;
	}

	public void setBzMerchantCertificates(
			Set<BzMerchantCertificate> bzMerchantCertificates) {
		this.bzMerchantCertificates = bzMerchantCertificates;
	}

}
