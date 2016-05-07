package itaf.framework.domain.order;

// Generated Sep 2, 2014 4:45:05 PM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;
import itaf.framework.domain.base.OperateEntity;
import itaf.framework.domain.consumer.BzConsumer;
import itaf.framework.domain.merchant.BzMerchant;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "BZ_ORDER_REFUND", catalog = "itaf")
public class BzOrderRefund extends OperateEntity implements
		java.io.Serializable {

	private static final long serialVersionUID = -7395927182918428255L;

	private Long id;
	private BzOrder bzOrder;
	private Long bzConsumerId;
	private BzConsumer bzConsumer;
	private Long bzMerchantId;
	private BzMerchant bzMerchant;
	private String refundSerialNo;
	private Long refundStatus;
	private BigDecimal refundAmount;
	private String refundDesc;

	public BzOrderRefund() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "BZ_ORDER_REFUND_ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BZ_ORDER_ID")
	public BzOrder getBzOrder() {
		return this.bzOrder;
	}

	public void setBzOrder(BzOrder bzOrder) {
		this.bzOrder = bzOrder;
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

	@Column(name = "REFUND_SERIAL_NO", length = 100)
	public String getRefundSerialNo() {
		return this.refundSerialNo;
	}

	public void setRefundSerialNo(String refundSerialNo) {
		this.refundSerialNo = refundSerialNo;
	}

	@Column(name = "REFUND_STATUS")
	public Long getRefundStatus() {
		return this.refundStatus;
	}

	public void setRefundStatus(Long refundStatus) {
		this.refundStatus = refundStatus;
	}

	@Column(name = "REFUND_AMOUNT", precision = 12)
	public BigDecimal getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(BigDecimal refundAmount) {
		this.refundAmount = refundAmount;
	}

	@Column(name = "REFUND_DESC")
	public String getRefundDesc() {
		return refundDesc;
	}

	public void setRefundDesc(String refundDesc) {
		this.refundDesc = refundDesc;
	}

}
