package itaf.framework.domain.merchant;

// Generated Sep 2, 2014 4:45:05 PM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;
import itaf.framework.domain.base.OperateEntity;
import itaf.framework.domain.consumer.BzConsumer;
import itaf.framework.domain.order.BzOrder;

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
 * 商家信用评价记录
 * 
 * @author
 * 
 * @UpdateDate 2014年9月4日
 */
@Entity
@Table(name = "BZ_MERCHANT_RATING", catalog = "itaf")
public class BzMerchantRating extends OperateEntity implements
		java.io.Serializable {

	private static final long serialVersionUID = -5925895801025346391L;

	private Long id;
	private Long bzMerchantId;
	private BzMerchant bzMerchant;
	private Long bzConsumerId;
	private BzConsumer bzConsumer;
	private Long bzOrderId;
	private BzOrder bzOrder;
	private Long descriptionScore;
	private Long attitudeScore;
	private Long deliveryScore;
	private Long logisticsScore;

	public BzMerchantRating() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "BZ_MERCHANT_RATING_ID", unique = true, nullable = false)
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
		return bzMerchant;
	}

	public void setBzMerchant(BzMerchant bzMerchant) {
		this.bzMerchant = bzMerchant;
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
		return bzConsumer;
	}

	public void setBzConsumer(BzConsumer bzConsumer) {
		this.bzConsumer = bzConsumer;
	}

	@Column(name = "BZ_ORDER_ID", nullable = false)
	public Long getBzOrderId() {
		return bzOrderId;
	}

	public void setBzOrderId(Long bzOrderId) {
		this.bzOrderId = bzOrderId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BZ_ORDER_ID", nullable = false, updatable = false, insertable = false)
	public BzOrder getBzOrder() {
		return this.bzOrder;
	}

	public void setBzOrder(BzOrder bzOrder) {
		this.bzOrder = bzOrder;
	}

	@Column(name = "DESCRIPTION_SCORE")
	public Long getDescriptionScore() {
		return descriptionScore;
	}

	public void setDescriptionScore(Long descriptionScore) {
		this.descriptionScore = descriptionScore;
	}

	@Column(name = "ATTITUDE_SCORE")
	public Long getAttitudeScore() {
		return attitudeScore;
	}

	public void setAttitudeScore(Long attitudeScore) {
		this.attitudeScore = attitudeScore;
	}

	@Column(name = "DELIVERY_SCORE")
	public Long getDeliveryScore() {
		return deliveryScore;
	}

	public void setDeliveryScore(Long deliveryScore) {
		this.deliveryScore = deliveryScore;
	}

	@Column(name = "LOGISTICS_SCORE")
	public Long getLogisticsScore() {
		return logisticsScore;
	}

	public void setLogisticsScore(Long logisticsScore) {
		this.logisticsScore = logisticsScore;
	}

}
