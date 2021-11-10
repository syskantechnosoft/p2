package com.revature.p2backend.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Entity
@Table(name = "customer", uniqueConstraints = {
		@UniqueConstraint(columnNames = "id"),
		@UniqueConstraint(columnNames = "email"),
		@UniqueConstraint(columnNames = "mobile")})
@Data
public class Customer implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;	
	private String email;
	private long mobile;
	private String password;
	
	@OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name="employee_account", joinColumns={@JoinColumn(name="emp_id", referencedColumnName="id")}
    , inverseJoinColumns={@JoinColumn(name="account_id", referencedColumnName="id")})
    private Set<Account> accounts;
	
}
