package com.bankapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.Customer;
import com.bankapp.model.entities.TransactionLog;
import com.bankapp.model.entities.User;
import com.bankapp.model.repo.AccountRepository;
import com.bankapp.model.repo.CustomerRepository;
import com.bankapp.model.repo.TransactionLogRepository;
import com.bankapp.model.repo.UserRepository;
import com.bankapp.model.service.AccountServiceImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;

@EnableTransactionManagement
@SpringBootApplication
public class BankappV1Application implements CommandLineRunner {

	@Autowired
	private TransactionLogRepository txRepo;

	@Autowired
	private AccountRepository accountRepository;

	// @Autowired
	// private AccountTransactionRepository accountTransactionRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private UserRepository userRepository;

	// @Autowired
	// private TransactionLogRepository transactionLogRepository;

	public static void main(String[] args) {
		SpringApplication.run(BankappV1Application.class, args);

	}

	@Autowired
	private AccountServiceImpl accountService;

	@Override
	public void run(String... args) throws Exception {


		List<TransactionLog> list = txRepo.findByTimeStampBetween(
				LocalDateTime.of(LocalDate.of(2017, Month.JANUARY, 1), LocalTime.now()),
				LocalDateTime.of(LocalDate.of(2019, Month.NOVEMBER, 27), LocalTime.now()));
		for (TransactionLog l : list)
			System.out.println(l);


		Customer customer = new Customer("swathi", "s@gmail.com", "5454545545", "bgl", "Karnataka", "india");
		Customer customer2 = new Customer("arjun", "a@gmail.com", "54598545545", "mdu", "TN", "india");
		Customer customer3 = new Customer("ram", "r@gmail.com", "5974545545", "chennai", "TN", "india");

		Account account = new Account(2000.0, customer, false);
		Account account2 = new Account(1000.0, customer2, false);
		Account account3 = new Account(2500.0, customer3, false);

		customer.setAccount(account);
		customer2.setAccount(account2);
		customer3.setAccount(account3);

		accountRepository.save(account);
		accountRepository.save(account2);
		accountRepository.save(account3);

		User user1 = new User("gopal", "gopal", "g@r.com", "54545455", "mdu",
				new String[] { "ROLE_ADMIN", "ROLE_MGR", "ROLE_CLERK" }, true);

		User user2 = new User("kamala", "kamala", "k@r.com", "54545455", "mdu",
				new String[] { "ROLE_MGR", "ROLE_CLERK" }, true);

		User user3 = new User("partha", "partha", "p@r.com", "54545455", "mdu", new String[] { "ROLE_CLERK" }, true);

		userRepository.save(user1);
		userRepository.save(user2);
		userRepository.save(user3);

	}

}
