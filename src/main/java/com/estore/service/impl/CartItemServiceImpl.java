package com.estore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estore.dao.CartItemDAO;
import com.estore.model.Cart;
import com.estore.model.CartItem;
import com.estore.service.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService
{

	@Autowired
    private CartItemDAO cartItemDAO;
	
	public void addCartItem(CartItem cartItem) {
		cartItemDAO.addCartItem(cartItem);
	}

	public void removeCartItem(CartItem cartItem) {
		cartItemDAO.removeCartItem(cartItem);
	}

	public void removeAllCartItems(Cart cart) {
		cartItemDAO.removeAllCartItems(cart);
	}

	public CartItem getCartItemByProductID(int productID) {
		return cartItemDAO.getCartItemByProductID(productID);
	}

}
