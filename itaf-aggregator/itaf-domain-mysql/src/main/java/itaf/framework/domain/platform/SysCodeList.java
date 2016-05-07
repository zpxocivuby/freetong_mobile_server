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
 * 系统数据字典值列表
 * 
 * @author
 * 
 * @UpdateDate 2014年9月4日
 */
@Entity
@Table(name = "SYS_CODE_LIST", catalog = "itaf")
public class SysCodeList extends OperateEntity implements java.io.Serializable {

	private static final long serialVersionUID = -2547420335497113178L;

	private Long id;
	private Long sysCodeTypeId;
	private SysCodeType sysCodeType;
	private String codeValue;
	private String nameZh;
	private String nameEn;
	private Long sortNo;

	public SysCodeList() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "SYS_CODE_LIST_ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "SYS_CODE_TYPE_ID", nullable = false)
	public Long getSysCodeTypeId() {
		return sysCodeTypeId;
	}

	public void setSysCodeTypeId(Long sysCodeTypeId) {
		this.sysCodeTypeId = sysCodeTypeId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SYS_CODE_TYPE_ID", nullable = false, updatable = false, insertable = false)
	public SysCodeType getSysCodeType() {
		return this.sysCodeType;
	}

	public void setSysCodeType(SysCodeType sysCodeType) {
		this.sysCodeType = sysCodeType;
	}

	@Column(name = "CODE_VALUE", nullable = false)
	public String getCodeValue() {
		return this.codeValue;
	}

	public void setCodeValue(String codeValue) {
		this.codeValue = codeValue;
	}

	@Column(name = "NAME_ZH")
	public String getNameZh() {
		return this.nameZh;
	}

	public void setNameZh(String nameZh) {
		this.nameZh = nameZh;
	}

	@Column(name = "NAME_EN")
	public String getNameEn() {
		return this.nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	@Column(name = "SORT_NO")
	public Long getSortNo() {
		return this.sortNo;
	}

	public void setSortNo(Long sortNo) {
		this.sortNo = sortNo;
	}

}
