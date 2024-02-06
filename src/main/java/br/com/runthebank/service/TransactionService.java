package br.com.runthebank.service;

import br.com.runthebank.model.dto.TransactionDTO;
import br.com.runthebank.model.dto.TransactionRequestDTO;

public interface TransactionService {

	public TransactionDTO transfer(TransactionRequestDTO request);
	
}
