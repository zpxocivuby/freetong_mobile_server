package itaf.framework.domain.order;

// Generated Sep 2, 2014 4:45:05 PM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;
import itaf.framework.domain.base.OperateEntity;
import itaf.framework.domain.product.BzProduct;

import java.math.BigDecimal;

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
 * 订单条目
 * 
 * @author
 * 
 * @UpdateDate 2014年9月4日
 */
@Entity
@Table(name = "BZ_ORDER_ITEM", catalog = "itaf")
public class BzOrderItem extends OperateEntity implements java.io.Serializable {

	private static final long serialVersionUID = -7082425699189401786L;

	private Long id;
	private BzOrder bzOrder;
	private BzProduct bzProduct;
	private Long itemNum;
	private BigDecimal itemUnitPrice;
	private BigDecimal itemDiscount;
	private BigDecimal itemPreferential;
	private BigDecimal itemAmount;
	private Long itemStockStatus;

	public BzOrderItem() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "BZ_ORDER_ITEM_ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BZ_ORDER_ID")
	public BzOrder getBzOrder() {
		return this.bzOrder;
	}

	public void setBzOrder(BzOrder bzOrder) {
		this.bzOrder = bzOrder;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BZ_PRODUCT_ID")
	public BzProduct getBzProduct() {
		return this.bzProduct;
	}

	public void setBzProduct(BzProduct bzProduct) {
		this.bzProduct = bzProduct;
	}

	@Column(name = "ITEM_NUM")
	public Long getItemNum() {
		return this.itemNum;
	}

	public void setItemNum(Long itemNum) {
		this.itemNum = itemNum;
	}

	@Column(name = "ITEM_UNIT_PRICE", precision = 12)
	public BigDecimal getItemUnitPrice() {
		return this.itemUnitPrice;
	}

	public void setItemUnitPrice(BigDecimal itemUnitPrice) {
		this.itemUnitPrice = itemUnitPrice;
	}

	@Column(name = "ITEM_DISCOUNT", precision = 12)
	public BigDecimal getItemDiscount() {
		return this.itemDiscount;
	}

	public void setItemDiscount(BigDecimal itemDiscount) {
		this.itemDiscount = itemDiscount;
	}

	@Column(name = "ITEM_PREFERENTIAL", precision = 12)
	public BigDecimal getItemPreferential() {
		return this.itemPreferential;
	}

	public void setItemPreferential(BigDecimal itemPreferential) {
		this.itemPreferential = itemPreferential;
	}

	@Column(name = "ITEM_AMOUNT", precision = 12)
	public BigDecimal getItemAmount() {
		return this.itemAmount;
	}

	public void setItemAmount(BigDecimal itemAmount) {
		this.itemAmount = itemAmount;
	}

	@Column(name = "ITEM_STOCK_STATUS")
	public Long getItemStockStatus() {
		return this.itemStockStatus;
	}

	public void setItemStockStatus(Long itemStockStatus) {
		this.itemStockStatus = itemStockStatus;
	}

}
