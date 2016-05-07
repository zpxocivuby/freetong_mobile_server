package itaf.framework.domain.position;

// Generated Sep 2, 2014 4:45:05 PM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;
import itaf.framework.domain.base.OperateEntity;
import itaf.framework.domain.consumer.BzUserAddress;
import itaf.framework.domain.merchant.BzUserDeliveryAddress;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * 位置信息
 * 
 * @author
 * 
 * @UpdateDate 2014年9月4日
 */
@Entity
@Table(name = "BZ_POSITION", catalog = "itaf")
public class BzPosition extends OperateEntity implements java.io.Serializable {

	private static final long serialVersionUID = -3426528190921756193L;

	private Long id;
	private BigDecimal x;
	private BigDecimal y;
	private BigDecimal z;

	private Set<BzUserAddress> bzUserAddresses = new HashSet<BzUserAddress>(0);
	private Set<BzUserDeliveryAddress> bzUserDeliveryAddresses = new HashSet<BzUserDeliveryAddress>(
			0);

	public BzPosition() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "BZ_POSITION_ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "X", precision = 16, scale = 8)
	public BigDecimal getX() {
		return this.x;
	}

	public void setX(BigDecimal x) {
		this.x = x;
	}

	@Column(name = "Y", precision = 16, scale = 8)
	public BigDecimal getY() {
		return this.y;
	}

	public void setY(BigDecimal y) {
		this.y = y;
	}

	@Column(name = "Z", precision = 16, scale = 8)
	public BigDecimal getZ() {
		return this.z;
	}

	public void setZ(BigDecimal z) {
		this.z = z;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bzPosition")
	public Set<BzUserAddress> getBzUserAddresses() {
		return this.bzUserAddresses;
	}

	public void setBzUserAddresses(Set<BzUserAddress> bzUserAddresses) {
		this.bzUserAddresses = bzUserAddresses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bzPosition")
	public Set<BzUserDeliveryAddress> getBzUserDeliveryAddresses() {
		return this.bzUserDeliveryAddresses;
	}

	public void setBzUserDeliveryAddresses(
			Set<BzUserDeliveryAddress> bzUserDeliveryAddresses) {
		this.bzUserDeliveryAddresses = bzUserDeliveryAddresses;
	}

}
