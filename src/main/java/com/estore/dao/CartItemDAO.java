package com.estore.dao;

import com.estore.model.Cart;
import com.estore.model.CartItem;

public interface CartItemDAO {
	void addCartItem(CartItem cartItem);
    void removeCartItem(CartItem cartItem);
    void removeAllCartItems(Cart cart);
    CartItem getCartItemByProductID(int productID);
}
