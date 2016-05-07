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
 * 配送单条目
 * 
 * @author
 * 
 * @UpdateDate 2014年9月4日
 */
@Entity
@Table(name = "BZ_DIST_ORDER_ITEM", catalog = "itaf")
public class BzDistOrderItem extends OperateEntity implements
		java.io.Serializable {

	private static final long serialVersionUID = -707149843405866332L;

	private Long id;
	private BzProduct bzProduct;
	private BzDistOrder bzDistOrder;
	private Long itemNum;

	public BzDistOrderItem() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "BZ_DIST_ORDER_ITEM_ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BZ_PRODUCT_ID")
	public BzProduct getBzProduct() {
		return this.bzProduct;
	}

	public void setBzProduct(BzProduct bzProduct) {
		this.bzProduct = bzProduct;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BZ_DIST_ORDER_ID")
	public BzDistOrder getBzDistOrder() {
		return this.bzDistOrder;
	}

	public void setBzDistOrder(BzDistOrder bzDistOrder) {
		this.bzDistOrder = bzDistOrder;
	}

	@Column(name = "ITEM_NUM")
	public Long getItemNum() {
		return this.itemNum;
	}

	public void setItemNum(Long itemNum) {
		this.itemNum = itemNum;
	}

}
