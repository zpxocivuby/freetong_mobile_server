package itaf.framework.domain.consumer;

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
 * 消费者
 * 
 * @author
 * 
 * @UpdateDate 2014年9月4日
 */
@Entity
// @PrimaryKeyJoinColumn(name = "SYS_USER_ID")
@Table(name = "BZ_CONSUMER", catalog = "itaf")
public class BzConsumer extends OperateEntity implements java.io.Serializable {

	private static final long serialVersionUID = -7257346622808035847L;

	private Long id;
	private SysUser sysUser;

	public BzConsumer() {
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

	@Transient
	public String getUsername() {
		if (this.getSysUser() == null) {
			return "";
		}
		return this.getSysUser().getUsername();
	}

	@Transient
	public String getNickname() {
		if (this.getSysUser() == null) {
			return "";
		}
		return this.getSysUser().getNickname();
	}
}
