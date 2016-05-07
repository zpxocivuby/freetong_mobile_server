package itaf.framework.domain.order;

// Generated Sep 2, 2014 4:45:05 PM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;
import itaf.framework.domain.base.OperateEntity;

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
 * 订单支付
 * 
 * @author
 * 
 * @UpdateDate 2014年9月4日
 */
@Entity
@Table(name = "BZ_ORDER_PAYMENT", catalog = "itaf")
public class BzOrderPayment extends OperateEntity implements
		java.io.Serializable {

	private static final long serialVersionUID = 9213898283774454789L;

	private Long id;
	private Long bzPaymentTypeId;
	private BzPaymentType bzPaymentType;
	private BzOrder bzOrder;
	private Long payStatus;
	private BigDecimal payAmount;

	public BzOrderPayment() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "BZ_ORDER_PAYMENT_ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "BZ_PAYMENT_TYPE_ID", nullable = false)
	public Long getBzPaymentTypeId() {
		return bzPaymentTypeId;
	}

	public void setBzPaymentTypeId(Long bzPaymentTypeId) {
		this.bzPaymentTypeId = bzPaymentTypeId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BZ_PAYMENT_TYPE_ID", nullable = false, updatable = false, insertable = false)
	public BzPaymentType getBzPaymentType() {
		return this.bzPaymentType;
	}

	public void setBzPaymentType(BzPaymentType bzPaymentType) {
		this.bzPaymentType = bzPaymentType;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BZ_ORDER_ID")
	public BzOrder getBzOrder() {
		return this.bzOrder;
	}

	public void setBzOrder(BzOrder bzOrder) {
		this.bzOrder = bzOrder;
	}

	@Column(name = "PAY_STATUS")
	public Long getPayStatus() {
		return this.payStatus;
	}

	public void setPayStatus(Long payStatus) {
		this.payStatus = payStatus;
	}

	@Column(name = "PAY_AMOUNT", precision = 12)
	public BigDecimal getPayAmount() {
		return this.payAmount;
	}

	public void setPayAmount(BigDecimal payAmount) {
		this.payAmount = payAmount;
	}

}
