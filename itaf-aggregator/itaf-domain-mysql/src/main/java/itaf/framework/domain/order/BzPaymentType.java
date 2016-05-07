package itaf.framework.domain.order;

// Generated Sep 2, 2014 4:45:05 PM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;
import itaf.framework.domain.base.OperateEntity;

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
 * 订单支付类型
 * 
 * @author
 * 
 * @UpdateDate 2014年9月4日
 */
@Entity
@Table(name = "BZ_PAYMENT_TYPE", catalog = "itaf")
public class BzPaymentType extends OperateEntity implements
		java.io.Serializable {

	private static final long serialVersionUID = -8545219615176602171L;

	private Long id;
	private String typeName;
	private String typeDescription;
	private Set<BzOrderPayment> bzOrderPayments = new HashSet<BzOrderPayment>(0);

	public BzPaymentType() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "BZ_PAYMENT_TYPE_ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "TYPE_NAME", length = 200)
	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Column(name = "TYPE_DESCRIPTION", length = 200)
	public String getTypeDescription() {
		return this.typeDescription;
	}

	public void setTypeDescription(String typeDescription) {
		this.typeDescription = typeDescription;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bzPaymentType")
	public Set<BzOrderPayment> getBzOrderPayments() {
		return this.bzOrderPayments;
	}

	public void setBzOrderPayments(Set<BzOrderPayment> bzOrderPayments) {
		this.bzOrderPayments = bzOrderPayments;
	}

}
