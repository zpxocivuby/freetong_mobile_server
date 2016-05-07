package itaf.framework.domain.platform;

// Generated Sep 2, 2014 4:45:05 PM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;
import itaf.framework.domain.base.OperateEntity;
import itaf.framework.domain.log.SysDataInteractLog;

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
 * 系统接口定义
 * 
 * @author
 * 
 * @UpdateDate 2014年9月4日
 */
@Entity
@Table(name = "SYS_INF_DEFINE", catalog = "itaf")
public class SysInfDefine extends OperateEntity implements java.io.Serializable {

	private static final long serialVersionUID = 8547477210757204463L;

	private Long id;
	private String interfaceName;
	private String interfaceNo;
	private String sender;
	private String receiver;
	private String messageType;
	private String interfaceType;
	private String webserviceUrl;
	private String mqueue;
	private String processClass;
	private Long logEnabled;
	private Long resendEnabled;
	private String beanImplClassName;
	private Set<SysDataInteractLog> sysDataInteractLogs = new HashSet<SysDataInteractLog>(
			0);
	private Set<SysInfParamDefine> sysInfParamDefines = new HashSet<SysInfParamDefine>(
			0);
	private Set<SysInfFieldDefine> sysInfFieldDefines = new HashSet<SysInfFieldDefine>(
			0);

	public SysInfDefine() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "SYS_INF_DEFINE_ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "INTERFACE_NAME", length = 50)
	public String getInterfaceName() {
		return this.interfaceName;
	}

	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}

	@Column(name = "INTERFACE_NO", length = 20)
	public String getInterfaceNo() {
		return this.interfaceNo;
	}

	public void setInterfaceNo(String interfaceNo) {
		this.interfaceNo = interfaceNo;
	}

	@Column(name = "SENDER", length = 50)
	public String getSender() {
		return this.sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	@Column(name = "RECEIVER", length = 50)
	public String getReceiver() {
		return this.receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	@Column(name = "MESSAGE_TYPE", length = 20)
	public String getMessageType() {
		return this.messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	@Column(name = "INTERFACE_TYPE", length = 20)
	public String getInterfaceType() {
		return this.interfaceType;
	}

	public void setInterfaceType(String interfaceType) {
		this.interfaceType = interfaceType;
	}

	@Column(name = "WEBSERVICE_URL", length = 200)
	public String getWebserviceUrl() {
		return this.webserviceUrl;
	}

	public void setWebserviceUrl(String webserviceUrl) {
		this.webserviceUrl = webserviceUrl;
	}

	@Column(name = "MQUEUE", length = 50)
	public String getMqueue() {
		return this.mqueue;
	}

	public void setMqueue(String mqueue) {
		this.mqueue = mqueue;
	}

	@Column(name = "PROCESS_CLASS", length = 50)
	public String getProcessClass() {
		return this.processClass;
	}

	public void setProcessClass(String processClass) {
		this.processClass = processClass;
	}

	@Column(name = "LOG_ENABLED")
	public Long getLogEnabled() {
		return this.logEnabled;
	}

	public void setLogEnabled(Long logEnabled) {
		this.logEnabled = logEnabled;
	}

	@Column(name = "RESEND_ENABLED")
	public Long getResendEnabled() {
		return this.resendEnabled;
	}

	public void setResendEnabled(Long resendEnabled) {
		this.resendEnabled = resendEnabled;
	}

	@Column(name = "BEAN_IMPL_CLASS_NAME", length = 50)
	public String getBeanImplClassName() {
		return this.beanImplClassName;
	}

	public void setBeanImplClassName(String beanImplClassName) {
		this.beanImplClassName = beanImplClassName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sysInfDefine")
	public Set<SysDataInteractLog> getSysDataInteractLogs() {
		return this.sysDataInteractLogs;
	}

	public void setSysDataInteractLogs(
			Set<SysDataInteractLog> sysDataInteractLogs) {
		this.sysDataInteractLogs = sysDataInteractLogs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sysInfDefine")
	public Set<SysInfParamDefine> getSysInfParamDefines() {
		return this.sysInfParamDefines;
	}

	public void setSysInfParamDefines(Set<SysInfParamDefine> sysInfParamDefines) {
		this.sysInfParamDefines = sysInfParamDefines;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sysInfDefine")
	public Set<SysInfFieldDefine> getSysInfFieldDefines() {
		return this.sysInfFieldDefines;
	}

	public void setSysInfFieldDefines(Set<SysInfFieldDefine> sysInfFieldDefines) {
		this.sysInfFieldDefines = sysInfFieldDefines;
	}

}
