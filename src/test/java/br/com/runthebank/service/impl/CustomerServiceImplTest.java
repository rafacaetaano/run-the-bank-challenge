package br.com.runthebank.service.impl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import br.com.runthebank.dao.impl.CustomerDAOImpl;
import br.com.runthebank.entity.Customer;
import br.com.runthebank.model.dto.CustomerDTO;
import br.com.runthebank.repository.CustomerRepository;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
@MockitoSettings(strictness = Strictness.LENIENT)
public class CustomerServiceImplTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	private CustomerDAOImpl customerDAOImpl;
	
	@Mock
	private CustomerRepository customerRepository;
	
	@InjectMocks
	private CustomerServiceImpl customerServiceImpl;
	
	@BeforeEach
	void setup() throws Exception {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void testInsert() {
		
//		when(customerDAOImpl.saveCustomer(getCustomerDTO())).thenReturn(getCustomer());
		when(customerRepository.findCustomerByDocument(any())).thenReturn(null);
		when(customerRepository.save(any())).thenReturn(null);
		
		customerServiceImpl.insert(getCustomerDTO());
	}
	
	
	
	public Customer getCustomer() {
		Customer customer = new Customer();
		customer.setAddress("a");
		customer.setDocument("123");
		customer.setName("name");
		customer.setPassword("password");
		customer.setUserType("F");
		return customer;
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
