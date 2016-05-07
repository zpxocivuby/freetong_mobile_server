package itaf.framework.domain.product;

// Generated Sep 2, 2014 4:45:05 PM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;
import itaf.framework.domain.base.OperateEntity;
import itaf.framework.domain.cart.BzCartItem;
import itaf.framework.domain.merchant.BzInvoiceItem;
import itaf.framework.domain.merchant.BzMerchant;
import itaf.framework.domain.merchant.BzShelf;
import itaf.framework.domain.merchant.BzStock;
import itaf.framework.domain.merchant.BzStockOrderItem;
import itaf.framework.domain.order.BzOrderItem;

import java.math.BigDecimal;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * 商品
 * 
 * @author
 * 
 * @UpdateDate 2014年9月4日
 */
@Entity
@Table(name = "BZ_PRODUCT", catalog = "itaf")
public class BzProduct extends OperateEntity implements java.io.Serializable {

	private static final long serialVersionUID = 5107587747044422418L;

	private Long id;
	private Long bzMerchantId;
	private BzMerchant bzMerchant;
	private String productName;
	private BigDecimal productPrice;
	private BigDecimal productPurchasePrice;
	private String productColor;
	private String productDescription;
	private Long productOnSale;
	private Long isStockLimitless;
	private Long isShelfLimitless;
	private Long isStockSupport;
	private Long isShelfSupport;

	private BzStock bzStock;
	private BzShelf bzShelf;

	private Set<BzProductBrand> bzProductBrands = new HashSet<BzProductBrand>(0);
	private Set<BzProductCategory> bzProductCategories = new HashSet<BzProductCategory>(
			0);
	private Set<BzProductAttachment> bzProductAttachments = new HashSet<BzProductAttachment>(
			0);
	private Set<BzProductRating> bzProductEvaluations = new HashSet<BzProductRating>(
			0);
	private Set<BzProductFavorite> bzProductFavorites = new HashSet<BzProductFavorite>(
			0);

	private Set<BzCartItem> bzCarts = new HashSet<BzCartItem>(0);
	private Set<BzOrderItem> bzOrderItems = new HashSet<BzOrderItem>(0);
	private Set<BzStockOrderItem> bzStockOrderItems = new HashSet<BzStockOrderItem>(
			0);
	private Set<BzInvoiceItem> bzInvoiceItems = new HashSet<BzInvoiceItem>(0);

	public BzProduct() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "BZ_PRODUCT_ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "BZ_MERCHANT_ID", nullable = false)
	public Long getBzMerchantId() {
		return this.bzMerchantId;
	}

	public void setBzMerchantId(Long bzMerchantId) {
		this.bzMerchantId = bzMerchantId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BZ_MERCHANT_ID", nullable = false, updatable = false, insertable = false)
	public BzMerchant getBzMerchant() {
		return this.bzMerchant;
	}

	public void setBzMerchant(BzMerchant bzMerchant) {
		this.bzMerchant = bzMerchant;
	}

	@Column(name = "PRODUCT_NAME", length = 100)
	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Column(name = "PRODUCT_PRICE", precision = 12)
	public BigDecimal getProductPrice() {
		return this.productPrice;
	}

	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}

	@Column(name = "PRODUCT_PURCHASE_PRICE", precision = 12)
	public BigDecimal getProductPurchasePrice() {
		return this.productPurchasePrice;
	}

	public void setProductPurchasePrice(BigDecimal productPurchasePrice) {
		this.productPurchasePrice = productPurchasePrice;
	}

