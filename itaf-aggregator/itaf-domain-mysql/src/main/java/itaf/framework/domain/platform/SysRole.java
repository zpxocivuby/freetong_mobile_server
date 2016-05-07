package itaf.framework.domain.platform;

// Generated Sep 2, 2014 4:45:05 PM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;
import itaf.framework.domain.base.OperateEntity;

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
import javax.persistence.Table;

/**
 * 
 * 系统角色
 * 
 * @author
 * 
 * @UpdateDate 2014年9月4日
 */
@Entity
@Table(name = "SYS_ROLE", catalog = "itaf")
public class SysRole extends OperateEntity implements java.io.Serializable {

	private static final long serialVersionUID = -7447313250198256442L;

	private Long id;
	private String nameZh;
	private String nameEn;
	private String description;
	private Set<SysResource> sysResources = new HashSet<SysResource>(0);
	private Set<SysUser> sysUsers = new HashSet<SysUser>(0);

	public SysRole() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "SYS_ROLE_ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "NAME_ZH", nullable = false, length = 60)
	public String getNameZh() {
		return this.nameZh;
	}

	public void setNameZh(String nameZh) {
		this.nameZh = nameZh;
	}

	@Column(name = "NAME_EN", nullable = false, length = 20)
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

	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinTable(name = "TR_ROLE_RESOURCE", joinColumns = { @JoinColumn(name = "SYS_ROLE_ID") }, inverseJoinColumns = { @JoinColumn(name = "SYS_RESOURCE_ID") })
	public Set<SysResource> getSysResources() {
		return this.sysResources;
	}

	public void setSysResources(Set<SysResource> sysResources) {
		this.sysResources = sysResources;
	}

	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinTable(name = "TR_USER_ROLE", joinColumns = { @JoinColumn(name = "SYS_ROLE_ID") }, inverseJoinColumns = { @JoinColumn(name = "SYS_USER_ID") })
	public Set<SysUser> getSysUsers() {
		return this.sysUsers;
	}

	public void setSysUsers(Set<SysUser> sysUsers) {
		this.sysUsers = sysUsers;
	}

}
