package itaf.framework.domain.order;

// Generated Sep 2, 2014 4:45:05 PM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;
import itaf.framework.domain.base.OperateEntity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * 历史订单
 * 
 * @author
 * 
 * @UpdateDate 2014年9月4日
 */
@Entity
@Table(name = "BZ_ORDER_HISTORY", catalog = "itaf")
public class BzOrderHistory extends OperateEntity implements
		java.io.Serializable {

	private static final long serialVersionUID = 1856299134092328851L;

	private Long id;
	private BzOrder bzOrder;
	private Date archiveDate;
	private Long bzConsumerId;
	private Long bzConsumerAddressId;
	private Long bzMerchantId;
	private String orderCode;
	private Long orderStatus;
	private BigDecimal orderDiscount;
	private BigDecimal orderPreferential;
	private BigDecimal orderPrice;

	public BzOrderHistory() {
	}

	public BzOrderHistory(Date archiveDate) {
		this.archiveDate = archiveDate;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "BZ_ORDER_HISTORY_ID", unique = true, nullable = false)
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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ARCHIVE_DATE", nullable = false, length = 19)
	public Date getArchiveDate() {
		return this.archiveDate;
	}

	public void setArchiveDate(Date archiveDate) {
		this.archiveDate = archiveDate;
	}

	@Column(name = "BZ_CONSUMER_ID")
	public Long getBzConsumerId() {
		return this.bzConsumerId;
	}

	public void setBzConsumerId(Long bzConsumerId) {
		this.bzConsumerId = bzConsumerId;
	}

	@Column(name = "BZ_CONSUMER_ADDRESS_ID")
	public Long getBzConsumerAddressId() {
		return this.bzConsumerAddressId;
	}

	public void setBzConsumerAddressId(Long bzConsumerAddressId) {
		this.bzConsumerAddressId = bzConsumerAddressId;
	}

	@Column(name = "BZ_MERCHANT_ID")
	public Long getBzMerchantId() {
		return this.bzMerchantId;
	}

	public void setBzMerchantId(Long bzMerchantId) {
		this.bzMerchantId = bzMerchantId;
	}

	@Column(name = "ORDER_CODE", length = 100)
	public String getOrderCode() {
		return this.orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
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

	@Column(name = "ORDER_PRICE", precision = 12)
	public BigDecimal getOrderPrice() {
		return this.orderPrice;
	}

	public void setOrderPrice(BigDecimal orderPrice) {
		this.orderPrice = orderPrice;
	}

}
