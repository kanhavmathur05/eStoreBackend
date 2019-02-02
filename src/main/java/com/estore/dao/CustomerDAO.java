package com.estore.dao;

import java.util.List;

import com.estore.model.Customer;

public interface CustomerDAO {
	 void addCustomer(Customer customer);
     Customer getCustomerByID(int customerID);
     List<Customer> getAllCustomers();
     Customer getCustomerByUserName(String userName);
     Customer updateCustomer(Customer customer);
}
