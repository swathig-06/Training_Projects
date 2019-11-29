package com.customer.model.persistance;

import java.util.List;

public interface CustomerDao {
	public List<Customer> getAllCustomers();
	public Customer getCustById(int custId);
	public Customer addCust(Customer cust);
	public Customer updateCust(Customer cust);
	public Customer removeCust(int custId);
}
