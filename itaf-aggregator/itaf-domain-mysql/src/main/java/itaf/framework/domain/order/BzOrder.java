package itaf.framework.domain.order;

// Generated Sep 2, 2014 4:45:05 PM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;
import itaf.framework.domain.base.OperateEntity;
import itaf.framework.domain.consumer.BzConsumer;
import itaf.framework.domain.consumer.BzUserAddress;
import itaf.framework.domain.merchant.BzInvoice;
import itaf.framework.domain.merchant.BzMerchant;

import java.math.BigDecimal;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * 订单
 * 
 * @author
 * 
 * @UpdateDate 2014年9月4日
 */
@Entity
@Table(name = "BZ_ORDER", catalog = "itaf")
public class BzOrder extends OperateEntity implements java.io.Serializable {

	private static final long serialVersionUID = 4095759135293825304L;

	private Long id;
	private Long bzConsumerId;
	private BzConsumer bzConsumer;
	private Long bzMerchantId;
	private BzMerchant bzMerchant;
	private Long bzUserAddressId;
	private BzUserAddress bzUserAddress;
	private String orderSerialNo;
	private Long orderStatus;
	private BigDecimal orderDiscount;
	private BigDecimal orderPreferential;
	private BigDecimal orderAmount;
	private String orderDesc;
	private Set<BzOrderHistory> bzOrderHistories = new HashSet<BzOrderHistory>(
			0);
	private BzOrderPayment bzOrderPayment;
	private BzInvoice bzInvoice;
	private Set<BzOrderItem> bzOrderItems = new HashSet<BzOrderItem>(0);

	public BzOrder() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "BZ_ORDER_ID", unique = true, nullable = false)
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

	@Column(name = "BZ_CONSUMER_ADDRESS_ID", nullable = false)
	public Long getBzUserAddressId() {
		return bzUserAddressId;
	}

	public void setBzUserAddressId(Long bzUserAddressId) {
		this.bzUserAddressId = bzUserAddressId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BZ_CONSUMER_ADDRESS_ID", nullable = false, updatable = false, insertable = false)
	public BzUserAddress getBzUserAddress() {
		return this.bzUserAddress;
	}

	public void setBzUserAddress(BzUserAddress bzUserAddress) {
		this.bzUserAddress = bzUserAddress;
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

	@Column(name = "ORDER_DISCOUNT", precision = 12)
	public BigDecimal getOrderDiscount() {
		return this.orderDiscount;
	}

	public void setOrderDiscount(BigDecimal orderDiscount) {
		this.orderDiscount = orderDiscount;
	}

	@Column(name = "ORDER_PREFERENTIAL", precision = 12)
	public BigDecimal getOrderPreferential() {
		return this.orderPreferential;
	}

	public void setOrderPreferential(BigDecimal orderPreferential) {
		this.orderPreferential = orderPreferential;
	}

	@Column(name = "ORDER_AMOUNT", precision = 12)
	public BigDecimal getOrderAmount() {
		return this.orderAmount;
	}

	public void setOrderAmount(BigDecimal orderAmount) {
		this.orderAmount = orderAmount;
	}

	@Column(name = "ORDER_DESC")
	public String getOrderDesc() {
		return orderDesc;
	}

	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bzOrder")
	public Set<BzOrderHistory> getBzOrderHistories() {
		return this.bzOrderHistories;
	}

	public void setBzOrderHistories(Set<BzOrderHistory> bzOrderHistories) {
		this.bzOrderHistories = bzOrderHistories;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "bzOrder")
	public BzOrderPayment getBzOrderPayment() {
		return this.bzOrderPayment;
	}

	public void setBzOrderPayment(BzOrderPayment bzOrderPayment) {
		this.bzOrderPayment = bzOrderPayment;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "bzOrder")
	public BzInvoice getBzInvoice() {
		return this.bzInvoice;
	}

	public void setBzInvoice(BzInvoice bzInvoice) {
		this.bzInvoice = bzInvoice;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bzOrder")
	public Set<BzOrderItem> getBzOrderItems() {
		return this.bzOrderItems;
	}

	public void setBzOrderItems(Set<BzOrderItem> bzOrderItems) {
		this.bzOrderItems = bzOrderItems;
	}

}
