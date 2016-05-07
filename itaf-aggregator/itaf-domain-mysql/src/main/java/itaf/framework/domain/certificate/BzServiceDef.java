package itaf.framework.domain.certificate;

// Generated Sep 2, 2014 4:45:05 PM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;
import itaf.framework.domain.base.OperateEntity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * 服务定义
 * 
 * @author
 * 
 * @UpdateDate 2014年9月4日
 */
@Entity
@Table(name = "BZ_SERVICE_DEF", catalog = "itaf")
public class BzServiceDef extends OperateEntity implements java.io.Serializable {

	private static final long serialVersionUID = -1329988541737782357L;

	private Long id;
	private Long type;
	private String name;
	private String description;
	private Date startDate;
	private Date endDate;
	private Date registerDate;
	private String provider;
	private Set<BzServiceParameterDef> bzServiceParameterDefs = new HashSet<BzServiceParameterDef>(
			0);

	public BzServiceDef() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "BZ_SERVICE_DEF_ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "TYPE")
	public Long getType() {
		return this.type;
	}

	public void setType(Long type) {
		this.type = type;
	}

	@Column(name = "NAME", length = 200)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "DESCRIPTION", length = 1000)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "START_DATE", nullable = false, length = 19)
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "END_DATE", nullable = false, length = 19)
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "REGISTER_DATE", nullable = false, length = 19)
	public Date getRegisterDate() {
		return this.registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	@Column(name = "PROVIDER", length = 200)
	public String getProvider() {
		return this.provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bzServiceDef")
	public Set<BzServiceParameterDef> getBzServiceParameterDefs() {
		return this.bzServiceParameterDefs;
	}

	public void setBzServiceParameterDefs(
			Set<BzServiceParameterDef> bzServiceParameterDefs) {
		this.bzServiceParameterDefs = bzServiceParameterDefs;
	}

}
