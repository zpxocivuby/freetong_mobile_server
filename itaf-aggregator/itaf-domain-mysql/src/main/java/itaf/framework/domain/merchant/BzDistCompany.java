package itaf.framework.domain.merchant;

// Generated Sep 2, 2014 4:45:05 PM by Hibernate Tools 3.4.0.CR1

import itaf.framework.domain.base.OperateEntity;
import itaf.framework.domain.platform.SysUser;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

/**
 * 
 * 配送商
 * 
 * @author
 * 
 * @UpdateDate 2014年9月4日
 */
@Entity
// @PrimaryKeyJoinColumn(name = "SYS_USER_ID")
@Table(name = "BZ_DIST_COMPANY", catalog = "itaf")
public class BzDistCompany extends OperateEntity implements
		java.io.Serializable {

	private static final long serialVersionUID = 1204134789270964088L;

	private Long id;
	private SysUser sysUser;
	private String companyName;
	private String companyAddress;
	private Long serviceCoverage;
	private Long certificateStatus;
	private BzServiceProviderType bzServiceProviderType;

	public BzDistCompany() {
	}

	@Id
	@GeneratedValue(generator = "generator")
	@GenericGenerator(name = "generator", strategy = "assigned")
	@Column(name = "SYS_USER_ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SYS_USER_ID", nullable = false, updatable = false, insertable = false)
	public SysUser getSysUser() {
		return this.sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
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

	@Column(name = "SERVICE_COVERAGE")
	public Long getServiceCoverage() {
		return this.serviceCoverage;
	}

	public void setServiceCoverage(Long serviceCoverage) {
		this.serviceCoverage = serviceCoverage;
	}

	@Column(name = "CERTIFICATE_STATUS")
	public Long getCertificateStatus() {
		return certificateStatus;
	}

	public void setCertificateStatus(Long certificateStatus) {
		this.certificateStatus = certificateStatus;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BZ_SERVICE_PROVIDER_TYPE_ID", insertable = false, updatable = false)
	public BzServiceProviderType getBzServiceProviderType() {
		return this.bzServiceProviderType;
	}

	public void setBzServiceProviderType(
			BzServiceProviderType bzServiceProviderType) {
		this.bzServiceProviderType = bzServiceProviderType;
	}

	@Transient
	public String getUsername() {
		return this.getSysUser().getUsername();
	}

	@Transient
	public String getNickname() {
		return this.getSysUser().getNickname();
	}

}
