package br.com.runthebank.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.runthebank.dao.AccountDAO;
import br.com.runthebank.entity.Account;
import br.com.runthebank.entity.Customer;
import br.com.runthebank.model.dto.AccountDTO;
import br.com.runthebank.model.dto.AccountRequestDTO;
import br.com.runthebank.model.mapper.AccountMapper;
import br.com.runthebank.repository.AccountRepository;
import br.com.runthebank.repository.CustomerRepository;

@Repository
public class AccountDAOImpl implements AccountDAO{
	
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	AccountMapper accountMapper;
	@Autowired
	CustomerDAOImpl customerDAOImpl;

	@Override
	public AccountDTO saveAccount(AccountRequestDTO request) {
		Account entity = new Account();
		entity.setAgency(request.getAgency());
		entity.setBalance(request.getBalance());
		entity.setStatus(request.isAccountStatus());
		//verifica se existe customer antes de salvar idCustomer
		Customer customer = customerDAOImpl.getCustomerById(request.getIdCustomer());
		entity.setIdCustomer(customer.getId());
		accountRepository.save(entity);
		return accountMapper.fromEntityToDTO(entity, customer);
	}

	@Override
	public Account getAccount(Long id) {
		return accountRepository.findById(id).orElse(null);
	}

}
