package com.estore.dao;

import java.io.IOException;

import com.estore.model.Cart;

public interface CartDAO {
	Cart getCartByID(int cartID);
    Cart validate(int cartID) throws IOException;
    void update(Cart cart);
}
