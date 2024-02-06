package br.com.runthebank.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.runthebank.entity.Account;
import br.com.runthebank.entity.Transaction;
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

	@Override
	public TransactionDTO transfer(TransactionRequestDTO request) {
		Account accountPayer = accountRepository.findById(request.getIdAccountPayer()).orElse(null);
		Account accountPayee = accountRepository.findById(request.getIdAccountPayee()).orElse(null);
		if(accountPayer != null && accountPayee != null) {
			if(accountPayer.isStatus() && accountPayee.isStatus()) {
				if(accountPayer.getBalance() >= request.getAmount()) {
					accountPayer.setBalance(accountPayer.getBalance() - request.getAmount());
					accountPayee.setBalance(accountPayee.getBalance() + request.getAmount());
					accountRepository.save(accountPayer);
					accountRepository.save(accountPayee);
					Transaction transaction = new Transaction();
					transaction.setAmount(request.getAmount());
					transaction.setIdPayee(request.getIdAccountPayee());
					transaction.setIdPayer(request.getIdAccountPayer());
					transaction.setTransactionDate(new Date());
					transactionRepository.save(transaction);
				}
			}
		}
		return transactionMapper.fromEntityToDTO(accountPayer, accountPayee, request.getAmount());
	} 
	
}
