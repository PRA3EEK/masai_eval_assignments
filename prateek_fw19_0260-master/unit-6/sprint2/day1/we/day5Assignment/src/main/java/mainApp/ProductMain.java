package mainApp;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import java.util.List;
import classes.Product;
import utility.GetConnection;

public class ProductMain {

	public static void main(String[] args) {
		
	
		
		
		EntityManager em = GetConnection.entityManager();
	
		
		Query q = em.createNamedQuery("Product.getNameAndQuantity");
		List<Object[]> l = q.getResultList();
		em.close();
	
       l.forEach(e->{
    	   
       System.out.println("product : "+e[0]+" | "+"quantity : "+e[1]);
    	   
       });
		
	}
	
}
