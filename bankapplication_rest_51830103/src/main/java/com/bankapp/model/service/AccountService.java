package com.bankapp.model.service;

import java.util.List;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.AccountTransaction;

public interface AccountService {
public List<Account> findAll();
public Account findById(Long id);
public void transfer(Long toAccount,Long fromAccount,Double amount,String name);
public void withdraw(Long fromAccount,Double amount,String name);
public void deposit(Long toAccount,Double amount,String name);
public Account createAccount(Account account);
public void deleteAccount(Long accountNumber);
public Account updateAccount(Long accountNumber,Account account);
}
