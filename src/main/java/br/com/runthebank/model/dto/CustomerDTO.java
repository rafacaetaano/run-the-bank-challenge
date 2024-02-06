package br.com.runthebank.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO {

	private String name;
	
	private String address;
	
	private String password;
	
	private String customerType;
	
	private String document;
	
}
