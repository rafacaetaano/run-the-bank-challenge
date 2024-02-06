package br.com.runthebank.model.mapper;

import java.util.Date;

import org.springframework.stereotype.Component;

import br.com.runthebank.entity.Account;
import br.com.runthebank.model.dto.TransactionDTO;

@Component
public class TransactionMapper {

	public TransactionDTO fromEntityToDTO(Account payer, Account payee, Long amount) {
		TransactionDTO dto = new TransactionDTO();
		dto.setAccountPayer(payer.getId());
		dto.setAccountPayee(payee.getId());
		dto.setAgencyPayee(payee.getAgency());
		dto.setAgencyPayer(payer.getAgency());
		dto.setAmount(amount);
		dto.setTransactionDate(new Date());
		return dto;
	}
	
}
