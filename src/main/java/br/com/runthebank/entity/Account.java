package br.com.runthebank.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ACCOUNTS")
@Getter
@Setter
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String agency;
	@Column
	private Long balance;
	@Column
	private boolean active;
	@Column
	private Long idCustomer;
	
}