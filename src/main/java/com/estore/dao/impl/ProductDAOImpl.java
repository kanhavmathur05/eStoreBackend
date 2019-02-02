package com.estore.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.estore.dao.ProductDAO;
import com.estore.model.Product;

@Repository(value="productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	public List<Product> getAllProducts() {
		List<Product> allProducts=new ArrayList<>();
		try
		{
			allProducts=sessionFactory.getCurrentSession().createQuery("from Product").list();
			return allProducts;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}

	public boolean addProduct(Product product) {
		try
		{
			sessionFactory.getCurrentSession().save(product);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

	public List<Product> getProdyctByName(String productName) {
		List<Product> productList;
		try {
			Criteria cr=sessionFactory.getCurrentSession().createCriteria(Product.class);
			cr.add(Restrictions.like("productName",""+productName+"%",MatchMode.ANYWHERE));
			productList=cr.list();
			return productList;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public Product getProductByID(int productID){
		Product product;
		try {
			Criteria cr=sessionFactory.getCurrentSession().createCriteria(Product.class);
			cr.add(Restrictions.eq("productID",productID));
			product=(Product) cr.uniqueResult();
			return product;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public boolean updateProduct(Product product) {
		try {
			
			sessionFactory.getCurrentSession().update(product);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

	public boolean deleteProduct(Product product) {
		try {
		sessionFactory.getCurrentSession().delete(product);
		return true;
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
			return false;
		}
	}

	
}
