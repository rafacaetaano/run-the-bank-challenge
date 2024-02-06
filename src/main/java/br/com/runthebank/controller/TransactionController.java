package br.com.runthebank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.runthebank.model.dto.TransactionDTO;
import br.com.runthebank.model.dto.TransactionRequestDTO;
import br.com.runthebank.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	
	@Autowired
	TransactionService transactionService;
	
	@PatchMapping(value = "/transfer")
	public TransactionDTO transfer(@RequestBody TransactionRequestDTO request) {
		TransactionDTO dto = transactionService.transfer(request);
		return dto;
	}
	
}
