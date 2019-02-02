package com.estore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estore.dao.CustomerDAO;
import com.estore.model.Customer;
import com.estore.service.CustomerService;


@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
    private CustomerDAO customerDAO;
	
	public void addCustomer(Customer customer) {
		 customerDAO.addCustomer(customer);
	}

	public Customer getCustomerByID(int customerID) {
		 return customerDAO.getCustomerByID(customerID);
	}

	public List<Customer> getAllCustomers() {
		 return customerDAO.getAllCustomers();
	}

	public Customer getCustomerByUsername(String userName) {
		return customerDAO.getCustomerByUserName(userName);
	}
	
	public void updateCustomer(Customer customer) {
		customerDAO.updateCustomer(customer);
	}

}
