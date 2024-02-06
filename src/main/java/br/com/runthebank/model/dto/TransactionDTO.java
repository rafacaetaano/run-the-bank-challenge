package br.com.runthebank.model.dto;

import java.util.Date;

public class TransactionDTO {

	private Long amount;
	private String agencyPayer;
	private String agencyPayee;
	private Long accountPayer;
	private Long accountPayee;
	private Date transactionDate;
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public String getAgencyPayer() {
		return agencyPayer;
	}
	public void setAgencyPayer(String agencyPayer) {
		this.agencyPayer = agencyPayer;
	}
	public String getAgencyPayee() {
		return agencyPayee;
	}
	public void setAgencyPayee(String agencyPayee) {
		this.agencyPayee = agencyPayee;
	}
	public Long getAccountPayer() {
		return accountPayer;
	}
	public void setAccountPayer(Long accountPayer) {
		this.accountPayer = accountPayer;
	}
	public Long getAccountPayee() {
		return accountPayee;
	}
	public void setAccountPayee(Long accountPayee) {
		this.accountPayee = accountPayee;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	
}
