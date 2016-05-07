package itaf.framework.domain.platform;

// Generated Sep 2, 2014 4:45:05 PM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;
import itaf.framework.domain.base.OperateEntity;
import itaf.framework.domain.certificate.BzMerchantCertificate;
import itaf.framework.domain.certificate.BzRealnameCertificate;
import itaf.framework.domain.consumer.BzUserAddress;
import itaf.framework.domain.merchant.BzUserDeliveryAddress;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * 
 * 系统用户
 * 
 * @author
 * 
 * @UpdateDate 2014年9月4日
 */
@Entity
// @Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "SYS_USER", catalog = "itaf", uniqueConstraints = @UniqueConstraint(columnNames = "USERNAME"))
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class SysUser extends OperateEntity implements java.io.Serializable {

	private static final long serialVersionUID = -4923097290515804542L;

	private Long id;
	private String username;
	private String password;
	private Long type;
	private String headIco;
	private String nickname;
	private String email;
	private String mobile;
	private Long realnameCertificateStatus;

	private List<BzUserAddress> bzUserAddress;
	private List<BzUserDeliveryAddress> bzUserDeliveryAddress;

	private BzRealnameCertificate bzRealnameCertificate;
	private BzMerchantCertificate bzMerchantCertificate;

	private Set<SysRole> sysRoles = new HashSet<SysRole>(0);

	private BzRealnameCertificate bzRealnameCertificateTemp;
	private BzMerchantCertificate bzMerchantCertificateTemp;

	public SysUser() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "SYS_USER_ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "USERNAME", length = 200)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "PASSWORD", length = 100)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "TYPE")
	public Long getType() {
		return this.type;
	}

	public void setType(Long type) {
		this.type = type;
	}

	@Column(name = "HEAD_ICO", length = 20)
	public String getHeadIco() {
		return headIco;
	}

	public void setHeadIco(String headIco) {
		this.headIco = headIco;
	}

	@Column(name = "NICKNAME", length = 100)
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Column(name = "EMAIL", length = 50)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "MOBILE", length = 20)
	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "REALNAME_CERTIFICATE_STATUS")
	public Long getRealnameCertificateStatus() {
		return realnameCertificateStatus;
	}

	public void setRealnameCertificateStatus(Long realnameCertificateStatus) {
		this.realnameCertificateStatus = realnameCertificateStatus;
	}

	@OneToMany(mappedBy = "sysUser", fetch = FetchType.LAZY)
	public List<BzUserAddress> getBzUserAddress() {
		return bzUserAddress;
	}

	public void setBzUserAddress(List<BzUserAddress> bzUserAddress) {
		this.bzUserAddress = bzUserAddress;
	}

	@OneToMany(mappedBy = "sysUser", fetch = FetchType.LAZY)
	public List<BzUserDeliveryAddress> getBzUserDeliveryAddress() {
		return bzUserDeliveryAddress;
	}

	public void setBzUserDeliveryAddress(
			List<BzUserDeliveryAddress> bzUserDeliveryAddress) {
		this.bzUserDeliveryAddress = bzUserDeliveryAddress;
	}

	@OneToOne(mappedBy = "sysUser", fetch = FetchType.LAZY)
	public BzMerchantCertificate getBzMerchantCertificate() {
		if (bzMerchantCertificate == null) {
			bzMerchantCertificate = new BzMerchantCertificate();
		}
		return bzMerchantCertificate;
	}

	public void setBzMerchantCertificate(
			BzMerchantCertificate bzMerchantCertificate) {
		this.bzMerchantCertificate = bzMerchantCertificate;
	}

	@OneToOne(mappedBy = "sysUser", fetch = FetchType.LAZY)
	public BzRealnameCertificate getBzRealnameCertificate() {
		if (bzRealnameCertificate == null) {
			bzRealnameCertificate = new BzRealnameCertificate();
		}
		return bzRealnameCertificate;
	}

	public void setBzRealnameCertificate(
			BzRealnameCertificate bzRealnameCertificate) {
		this.bzRealnameCertificate = bzRealnameCertificate;
	}

	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinTable(name = "TR_USER_ROLE", joinColumns = { @JoinColumn(name = "SYS_USER_ID") }, inverseJoinColumns = { @JoinColumn(name = "SYS_ROLE_ID") })
	public Set<SysRole> getSysRoles() {
		return this.sysRoles;
	}

	public void setSysRoles(Set<SysRole> sysRoles) {
		this.sysRoles = sysRoles;
	}

	@Transient
	public BzMerchantCertificate getBzMerchantCertificateTemp() {
		if (bzMerchantCertificate != null) {
			return bzMerchantCertificate;
		} else {
			bzMerchantCertificate = new BzMerchantCertificate();
			return bzMerchantCertificate;
		}
	}

	@Transient
	public BzRealnameCertificate getBzRealnameCertificateTemp() {
		if (bzRealnameCertificate != null) {
			return bzRealnameCertificate;
		} else {
			bzRealnameCertificate = new BzRealnameCertificate();
			return bzRealnameCertificate;
		}
	}

	@Transient
	public void setBzRealnameCertificateTemp(
			BzRealnameCertificate bzRealnameCertificateTemp) {
		setBzRealnameCertificate(bzRealnameCertificateTemp);
	}

	@Transient
	public void setBzMerchantCertificateTemp(
			BzMerchantCertificate bzMerchantCertificateTemp) {
		setBzMerchantCertificate(bzMerchantCertificateTemp);
	}

}
