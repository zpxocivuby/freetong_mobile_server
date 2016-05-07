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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

/**
 * 
 * 商家
 * 
 * @author
 * 
 * @UpdateDate 2014年9月4日
 */
@Entity
// @PrimaryKeyJoinColumn(name = "SYS_USER_ID")
@Table(name = "BZ_MERCHANT", catalog = "itaf")
public class BzMerchant extends OperateEntity implements java.io.Serializable {

	private static final long serialVersionUID = 2100587687772336717L;

	private Long id;
	private SysUser sysUser;
	private String companyName;
	private String companyAddress;
	private Long serviceCoverage;
	private String merchantCharacteristics;
	private Long merchantCategory;
	private Long certificateStatus;
	private BzServiceProviderType bzServiceProviderType;
	private BzMerchantRate bzMerchantRate;

	public BzMerchant() {
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

	@Column(name = "MERCHANT_CHARACTERISTICS", length = 1000)
	public String getMerchantCharacteristics() {
		return merchantCharacteristics;
	}

	public void setMerchantCharacteristics(String merchantCharacteristics) {
		this.merchantCharacteristics = merchantCharacteristics;
	}

	@Column(name = "MERCHANT_CATEGORY")
	public Long getMerchantCategory() {
		return merchantCategory;
	}

	public void setMerchantCategory(Long merchantCategory) {
		this.merchantCategory = merchantCategory;
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

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "bzMerchant")
	public BzMerchantRate getBzMerchantRate() {
		return bzMerchantRate;
	}

	public void setBzMerchantRate(BzMerchantRate BzMerchantRate) {
		this.bzMerchantRate = BzMerchantRate;
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
