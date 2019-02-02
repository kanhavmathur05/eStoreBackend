package com.estore.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.estore.dao.CustomerOrderDAO;
import com.estore.model.CustomerOrder;

@Repository
@Transactional
public class CustomerOrderDAOImpl implements CustomerOrderDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addCustomerOrder(CustomerOrder customerOrder) {
		Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customerOrder);
        session.flush();
	}

}
