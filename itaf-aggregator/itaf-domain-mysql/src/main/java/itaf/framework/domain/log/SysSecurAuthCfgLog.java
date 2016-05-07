package itaf.framework.domain.log;

// Generated Sep 2, 2014 4:45:05 PM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;
import itaf.framework.domain.base.OperateEntity;
import itaf.framework.domain.platform.SysSecurAuthCfg;

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
 * 系统安全验证生效配置日志
 * 
 * @author
 * 
 * @UpdateDate 2014年9月4日
 */
@Entity
@Table(name = "SYS_SECUR_AUTH_CFG_LOG", catalog = "itaf")
public class SysSecurAuthCfgLog extends OperateEntity implements
		java.io.Serializable {

	private static final long serialVersionUID = 4526932848495862036L;

	private Long id;
	private SysSecurAuthCfg sysSecurAuthCfg;
	private String modifyField;
	private String preValue;
	private String aftValue;

	public SysSecurAuthCfgLog() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "SYS_SECUR_AUTH_CFG_LOG_ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SYS_SECUR_AUTH_CFG_ID")
	public SysSecurAuthCfg getSysSecurAuthCfg() {
		return this.sysSecurAuthCfg;
	}

	public void setSysSecurAuthCfg(SysSecurAuthCfg sysSecurAuthCfg) {
		this.sysSecurAuthCfg = sysSecurAuthCfg;
	}

	@Column(name = "MODIFY_FIELD", length = 200)
	public String getModifyField() {
		return this.modifyField;
	}

	public void setModifyField(String modifyField) {
		this.modifyField = modifyField;
	}

	@Column(name = "PRE_VALUE", length = 200)
	public String getPreValue() {
		return this.preValue;
	}

	public void setPreValue(String preValue) {
		this.preValue = preValue;
	}

	@Column(name = "AFT_VALUE", length = 200)
	public String getAftValue() {
		return this.aftValue;
	}

	public void setAftValue(String aftValue) {
		this.aftValue = aftValue;
	}

}
