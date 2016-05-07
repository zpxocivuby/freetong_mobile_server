package itaf.framework.domain.cart;

// Generated Sep 2, 2014 4:45:05 PM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;
import itaf.framework.domain.base.OperateEntity;
import itaf.framework.domain.consumer.BzConsumer;
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
 * 购物车条目
 * 
 * @author
 * 
 * @UpdateDate 2014年9月4日
 */
@Entity
@Table(name = "BZ_CART_ITEM", catalog = "itaf")
public class BzCartItem extends OperateEntity implements java.io.Serializable {

	private static final long serialVersionUID = 7695357276168631136L;

	private Long id;
	private Long bzConsumerId;
	private BzConsumer bzConsumer;
	private Long bzProductId;
	private BzProduct bzProduct;
	private Long itemNum;
	private BigDecimal itemUnitPrice;
	private BigDecimal itemDiscount;
	private BigDecimal itemPreferential;
	private BigDecimal itemPrice;
	private Long itemStatus;

	public BzCartItem() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "BZ_CART_ITEM_ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "BZ_CONSUMER_ID", nullable = false)
	public Long getBzConsumerId() {
		return bzConsumerId;
	}

	public void setBzConsumerId(Long bzConsumerId) {
		this.bzConsumerId = bzConsumerId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BZ_CONSUMER_ID", nullable = false, updatable = false, insertable = false)
	public BzConsumer getBzConsumer() {
		return this.bzConsumer;
	}

	public void setBzConsumer(BzConsumer bzConsumer) {
		this.bzConsumer = bzConsumer;
	}

	@Column(name = "BZ_PRODUCT_ID", nullable = false)
	public Long getBzProductId() {
		return bzProductId;
	}

	public void setBzProductId(Long bzProductId) {
		this.bzProductId = bzProductId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BZ_PRODUCT_ID", nullable = false, updatable = false, insertable = false)
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

	@Column(name = "ITEM_PRICE", precision = 12)
	public BigDecimal getItemPrice() {
		return this.itemPrice;
	}

	public void setItemPrice(BigDecimal itemPrice) {
		this.itemPrice = itemPrice;
	}

	@Column(name = "ITEM_STATUS")
	public Long getItemStatus() {
		return itemStatus;
	}

	public void setItemStatus(Long itemStatus) {
		this.itemStatus = itemStatus;
	}

}
