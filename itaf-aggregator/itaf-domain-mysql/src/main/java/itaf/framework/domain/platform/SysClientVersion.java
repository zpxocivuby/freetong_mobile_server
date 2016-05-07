package itaf.framework.domain.platform;

// Generated Sep 2, 2014 4:45:05 PM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;
import itaf.framework.domain.base.AuditEntity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * 手机客户端版本
 * 
 * @author
 * 
 * @UpdateDate 2014年9月4日
 */
@Entity
@Table(name = "SYS_CLIENT_VERSION", catalog = "itaf")
public class SysClientVersion extends AuditEntity implements
		java.io.Serializable {

	private static final long serialVersionUID = 1692024276809108930L;

	public final static String NEW = "new";
	public final static String ON = "on";
	public final static String OFF = "off";

	private Long id;
	private String type;
	private String versionNo;
	private String status;
	private String publishStatus;
	private Date publishTime;
	private Set<SysClientPublish> sysClientPublishs = new HashSet<SysClientPublish>(
			0);

	public SysClientVersion() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "SYS_CLIENT_VERSION_ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "TYPE", length = 10)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "VERSION_NO", nullable = false, length = 50)
	public String getVersionNo() {
		return this.versionNo;
	}

	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	}

	@Column(name = "STATUS", length = 10)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "PUBLISH_STATUS", nullable = false, length = 10)
	public String getPublishStatus() {
		return publishStatus;
	}

	public void setPublishStatus(String publishStatus) {
		this.publishStatus = publishStatus;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "PUBLISH_TIME", nullable = false, length = 19)
	public Date getPublishTime() {
		return this.publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sysClientVersion")
	public Set<SysClientPublish> getSysClientPublishs() {
		return this.sysClientPublishs;
	}

	public void setSysClientPublishs(Set<SysClientPublish> sysClientPublishs) {
		this.sysClientPublishs = sysClientPublishs;
	}

}
