package itaf.framework.domain.platform;

// Generated Sep 2, 2014 4:45:05 PM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;
import itaf.framework.domain.base.OperateEntity;

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
 * 黑名单
 *
 * @author
 *
 * @UpdateDate 2014年9月4日
 */
@Entity
@Table(name = "SYS_BLACKLIST", catalog = "itaf")
public class SysBlacklist extends OperateEntity implements java.io.Serializable {

	private static final long serialVersionUID = -3618199039130694572L;

	private Long id;
	private SysUser sysUser;
	private String status;
	private String logincode;
	private String realnameZh;
	private String realnameEn;
	private String mobile;

	public SysBlacklist() {
	}

	public SysBlacklist(String logincode) {
		this.logincode = logincode;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "SYS_BLACKLIST_ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SYS_USER_ID")
	public SysUser getSysUser() {
		return this.sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	@Column(name = "STATUS", length = 10)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "LOGINCODE", nullable = false, length = 20)
	public String getLogincode() {
		return this.logincode;
	}

	public void setLogincode(String logincode) {
		this.logincode = logincode;
	}

	@Column(name = "REALNAME_ZH", length = 140)
	public String getRealnameZh() {
		return this.realnameZh;
	}

	public void setRealnameZh(String realnameZh) {
		this.realnameZh = realnameZh;
	}

	@Column(name = "REALNAME_EN", length = 140)
	public String getRealnameEn() {
		return this.realnameEn;
	}

	public void setRealnameEn(String realnameEn) {
		this.realnameEn = realnameEn;
	}

	@Column(name = "MOBILE", length = 40)
	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
