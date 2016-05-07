package itaf.framework.domain.merchant;

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * 备货单
 * 
 * @author
 * 
 * @UpdateDate 2014年9月4日
 */
@Entity
@Table(name = "BZ_STOCK_ORDER", catalog = "itaf")
public class BzStockOrder extends OperateEntity implements java.io.Serializable {

	private static final long serialVersionUID = -204324176893103203L;

	private Long id;
	private Long bzMerchantId;
	private BzMerchant bzMerchant;
	private String orderSerialNo;
	private Long orderStatus;
	private Date orderEdc;
	private Set<BzStockOrderItem> bzStockOrderItems = new HashSet<BzStockOrderItem>(
			0);

	public BzStockOrder() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "BZ_STOCK_ORDER_ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "BZ_MERCHANT_ID", nullable = false)
	public Long getBzMerchantId() {
		return bzMerchantId;
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

	@Column(name = "ORDER_SERIAL_NO", length = 100)
	public String getOrderSerialNo() {
		return this.orderSerialNo;
	}

	public void setOrderSerialNo(String orderSerialNo) {
		this.orderSerialNo = orderSerialNo;
	}

	@Column(name = "ORDER_STATUS")
	public Long getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(Long orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ORDER_EDC", nullable = false, length = 19)
	public Date getOrderEdc() {
		return this.orderEdc;
	}

	public void setOrderEdc(Date orderEdc) {
		this.orderEdc = orderEdc;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bzStockOrder")
	public Set<BzStockOrderItem> getBzStockOrderItems() {
		return this.bzStockOrderItems;
	}

	public void setBzStockOrderItems(Set<BzStockOrderItem> bzStockOrderItems) {
		this.bzStockOrderItems = bzStockOrderItems;
	}

}
