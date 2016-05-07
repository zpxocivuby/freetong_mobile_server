package itaf.framework.domain.merchant;

// Generated Sep 2, 2014 4:45:05 PM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;
import itaf.framework.domain.base.TransientTreeEntity;

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
 * 服务提供商类型
 * 
 * @author
 * 
 * @UpdateDate 2014年9月4日
 */
@Entity
@Table(name = "BZ_SERVICE_PROVIDER_TYPE", catalog = "itaf")
public class BzServiceProviderType extends
		TransientTreeEntity<BzServiceProviderType> implements
		java.io.Serializable {

	private static final long serialVersionUID = -5374818770894896886L;

	private Long id;
	private BzServiceProviderType bzServiceProviderType;
	private String typeName;
	private String typeCode;
	private Set<BzServiceProviderType> bzServiceProviderTypes = new HashSet<BzServiceProviderType>(
			0);
	private Set<BzDistCompany> bzDistCompanies = new HashSet<BzDistCompany>(
			0);
	private Set<BzMerchant> bzMerchants = new HashSet<BzMerchant>(0);

	public BzServiceProviderType() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "BZ_SERVICE_PROVIDER_TYPE_ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARENT_ID", updatable = false, insertable = false)
	public BzServiceProviderType getBzServiceProviderType() {
		return this.bzServiceProviderType;
	}

	public void setBzServiceProviderType(
			BzServiceProviderType bzServiceProviderType) {
		this.bzServiceProviderType = bzServiceProviderType;
	}

	@Column(name = "TYPE_NAME", length = 100)
	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Column(name = "TYPE_CODE", length = 100)
	public String getTypeCode() {
		return this.typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bzServiceProviderType")
	public Set<BzServiceProviderType> getBzServiceProviderTypes() {
		return this.bzServiceProviderTypes;
	}

	public void setBzServiceProviderTypes(
			Set<BzServiceProviderType> bzServiceProviderTypes) {
		this.bzServiceProviderTypes = bzServiceProviderTypes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bzServiceProviderType")
	public Set<BzDistCompany> getBzDistCompanies() {
		return this.bzDistCompanies;
	}

	public void setBzDistCompanies(
			Set<BzDistCompany> bzDistCompanies) {
		this.bzDistCompanies = bzDistCompanies;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bzServiceProviderType")
	public Set<BzMerchant> getBzMerchants() {
		return this.bzMerchants;
	}

	public void setBzMerchants(Set<BzMerchant> bzMerchants) {
		this.bzMerchants = bzMerchants;
	}

}
