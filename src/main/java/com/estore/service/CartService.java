package com.estore.service;

import com.estore.model.Cart;

public interface CartService {
	Cart getCartByID(int cartID);
    void update(Cart cart);
	
}
