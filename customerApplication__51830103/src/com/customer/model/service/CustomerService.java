package com.customer.model.service;

import java.util.List;

import com.customer.model.persistance.Customer;



public interface CustomerService {
	
	public List<Customer> getAllCustomers();
	public Customer getCustById(int custId);
	public Customer addCust(Customer cust);
	public Customer updateCust(Customer cust);
	public Customer removeCust(int custId);
}
