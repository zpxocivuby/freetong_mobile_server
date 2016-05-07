package itaf.framework.domain.certificate;

// Generated Sep 2, 2014 4:45:05 PM by Hibernate Tools 3.4.0.CR1

import itaf.framework.domain.common.BzAttachment;
import itaf.framework.domain.platform.SysUser;
import itaf.framework.domain.workflow.BzFormEntity;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * 实名认证申请单
 * 
 * @author
 * 
 * @UpdateDate 2014年9月4日
 */

@Entity
@Table(name = "BZ_APPLY_REALNAME_CERTIFICATE", catalog = "itaf")
@PrimaryKeyJoinColumn(name = "BZ_APPLY_REALNAME_CERTIFICATE_ID")
public class BzApplyRealnameCertificate extends BzFormEntity {

	private static final long serialVersionUID = -4803146158295983436L;

	private Long sysUserId;
	private SysUser sysUser;
	private Long bzAttachmentId;
	private BzAttachment bzAttachment;
	private String name;
	private Long sex;
	private Date birthdate;
	private String mobile;
	private Long idType;
	private String idNo;
	private Set<BzRealnameCertificate> bzRealnameCertificates = new HashSet<BzRealnameCertificate>(
			0);

	public BzApplyRealnameCertificate() {
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

	@Column(name = "NAME", length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "SEX")
	public Long getSex() {
		return this.sex;
	}

	public void setSex(Long sex) {
		this.sex = sex;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "BIRTHDATE", nullable = false, length = 19)
	public Date getBirthdate() {
		return this.birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	@Column(name = "MOBILE", length = 100)
	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "ID_TYPE")
	public Long getIdType() {
		return this.idType;
	}

	public void setIdType(Long idType) {
		this.idType = idType;
	}

	@Column(name = "ID_NO", length = 100)
	public String getIdNo() {
		return this.idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bzRealnameCertificateApply")
	public Set<BzRealnameCertificate> getBzRealnameCertificates() {
		return this.bzRealnameCertificates;
	}

	public void setBzRealnameCertificates(
			Set<BzRealnameCertificate> bzRealnameCertificates) {
		this.bzRealnameCertificates = bzRealnameCertificates;
	}

}
