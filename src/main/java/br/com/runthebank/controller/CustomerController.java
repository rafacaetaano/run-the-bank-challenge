package br.com.runthebank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.runthebank.entity.Customer;
import br.com.runthebank.model.dto.CustomerDTO;
import br.com.runthebank.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@PostMapping("/insert")
	public CustomerDTO insert(@RequestBody CustomerDTO customer) {
		CustomerDTO dto = customerService.insert(customer);
		return dto;
	}
}
