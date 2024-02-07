package br.com.runthebank.dao;

import br.com.runthebank.entity.Account;
import br.com.runthebank.model.dto.AccountDTO;
import br.com.runthebank.model.dto.AccountRequestDTO;

public interface AccountDAO {

	public AccountDTO saveAccount(AccountRequestDTO request);
	
	public Account getAccount(Long id);
	
}
