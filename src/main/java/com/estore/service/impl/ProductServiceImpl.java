package com.estore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.estore.dao.ProductDAO;
import com.estore.model.Product;
import com.estore.service.ProductService;

@Service(value="productService")
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDAO productDAO;
	
	public List<Product> getAllProducts() {
		List<Product> allProducts=productDAO.getAllProducts();
		if(allProducts!=null)
		{
			return allProducts;
		}
		else
		{
			return null;
		}
	}

	public boolean addProduct(Product product) {
		if(productDAO.addProduct(product))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public List<Product> getProdyctByName(String productName) {
		List<Product> productList=productDAO.getProdyctByName(productName);
		if(productList!=null){
			return productList;
		}
		else {
			return null;
		}
	}

	public Product getProductByID(int productID) {
		Product product=productDAO.getProductByID(productID);
		if(product!=null) {
			return product;
		}
		else {
			return null;
		}
	}

	public boolean updateProduct(Product product) {
		if(productDAO.updateProduct(product)) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean deleteProduct(Product product) {
		if(productDAO.deleteProduct(product)) {
			return true;
		}
		else {
			return false;
		}
	}
}