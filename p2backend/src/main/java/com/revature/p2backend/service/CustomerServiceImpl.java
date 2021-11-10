package com.revature.p2backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.p2backend.model.Customer;
import com.revature.p2backend.repo.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	@Override
	public Customer findByEmail(String email) {
		return customerRepository.findByEmail(email);
	}
	
	@Override
	public Customer findByName(String name) {
		return customerRepository.findByName(name);
	}

	@Override
	public Customer findByMobile(long mobile) {
		return customerRepository.findByMobile(mobile);
	}

	@Override
	public Customer findById(int id) {
		return customerRepository.findById(id).get();
	}

	@Override
	public void save(Customer customer) {
		customerRepository.save(customer);

	}

	@Override
	public void update(int id, Customer customer) {
		customerRepository.save(customer);

	}

	@Override
	public void delete(int id) {
		customerRepository.deleteById(id);

	}

}
