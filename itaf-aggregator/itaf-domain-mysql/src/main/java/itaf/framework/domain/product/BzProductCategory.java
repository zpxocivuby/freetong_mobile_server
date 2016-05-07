package itaf.framework.domain.product;

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
 * 商品品类
 * 
 * @author
 * 
 * @UpdateDate 2014年9月4日
 */
@Entity
@Table(name = "BZ_PRODUCT_CATEGORY", catalog = "itaf")
public class BzProductCategory extends TransientTreeEntity<BzProductCategory>
		implements java.io.Serializable {

	private static final long serialVersionUID = -1198449477121541958L;

	private Long id;
	private BzProductCategory bzProductCategory;
	private String categoryName;
	private String categoryCode;
	private Set<BzProduct> bzProducts = new HashSet<BzProduct>(0);
	private Set<BzProductCategory> bzProductCategories = new HashSet<BzProductCategory>(
			0);

	public BzProductCategory() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "BZ_PRODUCT_CATEGORY_ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARENT_ID", updatable = false, insertable = false)
	public BzProductCategory getBzProductCategory() {
		return this.bzProductCategory;
	}

	public void setBzProductCategory(BzProductCategory bzProductCategory) {
		this.bzProductCategory = bzProductCategory;
	}

	@Column(name = "CATEGORY_NAME", length = 100)
	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Column(name = "CATEGORY_CODE", length = 100)
	public String getCategoryCode() {
		return this.categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinTable(name = "TR_PRODUCT_CATEGORY", joinColumns = { @JoinColumn(name = "BZ_PRODUCT_CATEGORY_ID") }, inverseJoinColumns = { @JoinColumn(name = "BZ_PRODUCT_ID") })
	public Set<BzProduct> getBzProducts() {
		return this.bzProducts;
	}

	public void setBzProducts(Set<BzProduct> bzProducts) {
		this.bzProducts = bzProducts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bzProductCategory")
	public Set<BzProductCategory> getBzProductCategories() {
		return this.bzProductCategories;
	}

	public void setBzProductCategories(
			Set<BzProductCategory> bzProductCategories) {
		this.bzProductCategories = bzProductCategories;
	}

}
