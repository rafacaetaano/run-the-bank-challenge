package br.com.runthebank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.runthebank.dao.impl.AccountDAOImpl;
import br.com.runthebank.model.dto.AccountDTO;
import br.com.runthebank.model.dto.AccountRequestDTO;
import br.com.runthebank.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	AccountDAOImpl accountDAOImpl;
	

	@Override
	public AccountDTO insert(AccountRequestDTO request) {
		return accountDAOImpl.saveAccount(request);
	}

}
