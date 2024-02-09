package br.com.runthebank.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.runthebank.dao.CustomerDAO;
import br.com.runthebank.entity.Customer;
import br.com.runthebank.exception.RunTheBankException;
import br.com.runthebank.model.dto.CustomerDTO;
import br.com.runthebank.repository.CustomerRepository;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private CustomerRepository customerRepository;
	@Override
	public void saveCustomer(CustomerDTO request) throws RunTheBankException {
		Customer existEntity = customerRepository.findCustomerByDocument(request.getDocument());
		if (existEntity == null) {
			Customer entity = new Customer();
			entity.setName(request.getName());
			entity.setDocument(request.getDocument());
			entity.setAddress(request.getAddress());
			if (request.getPassword() == null || request.getPassword() == "") {
				throw new RunTheBankException("A senha não pode ser vazia");
			}
			entity.setPassword(request.getPassword());
			entity.setUserType(request.getCustomerType());
			customerRepository.save(entity);
		}else {
			throw new RunTheBankException("Este documento já possui cadastro no banco");
		}
	}

	@Override
	public Customer getCustomerById(Long id) {
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new RunTheBankException("Cliente com id " + id + " não existe"));
		return customer;
	}

}
