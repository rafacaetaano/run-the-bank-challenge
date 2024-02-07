package br.com.runthebank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.runthebank.dao.impl.AccountDAOImpl;
import br.com.runthebank.dao.impl.TransactionDAOImpl;
import br.com.runthebank.entity.Account;
import br.com.runthebank.model.dto.TransactionDTO;
import br.com.runthebank.model.dto.TransactionRequestDTO;
import br.com.runthebank.model.mapper.TransactionMapper;
import br.com.runthebank.repository.AccountRepository;
import br.com.runthebank.repository.TransactionRepository;
import br.com.runthebank.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	TransactionMapper transactionMapper;
	
	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	AccountDAOImpl accountDAOImpl;
	
	@Autowired
	TransactionDAOImpl transactionImpl;

	@Override
	public TransactionDTO transfer(TransactionRequestDTO request) {
		Account accountPayer = accountDAOImpl.getAccount(request.getIdAccountPayer());
		Account accountPayee = accountDAOImpl.getAccount(request.getIdAccountPayee());
		transactionImpl.validateTransaction(request, accountPayer, accountPayee);
		
		return transactionMapper.fromEntityToDTO(accountPayer, accountPayee, request.getAmount());
	} 
	
}
