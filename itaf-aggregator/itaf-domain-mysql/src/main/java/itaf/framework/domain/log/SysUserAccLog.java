package itaf.framework.domain.log;

// Generated Sep 2, 2014 4:45:05 PM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;
import itaf.framework.domain.base.AuditEntity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * 用户访问日志
 * 
 * @author
 * 
 * @UpdateDate 2014年9月4日
 */
@Entity
@Table(name = "SYS_USER_ACC_LOG", catalog = "itaf")
public class SysUserAccLog extends AuditEntity implements java.io.Serializable {

	private static final long serialVersionUID = 2652052981501076878L;

	public static final String LOGIN_RESULT_SUCCESS = "success";

	public static final String LOGIN_RESULT_FAILS = "fails";

	private Long id;
	private long sysUserId;
	private String remoteAddr;
	private String fromIp;
	private String sessionId;
	private String username;
	private String loginResult;
	private Long tryCount;
	private Date loginTime;
	private Date logoutTime;

	public SysUserAccLog() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "SYS_USER_ACC_LOG_ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "SYS_USER_ID", nullable = false)
	public long getSysUserId() {
		return this.sysUserId;
	}

	public void setSysUserId(long sysUserId) {
		this.sysUserId = sysUserId;
	}

	@Column(name = "REMOTE_ADDR", nullable = false, length = 100)
	public String getRemoteAddr() {
		return this.remoteAddr;
	}

	public void setRemoteAddr(String remoteAddr) {
		this.remoteAddr = remoteAddr;
	}

	@Column(name = "FROM_IP", length = 30)
	public String getFromIp() {
		return this.fromIp;
	}

	public void setFromIp(String fromIp) {
		this.fromIp = fromIp;
	}

	@Column(name = "SESSION_ID", length = 40)
	public String getSessionId() {
		return this.sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	@Column(name = "USERNAME", length = 20)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "LOGIN_RESULT", length = 300)
	public String getLoginResult() {
		return this.loginResult;
	}

	public void setLoginResult(String loginResult) {
		this.loginResult = loginResult;
	}

	@Column(name = "TRY_COUNT")
	public Long getTryCount() {
		return this.tryCount;
	}

	public void setTryCount(Long tryCount) {
		this.tryCount = tryCount;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LOGIN_TIME", nullable = false, length = 19)
	public Date getLoginTime() {
		return this.loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LOGOUT_TIME", nullable = false, length = 19)
	public Date getLogoutTime() {
		return this.logoutTime;
	}

	public void setLogoutTime(Date logoutTime) {
		this.logoutTime = logoutTime;
	}

}
