package com.revature.p2backend.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.p2backend.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

	List<Account> findByAccountType(String accountType);
}
