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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * 系统数据字典类型
 *
 * @author
 *
 * @UpdateDate 2014年9月4日
 */
@Entity
@Table(name = "SYS_CODE_TYPE", catalog = "itaf")
public class SysCodeType extends OperateEntity implements java.io.Serializable {

	private static final long serialVersionUID = 1283422199609423078L;

	private Long id;
	private String codeType;
	private String nameZh;
	private String nameEn;
	private Long codeLenLimit;
	private Set<SysCodeList> sysCodeLists = new HashSet<SysCodeList>(0);

	public SysCodeType() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "SYS_CODE_TYPE_ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "CODE_TYPE", nullable = false, length = 50)
	public String getCodeType() {
		return this.codeType;
	}

	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	@Column(name = "NAME_ZH", length = 128)
	public String getNameZh() {
		return this.nameZh;
	}

	public void setNameZh(String nameZh) {
		this.nameZh = nameZh;
	}

	@Column(name = "NAME_EN", length = 128)
	public String getNameEn() {
		return this.nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	@Column(name = "CODE_LEN_LIMIT")
	public Long getCodeLenLimit() {
		return this.codeLenLimit;
	}

	public void setCodeLenLimit(Long codeLenLimit) {
		this.codeLenLimit = codeLenLimit;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sysCodeType")
	public Set<SysCodeList> getSysCodeLists() {
		return this.sysCodeLists;
	}

	public void setSysCodeLists(Set<SysCodeList> sysCodeLists) {
		this.sysCodeLists = sysCodeLists;
	}

}
