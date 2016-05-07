package itaf.framework.domain.log;

// Generated Sep 2, 2014 4:45:05 PM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;
import itaf.framework.domain.base.OperateEntity;

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
 * 接口交互日志详细信息表
 * 
 * @author
 * 
 * @UpdateDate 2014年9月4日
 */
@Entity
@Table(name = "SYS_DATA_INTERACT_INFO_LOG", catalog = "itaf")
public class SysDataInteractInfoLog extends OperateEntity implements
		java.io.Serializable {

	private static final long serialVersionUID = 465828890154431504L;

	private Long id;
	private SysDataInteractLog sysDataInteractLog;
	private String interfaceNo;
	private String interfaceName;
	private String interfaceDesc;
	private Date receiveTime;
	private Long resendCount;
	private Date lastResendTime;
	private String resendNo;

	public SysDataInteractInfoLog() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "SYS_DATA_INTERACT_INFO_LOG_ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SYS_DATA_INTERACT_LOG_ID")
	public SysDataInteractLog getSysDataInteractLog() {
		return this.sysDataInteractLog;
	}

	public void setSysDataInteractLog(SysDataInteractLog sysDataInteractLog) {
		this.sysDataInteractLog = sysDataInteractLog;
	}

	@Column(name = "INTERFACE_NO", length = 20)
	public String getInterfaceNo() {
		return this.interfaceNo;
	}

	public void setInterfaceNo(String interfaceNo) {
		this.interfaceNo = interfaceNo;
	}

	@Column(name = "INTERFACE_NAME", length = 50)
	public String getInterfaceName() {
		return this.interfaceName;
	}

	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}

	@Column(name = "INTERFACE_DESC", length = 150)
	public String getInterfaceDesc() {
		return this.interfaceDesc;
	}

	public void setInterfaceDesc(String interfaceDesc) {
		this.interfaceDesc = interfaceDesc;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "RECEIVE_TIME", nullable = false, length = 19)
	public Date getReceiveTime() {
		return this.receiveTime;
	}

	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}

	@Column(name = "RESEND_COUNT")
	public Long getResendCount() {
		return this.resendCount;
	}

	public void setResendCount(Long resendCount) {
		this.resendCount = resendCount;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_RESEND_TIME", nullable = false, length = 19)
	public Date getLastResendTime() {
		return this.lastResendTime;
	}

	public void setLastResendTime(Date lastResendTime) {
		this.lastResendTime = lastResendTime;
	}

	@Column(name = "RESEND_NO", length = 20)
	public String getResendNo() {
		return this.resendNo;
	}

	public void setResendNo(String resendNo) {
		this.resendNo = resendNo;
	}

}
