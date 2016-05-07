package itaf.framework.domain.log;

// Generated Sep 2, 2014 4:45:05 PM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;
import itaf.framework.domain.base.OperateEntity;
import itaf.framework.domain.platform.SysInfDefine;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * 接口交互日志
 * 
 * @author
 * 
 * @UpdateDate 2014年9月4日
 */
@Entity
@Table(name = "SYS_DATA_INTERACT_LOG", catalog = "itaf")
public class SysDataInteractLog extends OperateEntity implements
		java.io.Serializable {

	private static final long serialVersionUID = -6802554085387017516L;

	private Long id;
	private SysInfDefine sysInfDefine;
	private String intfaceTranceNo;
	private Date interactTime;
	private Long isSuccess;
	private Long resendCount;
	private String lastRequestNo;
	private Date lastRequestTime;
	private Set<SysDataInteractInfoLog> sysDataInteractInfoLogs = new HashSet<SysDataInteractInfoLog>(
			0);

	public SysDataInteractLog() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "SYS_DATA_INTERACT_LOG_ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SYS_INF_DEFINE_ID")
	public SysInfDefine getSysInfDefine() {
		return this.sysInfDefine;
	}

	public void setSysInfDefine(SysInfDefine sysInfDefine) {
		this.sysInfDefine = sysInfDefine;
	}

	@Column(name = "INTFACE_TRANCE_NO", length = 20)
	public String getIntfaceTranceNo() {
		return this.intfaceTranceNo;
	}

	public void setIntfaceTranceNo(String intfaceTranceNo) {
		this.intfaceTranceNo = intfaceTranceNo;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "INTERACT_TIME", nullable = false, length = 19)
	public Date getInteractTime() {
		return this.interactTime;
	}

	public void setInteractTime(Date interactTime) {
		this.interactTime = interactTime;
	}

	@Column(name = "IS_SUCCESS")
	public Long getIsSuccess() {
		return this.isSuccess;
	}

	public void setIsSuccess(Long isSuccess) {
		this.isSuccess = isSuccess;
	}

	@Column(name = "RESEND_COUNT")
	public Long getResendCount() {
		return this.resendCount;
	}

	public void setResendCount(Long resendCount) {
		this.resendCount = resendCount;
	}

	@Column(name = "LAST_REQUEST_NO", length = 20)
	public String getLastRequestNo() {
		return this.lastRequestNo;
	}

	public void setLastRequestNo(String lastRequestNo) {
		this.lastRequestNo = lastRequestNo;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_REQUEST_TIME", nullable = false, length = 19)
	public Date getLastRequestTime() {
		return this.lastRequestTime;
	}

	public void setLastRequestTime(Date lastRequestTime) {
		this.lastRequestTime = lastRequestTime;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sysDataInteractLog")
	public Set<SysDataInteractInfoLog> getSysDataInteractInfoLogs() {
		return this.sysDataInteractInfoLogs;
	}

	public void setSysDataInteractInfoLogs(
			Set<SysDataInteractInfoLog> sysDataInteractInfoLogs) {
		this.sysDataInteractInfoLogs = sysDataInteractInfoLogs;
	}

}
