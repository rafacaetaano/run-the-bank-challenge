package br.com.runthebank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.runthebank.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
