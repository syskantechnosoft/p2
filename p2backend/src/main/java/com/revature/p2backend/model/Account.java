package com.revature.p2backend.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "account")
public class Account implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer accountId;

	@Column(name = "acc_number", unique = true, nullable = false, length = 100)
	private String accountNumber;

	@Column(name = "acc_type", unique = false, nullable = false, length = 100)
	private String accountType;
	@Column(name = "min_balance", unique = false, nullable = true)
	private float minBalance;
	@Column(name = "interest_rate", unique = false, nullable = false)
	private float interestRate;
}
