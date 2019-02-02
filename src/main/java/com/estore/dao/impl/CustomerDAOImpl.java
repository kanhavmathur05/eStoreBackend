package com.estore.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.estore.dao.CustomerDAO;
import com.estore.model.Authorities;
import com.estore.model.Cart;
import com.estore.model.Customer;
import com.estore.model.User;

@Repository
@Transactional
public class CustomerDAOImpl implements CustomerDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addCustomer(Customer customer) {
		Session session=sessionFactory.getCurrentSession();

        customer.getBillingAddress().setCustomer(customer);
        customer.getShippingAddress().setCustomer(customer);

        session.saveOrUpdate(customer);
        session.saveOrUpdate(customer.getBillingAddress());
        session.saveOrUpdate(customer.getShippingAddress());

        User newUser=new User();
        newUser.setUserName(customer.getUserName());
        newUser.setPassword(customer.getPassword());
        newUser.setEnabled(true);
        newUser.setCustomerID(customer.getCustomerID());

        Authorities newAuthorities=new Authorities();
        newAuthorities.setUserName(customer.getUserName());
        newAuthorities.setRole("ROLE_USER");

        session.saveOrUpdate(newUser);
        session.saveOrUpdate(newAuthorities);

        Cart newCart=new Cart();
        newCart.setCustomer(customer);
        customer.setCart(newCart);

        session.saveOrUpdate(customer);
        session.saveOrUpdate(newCart);

        session.flush();	
	}

	public Customer getCustomerByID(int customerID) {
		Customer customer;
		try 
		{
			Criteria cr=sessionFactory.getCurrentSession().createCriteria(Customer.class);
			cr.add(Restrictions.eq("customerID", customerID));
			customer=(Customer) cr.uniqueResult();
			return customer;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
		/*
		Session session=sessionFactory.getCurrentSession();
        return (Customer) session.get(Customer.class, customerID);
		*/
	}

	public List<Customer> getAllCustomers() {
		List<Customer> customerList=new ArrayList<>();
		try
		{
		customerList=sessionFactory.getCurrentSession().createQuery("from Customer").list();
		return customerList;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
		/*
		 Session session = sessionFactory.getCurrentSession();
	     Query query=session.createQuery("from Customer");
	     List<Customer> customerList = query.list();
         return customerList;
         */
	}

	public Customer getCustomerByUserName(String userName) {
		Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("from Customer where userName=?");
        query.setString(0, userName);
        return (Customer) query.uniqueResult();

	}

	public Customer updateCustomer(Customer customer) {
		try {
			sessionFactory.getCurrentSession().update(customer);
			return customer;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}

}

