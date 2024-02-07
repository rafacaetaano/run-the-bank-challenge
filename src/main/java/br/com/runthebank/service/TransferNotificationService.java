package br.com.runthebank.service;

import br.com.runthebank.entity.Account;

public interface TransferNotificationService {

	public void sendNotification(Long amount, Account payer, Account payee);
	
}
