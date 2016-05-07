package itaf.framework.account.dto;

import itaf.framework.base.dto.BaseDto;

import java.math.BigDecimal;

public class BzAccountRechargeDto extends BaseDto {

	private static final long serialVersionUID = -6286660991027343638L;

	private BigDecimal amount;
	private String descript;

	public BzAccountRechargeDto() {
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getAccountBalance() {
		return descript;
	}

	public void setAccountBalance(String descript) {
		this.descript = descript;
	}

}
