package itaf.framework.domain.platform;

// Generated Sep 2, 2014 4:45:05 PM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;
import itaf.framework.domain.base.TransientTreeEntity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * 系统资源
 * 
 * @author
 * 
 * @UpdateDate 2014年9月4日
 */
@Entity
@Table(name = "SYS_RESOURCE", catalog = "itaf")
public class SysResource extends TransientTreeEntity<SysResource> implements
		java.io.Serializable {

	private static final long serialVersionUID = 4030828247610658454L;

	private Long id;
	private SysResource parent;
	private String type;
	private String path;
	private String nameZh;
	private String nameEn;
	private String description;
	private Boolean isNav;
	private Set<SysResource> children = new HashSet<SysResource>(0);
	private Set<SysRole> sysRoles = new HashSet<SysRole>(0);

	public SysResource() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "SYS_RESOURCE_ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARENT_ID", updatable = false, insertable = false)
	public SysResource getParent() {
		return this.parent;
	}

	public void setParent(SysResource parent) {
		this.parent = parent;
	}

	@Column(name = "TYPE", nullable = false)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "PATH")
	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Column(name = "NAME_ZH", nullable = false, length = 40)
	public String getNameZh() {
		return this.nameZh;
	}

	public void setNameZh(String nameZh) {
		this.nameZh = nameZh;
	}

	@Column(name = "NAME_EN", nullable = false, length = 40)
	public String getNameEn() {
		return this.nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	@Column(name = "DESCRIPTION", length = 100)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "IS_NAV", length = 1)
	public Boolean getIsNav() {
		return isNav;
	}

	public void setIsNav(Boolean isNav) {
		this.isNav = isNav;
	}

	@OneToMany(cascade = { CascadeType.REMOVE }, mappedBy = "parent")
	public Set<SysResource> getChildren() {
		return this.children;
	}

	public void setChildren(Set<SysResource> children) {
		this.children = children;
	}

	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinTable(name = "TR_ROLE_RESOURCE", joinColumns = { @JoinColumn(name = "SYS_RESOURCE_ID", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "SYS_ROLE_ID", nullable = false, updatable = false) })
	public Set<SysRole> getSysRoles() {
		return this.sysRoles;
	}

	public void setSysRoles(Set<SysRole> sysRoles) {
		this.sysRoles = sysRoles;
	}

}
