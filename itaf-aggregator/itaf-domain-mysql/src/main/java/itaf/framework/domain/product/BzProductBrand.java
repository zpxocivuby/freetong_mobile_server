package itaf.framework.domain.product;

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
 * 商品品牌
 * 
 * @author
 * 
 * @UpdateDate 2014年9月4日
 */
@Entity
@Table(name = "BZ_PRODUCT_BRAND", catalog = "itaf")
public class BzProductBrand extends OperateEntity implements
		java.io.Serializable {

	private static final long serialVersionUID = -9066468726424404047L;

	private Long id;
	private String brandCode;
	private String brandName;
	private String producer;
	private Set<BzProduct> bzProducts = new HashSet<BzProduct>(0);

	public BzProductBrand() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "BZ_PRODUCT_BRAND_ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "BRAND_CODE", length = 200)
	public String getBrandCode() {
		return this.brandCode;
	}

	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	}

	@Column(name = "BRAND_NAME", length = 200)
	public String getBrandName() {
		return this.brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	@Column(name = "PRODUCER", length = 1000)
	public String getProducer() {
		return this.producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinTable(name = "TR_PRODUCT_BRAND", joinColumns = { @JoinColumn(name = "BZ_PRODUCT_BRAND_ID") }, inverseJoinColumns = { @JoinColumn(name = "BZ_PRODUCT_ID") })
	public Set<BzProduct> getBzProducts() {
		return this.bzProducts;
	}

	public void setBzProducts(Set<BzProduct> bzProducts) {
		this.bzProducts = bzProducts;
	}

}
