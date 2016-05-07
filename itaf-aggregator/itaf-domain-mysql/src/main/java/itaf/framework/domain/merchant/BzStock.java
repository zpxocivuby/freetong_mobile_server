package itaf.framework.domain.merchant;

// Generated Sep 2, 2014 4:45:05 PM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;
import itaf.framework.domain.base.OperateEntity;
import itaf.framework.domain.product.BzProduct;

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
 * 库存
 * 
 * @author
 * 
 * @UpdateDate 2014年9月4日
 */
@Entity
@Table(name = "BZ_STOCK", catalog = "itaf")
public class BzStock extends OperateEntity implements java.io.Serializable {

	private static final long serialVersionUID = 3926856351299059223L;

	private Long id;
	private Long bzMerchantId;
	private BzMerchant bzMerchant;
	private Long stockNum;
	private Long stockType;
	private Long deductionNum;
	private Long inTransitNum;

	private BzProduct bzProduct;

	public BzStock() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "BZ_STOCK_ID", unique = true, nullable = false)
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

	@Column(name = "STOCK_NUM")
	public Long getStockNum() {
		return this.stockNum;
	}

	public void setStockNum(Long stockNum) {
		this.stockNum = stockNum;
	}

	@Column(name = "STOCK_TYPE")
	public Long getStockType() {
		return this.stockType;
	}

	public void setStockType(Long stockType) {
		this.stockType = stockType;
	}

	@Column(name = "DEDUCTION_NUM")
	public Long getDeductionNum() {
		return this.deductionNum;
	}

	public void setDeductionNum(Long deductionNum) {
		this.deductionNum = deductionNum;
	}

	@Column(name = "IN_TRANSIT_NUM")
	public Long getInTransitNum() {
		return this.inTransitNum;
	}

	public void setInTransitNum(Long inTransitNum) {
		this.inTransitNum = inTransitNum;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BZ_PRODUCT_ID")
	public BzProduct getBzProduct() {
		return bzProduct;
	}

	public void setBzProduct(BzProduct bzProduct) {
		this.bzProduct = bzProduct;
	}
}
