package itaf.framework.domain.certificate;

// Generated Sep 2, 2014 4:45:05 PM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;
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

/**
 * 
 * 商家认证
 * 
 * @author
 * 
 * @UpdateDate 2014年9月4日
 */
@Entity
@Table(name = "BZ_MERCHANT_CERTIFICATE", catalog = "itaf")
public class BzMerchantCertificate extends OperateEntity implements
		java.io.Serializable {

	private static final long serialVersionUID = -7230036013751397375L;

	private Long id;
	private BzApplyDistCertificate bzDistServiceApply;
	private BzApplySellingCertificate bzSellingServiceApply;
	private SysUser sysUser;
	private Long certificateType;
	private String companyName;
	private String companyAddress;
	private Long serviceType;
	private Long serviceCoverage;

	public BzMerchantCertificate() {
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SYS_USER_ID")
	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "BZ_MERCHANT_CERTIFICATE_ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BZ_APPLY_DIST_CERTIFICATE_ID")
	public BzApplyDistCertificate getBzDistServiceApply() {
		return this.bzDistServiceApply;
	}

	public void setBzDistServiceApply(BzApplyDistCertificate bzDistServiceApply) {
		this.bzDistServiceApply = bzDistServiceApply;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BZ_APPLY_SELLING_CERTIFICATE_ID")
	public BzApplySellingCertificate getBzSellingServiceApply() {
		return this.bzSellingServiceApply;
	}

	public void setBzSellingServiceApply(
			BzApplySellingCertificate bzSellingServiceApply) {
		this.bzSellingServiceApply = bzSellingServiceApply;
	}

	@Column(name = "CERTIFICATE_TYPE")
	public Long getCertificateType() {
		return this.certificateType;
	}

	public void setCertificateType(Long certificateType) {
		this.certificateType = certificateType;
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

}
