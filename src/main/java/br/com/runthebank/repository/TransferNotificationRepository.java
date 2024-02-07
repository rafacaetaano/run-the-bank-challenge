package br.com.runthebank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.runthebank.entity.TransferNotification;

public interface TransferNotificationRepository extends JpaRepository<TransferNotification, Long>{

}
