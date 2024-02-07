package br.com.runthebank.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.runthebank.entity.Account;
import br.com.runthebank.entity.TransferNotification;
import br.com.runthebank.exception.RunTheBankException;
import br.com.runthebank.repository.TransferNotificationRepository;
import br.com.runthebank.service.TransferNotificationService;

@Service
public class TransferNotificationServiceImpl implements TransferNotificationService{
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	TransferNotificationRepository transferNotificationRepository;

	@Override
	public void sendNotification(Long amount, Account payer, Account payee) throws RunTheBankException {
		
		var response = restTemplate.getForEntity("https://run.mocky.io/v3/9769bf3a-b0b6-477a-9ff5-91f63010c9d3", Object.class);
		if(response.getStatusCode() == HttpStatus.OK ) {
			TransferNotification transferNotificationPayer = new TransferNotification();
			TransferNotification transferNotificationPayee = new TransferNotification();
			transferNotificationPayer.setMessage("O valor de R$ " + amount + " foi transferido para a conta " + payee.getAgency() + "/" + payee.getId());
			transferNotificationPayer.setNotificationDate(new Date());
			transferNotificationPayee.setMessage("Você recebeu o valor de R$ " + amount + " da conta" + payer.getAgency() + "/" + payer.getId());
			transferNotificationPayee.setNotificationDate(new Date());
			transferNotificationRepository.save(transferNotificationPayer);
			transferNotificationRepository.save(transferNotificationPayee);
		} else {
			throw new RunTheBankException("Serviço de envio de notificação está fora do ar");
		}
	}
	

}
