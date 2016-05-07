package itaf.framework.domain.platform;

// Generated Sep 2, 2014 4:45:05 PM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;
import itaf.framework.domain.base.OperateEntity;

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

/**
 * 
 * 接口字段值定义
 * 
 * @author
 * 
 * @UpdateDate 2014年9月4日
 */
@Entity
@Table(name = "SYS_INF_FIELD_DEFINE", catalog = "itaf")
public class SysInfFieldDefine extends OperateEntity implements
		java.io.Serializable {

	private static final long serialVersionUID = -8106296634494590506L;

	private Long id;
	private SysInfDefine sysInfDefine;
	private String filedName;
	private String filedDesc;
	private String filedType;
	private Set<SysInfFieldValueDefine> sysInfFieldValueDefines = new HashSet<SysInfFieldValueDefine>(
			0);

	public SysInfFieldDefine() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "SYS_INF_FIELD_DEFINE_ID", unique = true, nullable = false)
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

	@Column(name = "FILED_NAME", length = 10)
	public String getFiledName() {
		return this.filedName;
	}

	public void setFiledName(String filedName) {
		this.filedName = filedName;
	}

	@Column(name = "FILED_DESC", length = 50)
	public String getFiledDesc() {
		return this.filedDesc;
	}

	public void setFiledDesc(String filedDesc) {
		this.filedDesc = filedDesc;
	}

	@Column(name = "FILED_TYPE", length = 10)
	public String getFiledType() {
		return this.filedType;
	}

	public void setFiledType(String filedType) {
		this.filedType = filedType;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sysInfFieldDefine")
	public Set<SysInfFieldValueDefine> getSysInfFieldValueDefines() {
		return this.sysInfFieldValueDefines;
	}

	public void setSysInfFieldValueDefines(
			Set<SysInfFieldValueDefine> sysInfFieldValueDefines) {
		this.sysInfFieldValueDefines = sysInfFieldValueDefines;
	}

}
