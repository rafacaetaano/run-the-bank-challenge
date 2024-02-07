package br.com.runthebank.dao;

import br.com.runthebank.entity.Customer;
import br.com.runthebank.exception.RunTheBankException;
import br.com.runthebank.model.dto.CustomerDTO;

public interface CustomerDAO {
	
	public void saveCustomer(CustomerDTO entity) throws RunTheBankException;
	
	public Customer getCustomerById(Long id);

}
