package br.com.runthebank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.runthebank.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
