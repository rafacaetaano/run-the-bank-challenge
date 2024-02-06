package br.com.runthebank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.runthebank.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
