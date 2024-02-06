package br.com.runthebank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.runthebank.entity.Customer;
import br.com.runthebank.model.dto.CustomerDTO;
import br.com.runthebank.repository.CustomerRepository;
import br.com.runthebank.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public CustomerDTO insert(CustomerDTO request) {
		Customer entity = new Customer();
		entity.setName(request.getName());
		entity.setDocument(request.getDocument());
		entity.setAddress(request.getAddress());
		entity.setPassword(request.getPassword());
		entity.setUserType(request.getCustomerType());
		customerRepository.save(entity);
		return request;
	}

}
