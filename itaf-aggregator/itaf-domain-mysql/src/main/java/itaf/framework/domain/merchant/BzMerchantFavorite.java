package itaf.framework.domain.merchant;

// Generated Sep 2, 2014 4:45:05 PM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;
import itaf.framework.domain.base.OperateEntity;
import itaf.framework.domain.consumer.BzConsumer;

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
 * 商家收藏
 * 
 * @author
 * 
 * @UpdateDate 2014年9月4日
 */
@Entity
@Table(name = "BZ_MERCHANT_FAVORITE", catalog = "itaf")
public class BzMerchantFavorite extends OperateEntity implements
		java.io.Serializable {

	private static final long serialVersionUID = -4787893335922730016L;

	private Long id;
	private Long bzConsumerId;
	private BzConsumer bzConsumer;
	private Long bzMerchantId;
	private BzMerchant bzMerchant;
	private String type;

	public BzMerchantFavorite() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "BZ_MERCHANT_FAVORITE_ID", unique = true, nullable = false)
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
		return bzConsumer;
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
		return bzMerchant;
	}

	public void setBzMerchant(BzMerchant bzMerchant) {
		this.bzMerchant = bzMerchant;
	}

	@Column(name = "TYPE", length = 1000)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
