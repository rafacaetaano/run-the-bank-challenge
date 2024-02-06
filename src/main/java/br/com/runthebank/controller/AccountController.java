package br.com.runthebank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.runthebank.model.dto.AccountDTO;
import br.com.runthebank.model.dto.AccountRequestDTO;
import br.com.runthebank.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@PostMapping("/insert")
	public AccountDTO insert(@RequestBody AccountRequestDTO request) {
		AccountDTO dto = accountService.insert(request);
		return dto;
	}
	
}
