package itaf.framework.domain.product;

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
 * 商品评价
 * 
 * @author
 * 
 * @UpdateDate 2014年9月4日
 */
@Entity
@Table(name = "BZ_PRODUCT_RATING", catalog = "itaf")
public class BzProductRating extends OperateEntity implements
		java.io.Serializable {

	private static final long serialVersionUID = 2732811875186541454L;

	private Long id;
	private Long bzProductId;
	private BzProduct bzProduct;
	private Long bzConsumerId;
	private BzConsumer bzConsumer;
	private Long bzOrderId;
	private BzOrder bzOrder;
	private Long rate;
	private String content;

	public BzProductRating() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "BZ_PRODUCT_RATING_ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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
		return bzProduct;
	}

	public void setBzProduct(BzProduct bzProduct) {
		this.bzProduct = bzProduct;
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

	@Column(name = "RATE")
	public Long getRate() {
		return rate;
	}

	public void setRate(Long rate) {
		this.rate = rate;
	}

	@Column(name = "CONTENT", length = 1000)
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
