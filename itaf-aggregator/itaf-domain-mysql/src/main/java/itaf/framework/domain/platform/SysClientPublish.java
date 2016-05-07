package itaf.framework.domain.platform;

// Generated Sep 2, 2014 4:45:05 PM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;
import itaf.framework.domain.base.AuditEntity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * 
 * 手机客户端发布信息
 * 
 * @author
 * 
 * @UpdateDate 2014年9月4日
 */
@Entity
@Table(name = "SYS_CLIENT_PUBLISH", catalog = "itaf")
public class SysClientPublish extends AuditEntity implements
		java.io.Serializable {

	private static final long serialVersionUID = -6518712377079272005L;

	public final static String CREATED = "created";
	public final static String UPLOADED = "uploaded";
	public final static String PUBLISHED = "published";
	public final static String ABANDONED = "abandoned";

	private Long id;
	private SysClientVersion sysClientVersion;
	private String publishNo;
	private String publishStatus;
	private Long publishUser;
	private Date publishTime;
	private String filePath;
	private String updateMsg;

	private String fileName;
	private String fileId;

	private SysAttachment sysAttachment;

	public SysClientPublish() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "SYS_CLIENT_PUBLISH_ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SYS_CLIENT_VERSION_ID")
	public SysClientVersion getSysClientVersion() {
		return this.sysClientVersion;
	}

	public void setSysClientVersion(SysClientVersion sysClientVersion) {
		this.sysClientVersion = sysClientVersion;
	}

	@Column(name = "PUBLISH_NO", nullable = false, length = 50)
	public String getPublishNo() {
		return publishNo;
	}

	public void setPublishNo(String publishNo) {
		this.publishNo = publishNo;
	}

	@Column(name = "PUBLISH_STATUS", nullable = false, length = 10)
	public String getPublishStatus() {
		return publishStatus;
	}

	public void setPublishStatus(String publishStatus) {
		this.publishStatus = publishStatus;
	}

	@Column(name = "PUBLISH_USER", length = 10)
	public Long getPublishUser() {
		return publishUser;
	}

	public void setPublishUser(Long publishUser) {
		this.publishUser = publishUser;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "PUBLISH_TIME", nullable = false, length = 19)
	public Date getPublishTime() {
		return this.publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	@Column(name = "FILE_PATH", nullable = false, length = 500)
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	@Column(name = "UPDATE_MSG", nullable = false, length = 500)
	public String getUpdateMsg() {
		return updateMsg;
	}

	public void setUpdateMsg(String updateMsg) {
		this.updateMsg = updateMsg;
	}

	@Transient
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Transient
	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SYS_ATTACHMENT_ID")
	public SysAttachment getSysAttachment() {
		return this.sysAttachment;
	}

	public void setSysAttachment(SysAttachment sysAttachment) {
		this.sysAttachment = sysAttachment;
	}

}
