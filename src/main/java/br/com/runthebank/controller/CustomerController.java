package br.com.runthebank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	
	@GetMapping("/show")
	public CustomerDTO show(@RequestParam Long id) {
		CustomerDTO dto = customerService.show(id);
		return dto;
	}
}
