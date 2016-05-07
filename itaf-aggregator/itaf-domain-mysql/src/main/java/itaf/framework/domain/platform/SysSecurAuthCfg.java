package itaf.framework.domain.platform;

// Generated Sep 2, 2014 4:45:05 PM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;
import itaf.framework.domain.base.OperateEntity;
import itaf.framework.domain.log.SysSecurAuthCfgLog;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * 系统安全验证生效配置
 * 
 * @author
 * 
 * @UpdateDate 2014年9月4日
 */
@Entity
@Table(name = "SYS_SECUR_AUTH_CFG", catalog = "itaf")
public class SysSecurAuthCfg extends OperateEntity implements
		java.io.Serializable {

	private static final long serialVersionUID = -8224060226426643015L;

	private Long id;
	private String authType;
	private Boolean isEnable;
	private Set<SysSecurAuthCfgLog> sysSecurAuthCfgLogs = new HashSet<SysSecurAuthCfgLog>(
			0);

	public SysSecurAuthCfg() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "SYS_SECUR_AUTH_CFG_ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "AUTH_TYPE", length = 10)
	public String getAuthType() {
		return this.authType;
	}

	public void setAuthType(String authType) {
		this.authType = authType;
	}

	@Column(name = "IS_ENABLE", length = 1)
	public Boolean getIsEnable() {
		return this.isEnable;
	}

	public void setIsEnable(Boolean isEnable) {
		this.isEnable = isEnable;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sysSecurAuthCfg")
	public Set<SysSecurAuthCfgLog> getSysSecurAuthCfgLogs() {
		return this.sysSecurAuthCfgLogs;
	}

	public void setSysSecurAuthCfgLogs(
			Set<SysSecurAuthCfgLog> sysSecurAuthCfgLogs) {
		this.sysSecurAuthCfgLogs = sysSecurAuthCfgLogs;
	}

}
