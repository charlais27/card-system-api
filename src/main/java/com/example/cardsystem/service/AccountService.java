package com.example.cardsystem.service;

import com.example.cardsystem.model.Account;
import com.example.cardsystem.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

	public Optional<Account> getAccountById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Account createAccount(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	public AccountRepository getAccountRepository() {
		return accountRepository;
	}

	public void setAccountRepository(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
}
