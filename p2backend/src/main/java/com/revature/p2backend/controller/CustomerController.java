package com.revature.p2backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.p2backend.model.Customer;
import com.revature.p2backend.service.CustomerService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {
	@Autowired
	CustomerService customerService;

	@GetMapping("/customers")
	public List<Customer> findAll() {
		return customerService.findAll();
	}

	@GetMapping("/customerByEmail/{email}")
	public Customer findByEmail(@PathVariable String email) {
		return customerService.findByEmail(email);
	}

	@GetMapping("/customerByMobile/{mobile}")
	public Customer findByMobile(@PathVariable long mobile) {
		return customerService.findByMobile(mobile);
	}

	@GetMapping("/customers/{id}")
	public Customer findById(@PathVariable int id) {
		return customerService.findById(id);
	}

	@PostMapping("/customers")
	public void save(@RequestBody Customer customer) {
		customerService.save(customer);

	}

	@PostMapping("/customers/bulk")
	public void save(@RequestBody Customer[] customers) {
		for (Customer customer : customers) {
			customerService.save(customer);
		}
	}

	@PutMapping("/customers/{id}")
	public void update(@PathVariable int id, @RequestBody Customer customer) {
		customerService.save(customer);

	}

	@DeleteMapping("/customers/{id}")
	public void delete(@PathVariable int id) {
		customerService.delete(id);

	}
}
