package com.customer.model.persistance;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class CustomerDaoImpl implements CustomerDao{

	@Autowired
	private SessionFactory factory;

	private Session getSession() {
		return factory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getAllCustomers() {
		return getSession().createQuery("from Customer").list();
	}

	@Override
	public Customer getCustById(int custId) {		
		return (Customer) getSession().get(Customer.class, custId);
	}

	@Override
	public Customer addCust(Customer cust) {
		getSession().save(cust);
		return cust;
	}

	@Override
	public Customer updateCust(Customer cust) {
		getSession().update(cust);
		return cust;
	}

	@Override
	public Customer removeCust(int custId) {
		Customer custDeleted = getCustById(custId);
		getSession().delete(custDeleted);
		return custDeleted;
	}

}
