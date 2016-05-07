package itaf.framework.domain.merchant;

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
import javax.persistence.Table;

/**
 * 
 * 收款单
 * 
 * @author
 * 
 * @UpdateDate 2014年9月4日
 */
@Entity
@Table(name = "BZ_COLLECTION_ORDER", catalog = "itaf")
public class BzCollectionOrder extends OperateEntity implements
		java.io.Serializable {

	private static final long serialVersionUID = 6569122811569883977L;

	private Long id;
	private BzDistOrder bzDistOrder;
	private BigDecimal receivableAmount;
	private BigDecimal receivedAmount;
	private BigDecimal distAmount;

	public BzCollectionOrder() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "BZ_COLLECTION_ORDER_ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BZ_DIST_ORDER_ID")
	public BzDistOrder getBzDistOrder() {
		return this.bzDistOrder;
	}

	public void setBzDistOrder(BzDistOrder bzDistOrder) {
		this.bzDistOrder = bzDistOrder;
	}

	@Column(name = "RECEIVABLE_AMOUNT", precision = 12)
	public BigDecimal getReceivableAmount() {
		return this.receivableAmount;
	}

	public void setReceivableAmount(BigDecimal receivableAmount) {
		this.receivableAmount = receivableAmount;
	}

	@Column(name = "RECEIVED_AMOUNT", precision = 12)
	public BigDecimal getReceivedAmount() {
		return this.receivedAmount;
	}

	public void setReceivedAmount(BigDecimal receivedAmount) {
		this.receivedAmount = receivedAmount;
	}

	@Column(name = "DIST_AMOUNT", precision = 12)
	public BigDecimal getDistAmount() {
		return this.distAmount;
	}

	public void setDistAmount(BigDecimal distAmount) {
		this.distAmount = distAmount;
	}

}
