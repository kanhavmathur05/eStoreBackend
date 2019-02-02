package com.estore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estore.dao.CustomerOrderDAO;
import com.estore.model.Cart;
import com.estore.model.CartItem;
import com.estore.model.CustomerOrder;
import com.estore.service.CartService;
import com.estore.service.CustomerOrderService;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService{

	@Autowired
    private CustomerOrderDAO customerOrderDAO;
	
	@Autowired
    private CartService cartService;
	
	public void addCustomerOrder(CustomerOrder customerOrder) {
		customerOrderDAO.addCustomerOrder(customerOrder);
	}

	public double getCustomerOrderGrandTotal(int cartID) {
		double grandTotal=0;
        Cart cart=cartService.getCartByID(cartID);
        List<CartItem> cartItems=cart.getCartItems();

        for (CartItem item : cartItems){
            grandTotal+=item.getTotalPrice();
        }

        return grandTotal;
	}

}
