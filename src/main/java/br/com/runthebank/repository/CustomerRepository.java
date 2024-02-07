package br.com.runthebank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.runthebank.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	@Query(value = "select c from Customer c where c.document = ?1")
	public Customer findCustomerByDocument(String document);
	
}
