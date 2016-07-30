package com.niit.ShoppingCart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.niit.ShoppingCart.dao.UserDAO;

import com.niit.ShoppingCart.model.User;

public class UserTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.ShoppingCart");
		context.refresh();
		UserDAO userDAO=  (UserDAO)context.getBean("userDAO");
		User user=(User)context.getBean("user");
		user.setId("PG120");
		user.setName("PGName120");
		user.setAddress("Hyderabad");
		user.setMail("vakuladevi.o@gmail.com");
		user.setMobile(994989999);
		userDAO.saveOrUpdate(user);
}
}
