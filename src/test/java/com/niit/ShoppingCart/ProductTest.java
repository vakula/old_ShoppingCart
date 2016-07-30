package com.niit.ShoppingCart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.niit.ShoppingCart.dao.ProductDAO;

import com.niit.ShoppingCart.model.Product;

public class ProductTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.ShoppingCart");
		context.refresh();
		ProductDAO productDAO=  (ProductDAO)context.getBean("productDAO");
		Product product=(Product)context.getBean("product");
		product.setId("PG120");
		product.setName("PGName120");
		product.setDescription("PGDesc120");
		productDAO.saveOrUpdate(product);
}
}
