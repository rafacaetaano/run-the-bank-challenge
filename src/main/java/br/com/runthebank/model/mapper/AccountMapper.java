package br.com.runthebank.model.mapper;

import org.springframework.stereotype.Component;

import br.com.runthebank.entity.Account;
import br.com.runthebank.entity.Customer;
import br.com.runthebank.model.dto.AccountDTO;

@Component
public class AccountMapper {

	public AccountDTO fromEntityToDTO(Account entity, Customer entityCustomer) {
		AccountDTO dto = new AccountDTO();
		dto.setAccountStatus(entity.isStatus());
		dto.setAgency(entity.getAgency());
		dto.setBalance(entity.getBalance());
		dto.setCustomerName(entityCustomer != null ? entityCustomer.getName() : "");
		return dto;
	}
	
}
