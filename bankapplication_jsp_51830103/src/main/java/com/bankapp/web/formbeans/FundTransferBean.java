package com.bankapp.web.formbeans;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class FundTransferBean {
	@NotNull(message="from account can not be left blank")
	private long fromAccount;
	@NotNull(message="to account not be left blank")
	private long toAccount;
	@NotNull(message="amount can not be lelf blank")
	@Max(message="value should be less then 200000", value=200000)
	@Min(message="value should be more then 500", value=500)
	private Double amount;
	
	
	public long getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(long fromAccount) {
		this.fromAccount = fromAccount;
	}
	public long getToAccount() {
		return toAccount;
	}
	public void setToAccount(long toAccount) {
		this.toAccount = toAccount;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	
}