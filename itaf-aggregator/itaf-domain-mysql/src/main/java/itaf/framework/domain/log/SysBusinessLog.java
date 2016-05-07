package itaf.framework.domain.log;

// Generated Sep 2, 2014 4:45:05 PM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;
import itaf.framework.domain.base.OperateEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * 系统业务日志
 * 
 * @author
 * 
 * @UpdateDate 2014年9月4日
 */
@Entity
@Table(name = "SYS_BUSINESS_LOG", catalog = "itaf")
public class SysBusinessLog extends OperateEntity implements
		java.io.Serializable {

	private static final long serialVersionUID = -1354549697749381087L;

	private Long id;
	private String appName;
	private String logInfo;
	private String moduleName;
	private String shortMessage;
	private String objectClassName;
	private Long operatorId;
	private Long recId;
	private Long subRecId;
	private Long tcRecTypeId;
	private Long tcSubRecTypeId;

	public SysBusinessLog() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "SYS_BUSINESS_LOG_ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "APP_NAME", length = 100)
	public String getAppName() {
		return this.appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	@Column(name = "LOG_INFO")
	public String getLogInfo() {
		return this.logInfo;
	}

	public void setLogInfo(String logInfo) {
		this.logInfo = logInfo;
	}

	@Column(name = "MODULE_NAME", length = 100)
	public String getModuleName() {
		return this.moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	@Column(name = "SHORT_MESSAGE", length = 300)
	public String getShortMessage() {
		return this.shortMessage;
	}

	public void setShortMessage(String shortMessage) {
		this.shortMessage = shortMessage;
	}

	@Column(name = "OBJECT_CLASS_NAME", length = 300)
	public String getObjectClassName() {
		return this.objectClassName;
	}

	public void setObjectClassName(String objectClassName) {
		this.objectClassName = objectClassName;
	}

	@Column(name = "OPERATOR_ID")
	public Long getOperatorId() {
		return this.operatorId;
	}

	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}

	@Column(name = "REC_ID")
	public Long getRecId() {
		return this.recId;
	}

	public void setRecId(Long recId) {
		this.recId = recId;
	}

	@Column(name = "SUB_REC_ID")
	public Long getSubRecId() {
		return this.subRecId;
	}

	public void setSubRecId(Long subRecId) {
		this.subRecId = subRecId;
	}

	@Column(name = "TC_REC_TYPE_ID")
	public Long getTcRecTypeId() {
		return this.tcRecTypeId;
	}

	public void setTcRecTypeId(Long tcRecTypeId) {
		this.tcRecTypeId = tcRecTypeId;
	}

	@Column(name = "TC_SUB_REC_TYPE_ID")
	public Long getTcSubRecTypeId() {
		return this.tcSubRecTypeId;
	}

	public void setTcSubRecTypeId(Long tcSubRecTypeId) {
		this.tcSubRecTypeId = tcSubRecTypeId;
	}

}
