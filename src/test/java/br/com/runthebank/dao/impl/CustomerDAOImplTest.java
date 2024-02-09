package br.com.runthebank.dao.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

import br.com.runthebank.entity.Customer;
import br.com.runthebank.model.dto.CustomerDTO;
import br.com.runthebank.repository.CustomerRepository;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
public class CustomerDAOImplTest {

	@Mock
	private CustomerDAOImpl customerDAOImpl;
	@Mock
	private CustomerRepository customerRepository;
	
	@Autowired
	private MockMvc mockMvc;
	
	@BeforeEach
	void setup() throws Exception {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void saveCustomerTest() {
		CustomerDTO dto = getCustomerDTO();
//		when(customerRepository.findCustomerByDocument(anyString())).thenReturn(getCustomer());
//		when(customerRepository.save(getCustomer())).thenReturn(getCustomer());
		lenient().when(customerRepository.findCustomerByDocument(any())).thenReturn(getCustomer());
		customerDAOImpl.saveCustomer(dto);
	}
	
	public Customer getCustomer() {
		Customer customer = new Customer();
		customer.setAddress("address");
		customer.setDocument("123");
		customer.setName("name");
		customer.setId(1L);
		customer.setPassword("password");
		customer.setUserType("F");
		return customer;
	}
	
	public CustomerDTO getCustomerDTO() {
		CustomerDTO dto = new CustomerDTO();
		dto.setAddress("address");
		dto.setCustomerType("F");
		dto.setDocument("1233");
		dto.setName("name");
		dto.setPassword("abc");
		return dto;
	}
	
}
