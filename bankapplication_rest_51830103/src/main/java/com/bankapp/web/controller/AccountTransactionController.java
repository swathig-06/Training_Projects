package com.bankapp.web.controller;

import java.io.PrintWriter;
import java.security.Principal;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.model.service.AccountService;
import com.bankapp.web.controller.beans.TransferRequest;
import com.bankapp.web.controller.beans.WithdrawAndDepositRequest;

@RestController
@RequestMapping(path = "clerk/api")
public class AccountTransactionController {
	@Autowired
	private AccountService accountService;

	@PutMapping("/deposit")
	public String deposit(@RequestBody WithdrawAndDepositRequest req, Principal principal) {
		accountService.deposit(req.getAccountNumber(), req.getAmount(), principal.getName());
		return new String("deposit done for account number:" + req.getAccountNumber() + " and amount:" + req.getAmount()
				+ " is done");

	}

	@PutMapping("/withdraw")
	public String withdraw(@RequestBody WithdrawAndDepositRequest req, Principal principal) {
		accountService.withdraw(req.getAccountNumber(), req.getAmount(), principal.getName());
		return new String("withdraw done for account number:" + req.getAccountNumber() + " and amount:" + req.getAmount()
		+ " is done");

	}
	@PutMapping("/transfer")
	public String transfer(@RequestBody TransferRequest req, Principal principal) {
		accountService.transfer(req.getToaccount(), req.getFromaccount(), req.getAmount(), principal.getName());
		return new String("transfer done form account number:" + req.getFromaccount() + "to "+req.getToaccount()+" and amount:" + req.getAmount()
		+ " is done");

	}
}
