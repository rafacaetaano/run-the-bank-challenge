package br.com.runthebank.dao;

import br.com.runthebank.entity.Account;
import br.com.runthebank.model.dto.TransactionRequestDTO;

public interface TransactionDAO {

	public void validateTransaction(TransactionRequestDTO request, Account accountPayeer, Account accountpayee);
	
	
}
