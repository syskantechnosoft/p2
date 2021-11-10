package com.revature.p2backend.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.p2backend.model.Account;
import com.revature.p2backend.repo.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	AccountRepository accountRepository;

	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		return  accountRepository.findAll();
	}

	@Override
	public List<Account> findByAccountType(String accountType) {
		// TODO Auto-generated method stub
		return accountRepository.findByAccountType(accountType);
	}

	@Override
	public Account findById(int id) {
		// TODO Auto-generated method stub
		return accountRepository.findById(id).get();
	}

	@Override
	public void save(Account account) {
		// TODO Auto-generated method stub
		accountRepository.save(account);
	}

	@Override
	public void update(int id, Account account) {
		// TODO Auto-generated method stub
		accountRepository.save(account);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		accountRepository.deleteById(id);
	}

}
