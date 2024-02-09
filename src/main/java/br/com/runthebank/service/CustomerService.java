package br.com.runthebank.service;

import br.com.runthebank.model.dto.CustomerDTO;

public interface CustomerService {

	CustomerDTO insert(CustomerDTO customer);
	
	CustomerDTO show(Long id);
	
}
