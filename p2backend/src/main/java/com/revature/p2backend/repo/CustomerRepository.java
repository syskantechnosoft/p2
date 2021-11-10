package com.revature.p2backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.p2backend.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	public Customer findByEmail(String email);
	
	public Customer findByName(String name);
	
	public Customer findByMobile(long mobile);
}
