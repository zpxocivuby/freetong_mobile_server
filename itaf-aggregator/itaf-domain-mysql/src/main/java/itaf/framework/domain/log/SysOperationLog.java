package itaf.framework.domain.log;

// Generated Sep 2, 2014 4:45:05 PM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;
import itaf.framework.domain.base.OperateEntity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * 系统操作日志
 * 
 * @author
 * 
 * @UpdateDate 2014年9月4日
 */
@Entity
@Table(name = "SYS_OPERATION_LOG", catalog = "itaf")
public class SysOperationLog extends OperateEntity implements
		java.io.Serializable {

	private static final long serialVersionUID = -1161714722795700805L;

	private Long id;
	private String username;
	private String resName;
	private Date operationTime;
	private Long isSuccess;
	private Long tmSysErrorCodeId;
	private String errorImpact;

	public SysOperationLog() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "SYS_OPERATION_LOG_ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "USERNAME", length = 20)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "RES_NAME", length = 300)
	public String getResName() {
		return this.resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "OPERATION_TIME", nullable = false, length = 19)
	public Date getOperationTime() {
		return this.operationTime;
	}

	public void setOperationTime(Date operationTime) {
		this.operationTime = operationTime;
	}

	@Column(name = "IS_SUCCESS")
	public Long getIsSuccess() {
		return this.isSuccess;
	}

	public void setIsSuccess(Long isSuccess) {
		this.isSuccess = isSuccess;
	}

	@Column(name = "TM_SYS_ERROR_CODE_ID")
	public Long getTmSysErrorCodeId() {
		return this.tmSysErrorCodeId;
	}

	public void setTmSysErrorCodeId(Long tmSysErrorCodeId) {
		this.tmSysErrorCodeId = tmSysErrorCodeId;
	}

	@Column(name = "ERROR_IMPACT", length = 256)
	public String getErrorImpact() {
		return this.errorImpact;
	}

	public void setErrorImpact(String errorImpact) {
		this.errorImpact = errorImpact;
	}

}
