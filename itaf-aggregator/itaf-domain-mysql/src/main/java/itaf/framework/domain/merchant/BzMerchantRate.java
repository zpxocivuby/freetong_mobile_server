package itaf.framework.domain.merchant;

// Generated Sep 2, 2014 4:45:05 PM by Hibernate Tools 3.4.0.CR1

import itaf.framework.domain.base.OperateEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 
 * 商家信用
 * 
 * @author
 * 
 * @UpdateDate 2014年9月4日
 */
@Entity
@Table(name = "BZ_MERCHANT_RATE", catalog = "itaf")
public class BzMerchantRate extends OperateEntity implements
		java.io.Serializable {

	private static final long serialVersionUID = -4206614437772113121L;

	private Long id;
	private BzMerchant bzMerchant;
	private Long descriptionScore;
	private Long attitudeScore;
	private Long deliveryScore;
	private Long logisticsScore;
	private Long ratingNumber;

	public BzMerchantRate() {
	}

	@Id
	@GeneratedValue(generator = "generator")
	@GenericGenerator(name = "generator", strategy = "assigned")
	@Column(name = "BZ_MERCHANT_ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BZ_MERCHANT_ID")
	public BzMerchant getBzMerchant() {
		return this.bzMerchant;
	}

	public void setBzMerchant(BzMerchant bzMerchant) {
		this.bzMerchant = bzMerchant;
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

	@Column(name = "RATING_NUMBER")
	public Long getRatingNumber() {
		return ratingNumber;
	}

	public void setRatingNumber(Long ratingNumber) {
		this.ratingNumber = ratingNumber;
	}

}
