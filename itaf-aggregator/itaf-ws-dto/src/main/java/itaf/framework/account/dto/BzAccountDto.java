package itaf.framework.account.dto;

import itaf.framework.base.dto.BaseDto;

import java.math.BigDecimal;

public class BzAccountDto extends BaseDto {

	private static final long serialVersionUID = 5166348439839157848L;

	private String accountName;
	private BigDecimal accountBalance;

	public BzAccountDto() {
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public BigDecimal getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}

}
