package itaf.framework.domain.account;

import static javax.persistence.GenerationType.IDENTITY;
import itaf.framework.domain.base.OperateEntity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BZ_ACCOUNT", catalog = "itaf")
public class BzAccountRecharge extends OperateEntity implements
		java.io.Serializable {

	private static final long serialVersionUID = -9098587134524174933L;

	private Long id;
	private BigDecimal amount;
	private String descript;

	public BzAccountRecharge() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "BZ_ACCOUNT_RECHARGE_ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "AMOUNT", precision = 12)
	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Column(name = "DESCRIPT")
	public String getAccountBalance() {
		return descript;
	}

	public void setAccountBalance(String descript) {
		this.descript = descript;
	}

}
