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
 * 备货单条目
 * 
 * @author
 * 
 * @UpdateDate 2014年9月4日
 */
@Entity
@Table(name = "BZ_STOCK_ORDER_ITEM", catalog = "itaf")
public class BzStockOrderItem extends OperateEntity implements
		java.io.Serializable {

	private static final long serialVersionUID = 8583843368148094411L;

	private Long id;
	private BzStockOrder bzStockOrder;
	private Long bzProductId;
	private BzProduct bzProduct;
	private Long itemStatus;
	private Long itemNum;

	public BzStockOrderItem() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "BZ_STOCK_ORDER_ITEM_ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BZ_STOCK_ORDER_ID")
	public BzStockOrder getBzStockOrder() {
		return this.bzStockOrder;
	}

	public void setBzStockOrder(BzStockOrder bzStockOrder) {
		this.bzStockOrder = bzStockOrder;
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

	@Column(name = "ITEM_STATUS")
	public Long getItemStatus() {
		return this.itemStatus;
	}

	public void setItemStatus(Long itemStatus) {
		this.itemStatus = itemStatus;
	}

	@Column(name = "ITEM_NUM")
	public Long getItemNum() {
		return this.itemNum;
	}

	public void setItemNum(Long itemNum) {
		this.itemNum = itemNum;
	}

}
