package br.com.runthebank.service;

import br.com.runthebank.model.dto.AccountDTO;
import br.com.runthebank.model.dto.AccountRequestDTO;

public interface AccountService {

	AccountDTO insert(AccountRequestDTO request);
	
}
