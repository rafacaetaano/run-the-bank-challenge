package br.com.runthebank.dao.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.runthebank.dao.TransactionDAO;
import br.com.runthebank.entity.Account;
import br.com.runthebank.entity.Transaction;
import br.com.runthebank.exception.RunTheBankException;
import br.com.runthebank.model.dto.TransactionRequestDTO;
import br.com.runthebank.repository.AccountRepository;
import br.com.runthebank.repository.TransactionRepository;
import br.com.runthebank.service.impl.TransferNotificationServiceImpl;

@Repository
public class TransactionDAOImpl implements TransactionDAO{
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	TransferNotificationServiceImpl transferNotificationServiceImpl;

	@Override
	@Transactional(rollbackFor = RunTheBankException.class)
	public void validateTransaction(TransactionRequestDTO request, Account accountPayer, Account accountPayee) {
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
					try {						
						transferNotificationServiceImpl.sendNotification(request.getAmount(), accountPayer, accountPayee);
					} catch(RunTheBankException exception) {
						throw new RunTheBankException("Ocorreu um erro durante a transferência então ela será anulada");
					}
				}
			}
		}
		
	}

	
	
}
