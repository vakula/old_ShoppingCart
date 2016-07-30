package com.niit.ShoppingCart.dao;

import java.util.List;

import com.niit.ShoppingCart.model.User;

public interface UserDAO {
	public List<User> list();
	public User get(String id);
	public void saveOrUpdate(User user);
	public void delete(String id);
}
