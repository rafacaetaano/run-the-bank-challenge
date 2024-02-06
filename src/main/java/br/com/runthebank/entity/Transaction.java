package br.com.runthebank.entity;

import java.util.Date;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TRANSACTIONS")
@Setter
@Getter
@NoArgsConstructor
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private Long amount;
	
	@Column
	private Long idPayer;
	
	@Column
	private Long idPayee;
	
	@Column
	private Date transactionDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Long getIdPayer() {
		return idPayer;
	}

	public void setIdPayer(Long idPayer) {
		this.idPayer = idPayer;
	}

	public Long getIdPayee() {
		return idPayee;
	}

	public void setIdPayee(Long idPayee) {
		this.idPayee = idPayee;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	
}