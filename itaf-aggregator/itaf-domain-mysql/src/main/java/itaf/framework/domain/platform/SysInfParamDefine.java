package itaf.framework.domain.platform;

// Generated Sep 2, 2014 4:45:05 PM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;
import itaf.framework.domain.base.OperateEntity;

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
 * 系统接口参数定义
 * 
 * @author
 * 
 * @UpdateDate 2014年9月4日
 */
@Entity
@Table(name = "SYS_INF_PARAM_DEFINE", catalog = "itaf")
public class SysInfParamDefine extends OperateEntity implements
		java.io.Serializable {

	private static final long serialVersionUID = 5299658372691773613L;

	private Long id;
	private SysInfDefine sysInfDefine;
	private String paramName;
	private String paramValue;
	private String valueType;

	public SysInfParamDefine() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "SYS_INF_PARAM_DEFINE_ID", unique = true, nullable = false)
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

	@Column(name = "PARAM_NAME", length = 50)
	public String getParamName() {
		return this.paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	@Column(name = "PARAM_VALUE", length = 50)
	public String getParamValue() {
		return this.paramValue;
	}

	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}

	@Column(name = "VALUE_TYPE", length = 20)
	public String getValueType() {
		return this.valueType;
	}

	public void setValueType(String valueType) {
		this.valueType = valueType;
	}

}
