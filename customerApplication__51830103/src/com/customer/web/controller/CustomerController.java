package com.customer.web.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.customer.model.persistance.Customer;
import com.customer.model.service.CustomerService;


@Controller
public class CustomerController {

	@Autowired
	private CustomerService custService;


	@RequestMapping(value = "allcustomers", method = RequestMethod.GET)
	public String getCustomers(ModelMap map) {
		map.addAttribute("customers", custService.getAllCustomers());
		return "all_customers";
	}

	@RequestMapping(value = "addcustomer", method = RequestMethod.GET)
	public String addCustomerGet(ModelMap map) {
		// adding an form bean
		map.addAttribute("customer", new Customer());
		return "addcustomer";
	}

	@RequestMapping(value = "addcustomer", method = RequestMethod.POST)
	public String addBookUpdatePost(@Valid Customer customer,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "addcustomer";
		} else {

			if (customer.getId() == 0)
				custService.addCust(customer);
			else
				custService.updateCust(customer);
			return "redirect:allcustomers";
		}
	}

	// controller mapped for delete
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteCustomer(HttpServletRequest req) {
		int custId = Integer.parseInt(req.getParameter("id"));
		custService.removeCust(custId);
		return "redirect:allcustomers";
	}

	// update get part
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String updateBookGet(HttpServletRequest req, ModelMap map) {
		int custId = Integer.parseInt(req.getParameter("id"));
		Customer custToBeUpdate = custService.getCustById(custId);
		System.out.println(custToBeUpdate);
		map.addAttribute("customer", custToBeUpdate);
		return "addcustomer";
	}

	@ModelAttribute(value = "pubList")
	public List<String> getEmployeeList() {
		return Arrays.asList("Worker", "Salesman", "Manager", "Director");
	}
	
	
}
