package br.com.runthebank.model.dto;

public class TransactionRequestDTO {

	private Long amount;
	private Long idAccountPayer;
	private Long idAccountPayee;
	public Long getAmount() {
		return amount;
	}
	public Long getIdAccountPayer() {
		return idAccountPayer;
	}
	public void setIdAccountPayer(Long idAccountPayer) {
		this.idAccountPayer = idAccountPayer;
	}
	public Long getIdAccountPayee() {
		return idAccountPayee;
	}
	public void setIdAccountPayee(Long idAccountPayee) {
		this.idAccountPayee = idAccountPayee;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	
	
	
	
}
