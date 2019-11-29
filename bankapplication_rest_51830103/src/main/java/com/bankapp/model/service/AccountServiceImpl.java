package com.bankapp.model.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.AccountTransaction;
import com.bankapp.model.entities.TransactionLog;
import com.bankapp.model.repo.AccountRepository;
import com.bankapp.model.repo.AccountTransactionRepository;
import com.bankapp.model.repo.CustomerRepository;
import com.bankapp.model.repo.TransactionLogRepository;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private AccountTransactionRepository accountTransactionRepository;
	@Autowired
	private TransactionLogRepository transactionLogRepository;

	@Override
	public void transfer(Long toAccount, Long fromAccount, Double amount,String name) {
		Account account = accountRepository.findById(fromAccount).orElseThrow(RuntimeException::new);
		account.setAccountBalance(account.getAccountBalance() - amount);
		AccountTransaction accountTransaction = new AccountTransaction(amount, "withdraw");
		account.addTransaction(accountTransaction);
		accountRepository.save(account);

		Account account1 = accountRepository.findById(toAccount).orElseThrow(RuntimeException::new);
		account1.setAccountBalance(account1.getAccountBalance() + amount);
		AccountTransaction accountTransaction1 = new AccountTransaction(amount, "deposit");
		account1.addTransaction(accountTransaction1);
		accountRepository.save(account1);
		TransactionLog log = new TransactionLog(LocalDateTime.now(), fromAccount, toAccount, "transfer", amount,
				name, "success");
		transactionLogRepository.save(log);

	}

	@Override
	public void withdraw(Long fromAccount, Double amount,String name) {
		Account account = accountRepository.findById(fromAccount).orElseThrow(RuntimeException::new);
		account.setAccountBalance(account.getAccountBalance() - amount);
		AccountTransaction accountTransaction = new AccountTransaction(amount, "withdraw");
		account.addTransaction(accountTransaction);
		accountRepository.save(account);
		TransactionLog log = new TransactionLog(LocalDateTime.now(), fromAccount, null, "withdraw", amount,name,
				"success");
		transactionLogRepository.save(log);

	}

	@Override
	public void deposit(Long toAccount, Double amount,String name) {

		Account account = accountRepository.findById(toAccount).orElseThrow(RuntimeException::new);
		account.setAccountBalance(account.getAccountBalance() + amount);

		AccountTransaction accountTransaction = new AccountTransaction(amount, "deposit");
		account.addTransaction(accountTransaction);
		accountRepository.save(account);
		TransactionLog log = new TransactionLog(LocalDateTime.now(), null, toAccount, "deposit", amount, name,
				"success");
		transactionLogRepository.save(log);
	}

	@Override
	public Account createAccount(Account account) {
		accountRepository.save(account);
		return account ;
	}

	@Override
	public List<Account> findAll() {

		return accountRepository.findAll();
	}

	@Override
	public Account findById(Long id) {
		return accountRepository.findById(id).orElseThrow(RuntimeException::new);
	}

	@Override
	public void deleteAccount(Long accountNumber) {
		accountRepository.deleteById(accountNumber);
		
	}

	@Override
	public Account updateAccount(Long accountNumber, Account account) {
		Account account2=accountRepository.findById(accountNumber).orElseThrow(RuntimeException::new);
		account2.setBlocked(account.getBlocked());
		accountRepository.save(account2);
		return account2;
	}

}