	@Column(name = "PRODUCT_COLOR", length = 200)
	public String getProductColor() {
		return this.productColor;
	}

	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}

	@Column(name = "PRODUCT_DESCRIPTION", length = 2000)
	public String getProductDescription() {
		return this.productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	@Column(name = "PRODUCT_ON_SALE")
	public Long getProductOnSale() {
		return this.productOnSale;
	}

	public void setProductOnSale(Long productOnSale) {
		this.productOnSale = productOnSale;
	}

	@Column(name = "IS_STOCK_LIMITLESS")
	public Long getIsStockLimitless() {
		return this.isStockLimitless;
	}

	public void setIsStockLimitless(Long isStockLimitless) {
		this.isStockLimitless = isStockLimitless;
	}

	@Column(name = "IS_SHELF_LIMITLESS")
	public Long getIsShelfLimitless() {
		return this.isShelfLimitless;
	}

	public void setIsShelfLimitless(Long isShelfLimitless) {
		this.isShelfLimitless = isShelfLimitless;
	}

	@Column(name = "IS_STOCK_SUPPORT")
	public Long getIsStockSupport() {
		return this.isStockSupport;
	}

	public void setIsStockSupport(Long isStockSupport) {
		this.isStockSupport = isStockSupport;
	}

	@Column(name = "IS_SHELF_SUPPORT")
	public Long getIsShelfSupport() {
		return this.isShelfSupport;
	}

	public void setIsShelfSupport(Long isShelfSupport) {
		this.isShelfSupport = isShelfSupport;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "bzProduct")
	public BzStock getBzStock() {
		return bzStock;
	}

	public void setBzStock(BzStock bzStock) {
		this.bzStock = bzStock;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "bzProduct")
	public BzShelf getBzShelf() {
		return bzShelf;
	}

	public void setBzShelf(BzShelf bzShelf) {
		this.bzShelf = bzShelf;
	}

	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinTable(name = "TR_PRODUCT_BRAND", joinColumns = { @JoinColumn(name = "BZ_PRODUCT_ID") }, inverseJoinColumns = { @JoinColumn(name = "BZ_PRODUCT_BRAND_ID") })
	public Set<BzProductBrand> getBzProductBrands() {
		return this.bzProductBrands;
	}

	public void setBzProductBrands(Set<BzProductBrand> bzProductBrands) {
		this.bzProductBrands = bzProductBrands;
	}

	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinTable(name = "TR_PRODUCT_CATEGORY", joinColumns = { @JoinColumn(name = "BZ_PRODUCT_ID") }, inverseJoinColumns = { @JoinColumn(name = "BZ_PRODUCT_CATEGORY_ID") })
	public Set<BzProductCategory> getBzProductCategories() {
		return this.bzProductCategories;
	}

	public void setBzProductCategories(
			Set<BzProductCategory> bzProductCategories) {
		this.bzProductCategories = bzProductCategories;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bzProduct")
	public Set<BzProductAttachment> getBzProductAttachments() {
		return this.bzProductAttachments;
	}

	public void setBzProductAttachments(
			Set<BzProductAttachment> bzProductAttachments) {
		this.bzProductAttachments = bzProductAttachments;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bzProduct")
	public Set<BzProductRating> getBzProductEvaluations() {
		return this.bzProductEvaluations;
	}

	public void setBzProductEvaluations(
			Set<BzProductRating> bzProductEvaluations) {
		this.bzProductEvaluations = bzProductEvaluations;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bzProduct")
	public Set<BzProductFavorite> getBzProductFavorites() {
		return this.bzProductFavorites;
	}

	public void setBzProductFavorites(Set<BzProductFavorite> bzProductFavorites) {
		this.bzProductFavorites = bzProductFavorites;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bzProduct")
	public Set<BzCartItem> getBzCarts() {
		return this.bzCarts;
	}

	public void setBzCarts(Set<BzCartItem> bzCarts) {
		this.bzCarts = bzCarts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bzProduct")
	public Set<BzOrderItem> getBzOrderItems() {
		return this.bzOrderItems;
	}

	public void setBzOrderItems(Set<BzOrderItem> bzOrderItems) {
		this.bzOrderItems = bzOrderItems;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bzProduct")
	public Set<BzStockOrderItem> getBzStockOrderItems() {
		return this.bzStockOrderItems;
	}

	public void setBzStockOrderItems(Set<BzStockOrderItem> bzStockOrderItems) {
		this.bzStockOrderItems = bzStockOrderItems;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bzProduct")
	public Set<BzInvoiceItem> getBzInvoiceItems() {
		return this.bzInvoiceItems;
	}

	public void setBzInvoiceItems(Set<BzInvoiceItem> bzInvoiceItems) {
		this.bzInvoiceItems = bzInvoiceItems;
	}

}
