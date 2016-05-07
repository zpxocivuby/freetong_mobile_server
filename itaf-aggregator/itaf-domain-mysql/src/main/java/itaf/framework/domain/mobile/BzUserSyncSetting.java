package itaf.framework.domain.mobile;

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
 * 同步设置
 *
 * @author
 *
 * @UpdateDate 2014年9月4日
 */
@Entity
@Table(name = "BZ_USER_SYNC_SETTING", catalog = "itaf")
public class BzUserSyncSetting extends OperateEntity implements
		java.io.Serializable {

	private static final long serialVersionUID = -22681038301188670L;

	private Long id;
	private SysUser sysUser;
	private String type;
	private String value;
	private String userCode;

	public BzUserSyncSetting() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "BZ_USER_SYNC_SETTING_ID", unique = true, nullable = false)
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

	@Column(name = "TYPE", length = 100)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "VALUE", length = 100)
	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Column(name = "USER_CODE", length = 20)
	public String getUserCode() {
		return this.userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

}
