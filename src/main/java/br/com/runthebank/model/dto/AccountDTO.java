package br.com.runthebank.model.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccountDTO {

	private String agency;
	
	private Long balance;
	
	private boolean active;
	
	private String customerName;
	
}
