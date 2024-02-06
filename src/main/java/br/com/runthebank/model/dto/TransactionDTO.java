package br.com.runthebank.model.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TransactionDTO {

	private Long amount;
	private String agencyPayer;
	private String agencyPayee;
	private Long accountPayer;
	private Long accountPayee;
	private Date transactionDate;
	
}
