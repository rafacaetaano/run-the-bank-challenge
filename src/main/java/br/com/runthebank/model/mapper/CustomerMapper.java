package br.com.runthebank.model.mapper;

import org.springframework.stereotype.Component;

import br.com.runthebank.entity.Customer;
import br.com.runthebank.model.dto.CustomerDTO;

@Component
public class CustomerMapper {

	public CustomerDTO fromEntityToDTO(Customer customer) {
		CustomerDTO dto = new CustomerDTO();
		dto.setAddress(customer.getAddress() != null ? customer.getAddress() : "");
		dto.setCustomerType(customer.getUserType() != null ? customer.getUserType() : "");
		dto.setDocument(customer.getDocument() != null ? customer.getDocument() : "");
		dto.setName(customer.getName() != null ? customer.getName() : "");
		dto.setPassword(customer.getPassword() != null ? customer.getPassword() : "");
		return dto;
	}
	
}
