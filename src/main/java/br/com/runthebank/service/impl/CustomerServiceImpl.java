package br.com.runthebank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.runthebank.dao.impl.CustomerDAOImpl;
import br.com.runthebank.entity.Customer;
import br.com.runthebank.model.dto.CustomerDTO;
import br.com.runthebank.model.mapper.CustomerMapper;
import br.com.runthebank.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDAOImpl customerDAOImpl;
	@Autowired
	private CustomerMapper customerMapper;

	@Override
	public CustomerDTO insert(CustomerDTO request) {
		customerDAOImpl.saveCustomer(request);
		return request;
	}

	@Override
	public CustomerDTO show(Long id) {
		Customer entity = customerDAOImpl.getCustomerById(id);
		return customerMapper.fromEntityToDTO(entity);
	}

}
