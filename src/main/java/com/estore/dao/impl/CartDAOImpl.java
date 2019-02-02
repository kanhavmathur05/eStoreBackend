package com.estore.dao.impl;

import java.io.IOException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.estore.dao.CartDAO;
import com.estore.model.Cart;
import com.estore.service.CustomerOrderService;

@Repository
@Transactional
public class CartDAOImpl implements CartDAO{

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
    private CustomerOrderService customerOrderService;
	
	public Cart getCartByID(int cartID) {
		Cart cart;
		try
		{
		Criteria cr=sessionFactory.getCurrentSession().createCriteria(Cart.class);
		cr.add(Restrictions.eq("cartID", cartID));
		cart=(Cart) cr.uniqueResult();
		return cart;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
		/*
		Session session=sessionFactory.getCurrentSession();
        return (Cart)session.get(Cart.class,cartID);
		*/
	}

	public Cart validate(int cartID) throws IOException {
		Cart cart=getCartByID(cartID);
        if(cart==null||cart.getCartItems().size()==0){
            throw new IOException(cartID + "");
        }
        update(cart);
        return cart;
	}

	public void update(Cart cart) {
		int cartID=cart.getCartID();
        double grandTotal=customerOrderService.getCustomerOrderGrandTotal(cartID);
        cart.setGrandTotal(grandTotal);

        Session session=sessionFactory.getCurrentSession();
        session.saveOrUpdate(cart);
	}

}
