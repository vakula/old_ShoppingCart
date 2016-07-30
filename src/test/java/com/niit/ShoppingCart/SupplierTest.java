package com.niit.ShoppingCart;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.ShoppingCart.dao.SupplierDAO;
import com.niit.ShoppingCart.model.Supplier;


public class SupplierTest {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.ShoppingCart");
		context.refresh();
		SupplierDAO supplierDAO=   (SupplierDAO)context.getBean("supplierDAO");
		Supplier supplier=(Supplier)context.getBean("supplier");
		supplier.setId("sp120");
		supplier.setName("spvaku");
		supplier.setAddress("Nellore");
		supplierDAO.saveOrUpdate(supplier);
		supplierDAO.delete("CG120");
		if(supplierDAO.get("sp120")==null)
		{
			System.out.println("Supplier does not exist");
		}
		else
		{
			System.out.println("Supplier exist..the details are..");
			System.out.println();
		}
		
	}


}
