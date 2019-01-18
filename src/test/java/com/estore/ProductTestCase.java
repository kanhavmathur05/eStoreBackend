package com.estore;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.estore.model.Product;
import com.estore.service.ProductService;

public class ProductTestCase {
	ProductService productService;
	AnnotationConfigApplicationContext context;
	Product product;
	@Before
	public void setUp()
	{
		context= new AnnotationConfigApplicationContext();
		context.scan("com.estore");
		context.refresh();
		product = (Product)context.getBean("product");
		productService=(ProductService)context.getBean("productService");
	}
	
	@Ignore
	@Test
	public void addProduct()
	{
		boolean result;
		product.setPrice(50000);
		product.setProductName("HP Laptop");
		product.setQuantity(1);
		product.setProductDescription("This is an HP Laptop");
		product.setProductCategory("Laptop");
		product.setImageName("laptop.jpg");
		result=productService.addProduct(product);
		if(result)
		{
			System.out.println("Product Added");
		}
		else
		{
			System.out.println("Error in adding Product");
		}
	}
	
	@Ignore
	@Test
	public void getAllProductsTest()
	{
		List<Product> allProducts=productService.getAllProducts();
		assertNotNull("Fetched", allProducts);
		for(Product product:allProducts)
		{
			System.out.println("Product Name:  "+product.getProductName()+"   "+"Price:  "+product.getPrice()+" Product Description: "+product.getProductDescription()+" Quantity: "+product.getQuantity());
		}
	}

	@Ignore
	@Test
	public void getProductByID()
	{
		product=productService.getProductById(3);
		System.out.println("Product Name: "+product.getProductName()+"Product Price: "+product.getPrice());
	}
	
	@Ignore
	@Test
	public void getProductByName() 
	{
		List<Product> productList=productService.getProdyctByName("Appl");
		assertNotNull("Fetched",productList);
		for(Product product:productList) {
			System.out.println("Product Name: "+product.getProductName()+"Product ID:"+product.getProductID()+"Description: "+product.getProductDescription()+"Price: "+product.getPrice());
		}
	}
	
	@Ignore
	@Test
	public void updateProduct()
	{
		boolean result;
		product.setProductID(6);
		product.setPrice(60000);
		product.setProductCategory("Laptop");
		product.setProductDescription("This is a MacBook Air");
		product.setProductName("MacBook Air");
		product.setImageName("appleMacBookAir.jpg");
		product.setQuantity(1);
		
		result=productService.updateProduct(product);
		if(result) {
			System.out.println("Product Updated");
		}
		else {
			System.out.println("Not Updated");
		}
	}
	
	@Ignore
	@Test
	public void deleteProduct()
	{
		boolean result;
		product.setProductID(4);
		result=productService.deleteProduct(product);
		if(result)
		{
			System.out.println("Product Deleted");
		}
		else
		{
			System.out.println("An error occured/Product not deleted");
		}
	}
	@After
	public void tearDown()
	{
		context.close();
	}
}
