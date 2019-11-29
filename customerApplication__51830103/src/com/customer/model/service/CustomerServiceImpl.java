package com.customer.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.customer.model.persistance.Customer;
import com.customer.model.persistance.CustomerDao;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao dao;

	@Override
	public List<Customer> getAllCustomers() {
		return dao.getAllCustomers();
	}

	@Override
	public Customer getCustById(int custId) {
		Customer cust = dao.getCustById(custId);
		if (cust == null)
			throw new CustomerNotFoundException("Customer with id:" + custId + " is not found");
		return cust;
	}

	@Override
	public Customer addCust(Customer cust) {
		// TODO Auto-generated method stub
		return dao.addCust(cust);
	}

	@Override
	public Customer updateCust(Customer cust) {
		// TODO Auto-generated method stub
		return dao.updateCust(cust);
	}

	@Override
	public Customer removeCust(int custId) {
		// TODO Auto-generated method stub
		return dao.removeCust(custId);
	}

}
