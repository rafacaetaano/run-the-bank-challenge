package br.com.runthebank.model.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccountRequestDTO {
	
	private String agency;
	
	private Long balance;
	
	private boolean accountStatus;
	
	private Long idCustomer;
	
}
