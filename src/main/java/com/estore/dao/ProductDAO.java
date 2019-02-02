package com.estore.dao;

import java.util.List;

import com.estore.model.Product;

public interface ProductDAO {
	List<Product> getAllProducts();
	boolean addProduct(Product product);
	List<Product> getProdyctByName(String productName);
	Product getProductByID(int productID);
	boolean updateProduct(Product product);
	boolean deleteProduct(Product product);
}
