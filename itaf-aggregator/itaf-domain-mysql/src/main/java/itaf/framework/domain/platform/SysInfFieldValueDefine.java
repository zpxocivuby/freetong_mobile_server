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
 * 接口字段可选值定义
 * 
 * @author
 * 
 * @UpdateDate 2014年9月4日
 */
@Entity
@Table(name = "SYS_INF_FIELD_VALUE_DEFINE", catalog = "itaf")
public class SysInfFieldValueDefine extends OperateEntity implements
		java.io.Serializable {

	private static final long serialVersionUID = -4292438330921513215L;

	private Long id;
	private SysInfFieldDefine sysInfFieldDefine;
	private String value;
	private String description;

	public SysInfFieldValueDefine() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "SYS_INF_FIELD_VALUE_DEFINE_ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SYS_INF_FIELD_DEFINE_ID")
	public SysInfFieldDefine getSysInfFieldDefine() {
		return this.sysInfFieldDefine;
	}

	public void setSysInfFieldDefine(SysInfFieldDefine sysInfFieldDefine) {
		this.sysInfFieldDefine = sysInfFieldDefine;
	}

	@Column(name = "VALUE", length = 50)
	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Column(name = "DESCRIPTION", length = 200)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
