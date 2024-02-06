package br.com.runthebank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.runthebank.entity.Account;
import br.com.runthebank.entity.Customer;
import br.com.runthebank.model.dto.AccountDTO;
import br.com.runthebank.model.dto.AccountRequestDTO;
import br.com.runthebank.model.mapper.AccountMapper;
import br.com.runthebank.repository.AccountRepository;
import br.com.runthebank.repository.CustomerRepository;
import br.com.runthebank.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	AccountMapper accountMapper;
	

	@Override
	public AccountDTO insert(AccountRequestDTO request) {
		Account entity = new Account();
		entity.setAgency(request.getAgency());
		entity.setBalance(request.getBalance());
		entity.setStatus(request.isAccountStatus());
		//verifica se existe customer antes de salvar idCustomer
		Customer customer = customerRepository.findById(request.getIdCustomer()).orElse(null);
		entity.setIdCustomer(customer != null ? customer.getId() : null);
		accountRepository.save(entity);
		return accountMapper.fromEntityToDTO(entity, customer);
	}

}
