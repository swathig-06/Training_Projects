package com.customer.model.persistance;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "cust_tableproj")
public class Customer {
	@Id
	@GeneratedValue
	private int id;
	
	@NotEmpty(message="name cant left blank")
	private String name;
	
	@NotEmpty(message="address cant left blank")
	private String address;
	
	@Email
	@NotEmpty(message="email cant left blank")
	private String email;
	
	@NotEmpty(message="mobile cant left blank")
	private String mobile;
	
	@NotNull(message="price can not be null")
	@Min(value=1000, message="min price should be more then 1000")
	//@Max(value=10000, message="max price should be less then 10000")
	private Double salary;

	private String employee;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getEmployee() {
		return employee;
	}

	public void setEmployee(String employee) {
		this.employee = employee;
	}

	public Customer( String name, String address, String email, String mobile, Double salary, String employee) {
		this.name = name;
		this.address = address;
		this.email = email;
		this.mobile = mobile;
		this.salary = salary;
		this.employee = employee;
	}
	public Customer(){}
	/*@NotNull(message="date can not be left blank")
	@Past
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	public Date pubDate;*/
	
}
