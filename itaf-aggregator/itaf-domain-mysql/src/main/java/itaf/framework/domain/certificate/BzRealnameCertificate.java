package itaf.framework.domain.certificate;

// Generated Sep 2, 2014 4:45:05 PM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;
import itaf.framework.domain.base.OperateEntity;
import itaf.framework.domain.platform.SysUser;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * 实名认证
 * 
 * @author
 * 
 * @UpdateDate 2014年9月4日
 */
@Entity
@Table(name = "BZ_REALNAME_CERTIFICATE", catalog = "itaf")
public class BzRealnameCertificate extends OperateEntity implements
		java.io.Serializable {

	private static final long serialVersionUID = -845438947804722178L;

	private Long id;
	private BzApplyRealnameCertificate bzRealnameCertificateApply;
	private SysUser sysUser;
	private String name;
	private Long sex;
	private Date birthdate;
	private String mobile;
	private Long idType;
	private String idNo;

	public BzRealnameCertificate() {
	}

	public BzRealnameCertificate(Date birthdate) {
		this.birthdate = birthdate;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "BZ_REALNAME_CERTIFICATE_ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BZ_APPLY_REALNAME_CERTIFICATE_ID")
	public BzApplyRealnameCertificate getBzRealnameCertificateApply() {
		return this.bzRealnameCertificateApply;
	}

	public void setBzRealnameCertificateApply(
			BzApplyRealnameCertificate bzRealnameCertificateApply) {
		this.bzRealnameCertificateApply = bzRealnameCertificateApply;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SYS_USER_ID")
	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
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

}
