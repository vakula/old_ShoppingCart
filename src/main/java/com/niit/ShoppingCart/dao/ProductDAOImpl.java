package com.niit.ShoppingCart.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.niit.ShoppingCart.model.Product;

@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO {
	private static final List<Product> listProduct = null;
	@Autowired
	private SessionFactory sessionFactory;
	public ProductDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
@Transactional
public void saveOrUpdate(Product product){
	sessionFactory.getCurrentSession().saveOrUpdate(product);
}
@Transactional
public void Delete(String id){
	Product productToDelete = new Product();
	productToDelete.setId(id);
	sessionFactory.getCurrentSession().delete(productToDelete);
}
@Transactional
public Product get(String id){
	String hql = "from category where id ="+""+id+"";
	Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
	List<Product> listProduct = (List<Product>)query.getResultList();
	
	if(listProduct != null && listProduct.isEmpty()){
		return listProduct.get(0);
	}
	return null;
}
@Transactional
public List<Product> list() {
	List<Product> listCategory = (List<Product>)
	sessionFactory.getCurrentSession()
	.createCriteria(Product.class)
	.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	return listProduct;
}
public void delete(String id) {
	// TODO Auto-generated method stub
	
}
}
