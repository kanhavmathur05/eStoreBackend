package com.estore.service;

import java.util.List;
import com.estore.model.Customer;

public interface CustomerService {
	void addCustomer(Customer customer);
    Customer getCustomerByID(int customerID);
    List<Customer> getAllCustomers();
    Customer getCustomerByUsername(String userName);
    void updateCustomer(Customer customer);
}
