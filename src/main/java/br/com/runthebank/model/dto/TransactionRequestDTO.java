package br.com.runthebank.model.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TransactionRequestDTO {

	private Long amount;
	private Long idAccountPayer;
	private Long idAccountPayee;
	
}
