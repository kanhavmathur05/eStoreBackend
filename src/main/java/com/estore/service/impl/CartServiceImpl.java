package com.estore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estore.dao.CartDAO;
import com.estore.model.Cart;
import com.estore.service.CartService;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
    private CartDAO cartDAO;

	public Cart getCartByID(int cartID) {
		return cartDAO.getCartByID(cartID);
	}

	public void update(Cart cart) {
		cartDAO.update(cart);
	}

}
