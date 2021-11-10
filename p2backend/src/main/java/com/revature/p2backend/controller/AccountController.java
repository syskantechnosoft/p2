package com.revature.p2backend.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.p2backend.model.Account;
import com.revature.p2backend.service.AccountService;

@RestController
@CrossOrigin(origins = "*")
public class AccountController {
	@Autowired
	AccountService accountService;

	@GetMapping("/accounts")
	public List<Account> findAll() {
		return accountService.findAll();
	}

	@GetMapping("/accountsByType/{accType}")
	public List<Account> findByAccountType(@PathVariable String accType) {
		return accountService.findByAccountType(accType);
	}


	@GetMapping("/accounts/{id}")
	public Account findById(@PathVariable int id) {
		return accountService.findById(id);
	}

	@PostMapping("/accounts")
	public void save(@RequestBody Account account) {
		accountService.save(account);

	}

	@PostMapping("/accounts/bulk")
	public void save(@RequestBody Account[] accounts) {
		for (Account account : accounts) {
			accountService.save(account);
		}
	}

	@PutMapping("/accounts/{id}")
	public void update(@PathVariable int id, @RequestBody Account account) {
		accountService.save(account);

	}

	@DeleteMapping("/accounts/{id}")
	public void delete(@PathVariable int id) {
		accountService.delete(id);

	}
}
