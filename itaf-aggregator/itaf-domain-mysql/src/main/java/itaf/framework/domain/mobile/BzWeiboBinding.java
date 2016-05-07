package itaf.framework.domain.mobile;

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
 * 微博绑定信息
 * 
 * @author
 * 
 * @UpdateDate 2014年9月4日
 */
@Entity
@Table(name = "BZ_WEIBO_BINDING", catalog = "itaf")
public class BzWeiboBinding extends OperateEntity implements
		java.io.Serializable {

	private static final long serialVersionUID = 6475585225069537818L;

	private Long id;
	private SysUser sysUser;
	private Long type;
	private String account;
	private String password;
	private String token;
	private Date accessToken;
	private Long forceLogin;

	public BzWeiboBinding() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "BZ_WEIBO_BINDING_ID", unique = true, nullable = false)
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

	@Column(name = "TYPE")
	public Long getType() {
		return this.type;
	}

	public void setType(Long type) {
		this.type = type;
	}

	@Column(name = "ACCOUNT", length = 100)
	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	@Column(name = "PASSWORD", length = 100)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "TOKEN", length = 100)
	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ACCESS_TOKEN", nullable = false, length = 19)
	public Date getAccessToken() {
		return this.accessToken;
	}

	public void setAccessToken(Date accessToken) {
		this.accessToken = accessToken;
	}

	@Column(name = "FORCE_LOGIN")
	public Long getForceLogin() {
		return this.forceLogin;
	}

	public void setForceLogin(Long forceLogin) {
		this.forceLogin = forceLogin;
	}

}
