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
	
}