package br.com.runthebank.controller;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.runthebank.model.dto.CustomerDTO;
import br.com.runthebank.service.impl.CustomerServiceImpl;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CustomerServiceImpl customerServiceImpl;

	@BeforeEach
	void setup() throws Exception {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testInsert() throws Exception{
		
		ObjectMapper objectMapper = new ObjectMapper();
		String requestJson = objectMapper.writeValueAsString(getCustomerDTO());
		
		when(customerServiceImpl.insert(getCustomerDTO())).thenReturn(getCustomerDTO());
		mockMvc.perform(MockMvcRequestBuilders.post("/customer/insert")
				.content(requestJson)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}

	public CustomerDTO getCustomerDTO() {
		CustomerDTO customer = new CustomerDTO();
		customer.setAddress("a");
		customer.setCustomerType("b");
		customer.setDocument("123");
		customer.setName("name");
		customer.setPassword("password");
		return customer;
	}

}
