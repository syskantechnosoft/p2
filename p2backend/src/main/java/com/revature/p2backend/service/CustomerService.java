package com.revature.p2backend.service;

import java.util.List;

import com.revature.p2backend.model.Customer;

public interface CustomerService {
	public List<Customer> findAll();

	public Customer findByEmail(String email);

	public Customer findByMobile(long mobile);

	public Customer findById(int id);
	
	public Customer findByName(String name); 

	public void save(Customer customer);

	public void update(int id, Customer customer);

	public void delete(int id);

}
