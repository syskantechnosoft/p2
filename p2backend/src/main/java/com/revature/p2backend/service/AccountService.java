package com.revature.p2backend.service;

import java.util.List;

import com.revature.p2backend.model.Account;

public interface AccountService {
	public List<Account> findAll();

	public List<Account> findByAccountType(String accountType);

	public Account findById(int id);

	public void save(Account account);

	public void update(int id, Account account);

	public void delete(int id);
}
