package com.niit.ShoppingCart.dao;
import java.util.List;

import javax.persistence.Query;
import com.niit.ShoppingCart.dao.SupplierDAO;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.niit.ShoppingCart.model.Supplier;
@Repository("supplierDAO")

public class SupplierDAOImpl implements SupplierDAO {
	@Autowired
	private SessionFactory sessionFactory;
		public SupplierDAOImpl(SessionFactory sessionFactory){
			this.sessionFactory=sessionFactory;
		}
		@Transactional
		public void saveOrUpdate(Supplier supplier){
			sessionFactory.getCurrentSession().saveOrUpdate(supplier);
		}
		@Transactional
		public void delete(String id){
			Supplier supplierToDelete=new Supplier();
			supplierToDelete.setId(id);
			sessionFactory.getCurrentSession().delete(supplierToDelete);
		}
		@Transactional
		public Supplier get(String id){
			String hq1=("from Supplier where id="+""+id+"");
			Query query=(Query)sessionFactory.getCurrentSession().createQuery(hq1);
			@SuppressWarnings("unchecked")
			List<Supplier> listSupplier=(List<Supplier>)query.getResultList();
			{
				if (listSupplier != null && listSupplier.isEmpty())
				return listSupplier.get(0);
				}
			return null;
		}
		@Transactional
		public List<Supplier> list(){
			@SuppressWarnings({ "unchecked", "deprecation" })
			List<Supplier>listSupplier=(List<Supplier>)
			sessionFactory.getCurrentSession()
			.createCriteria(Supplier.class)
		.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			return listSupplier;
			
			

}
}
