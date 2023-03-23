package mainApp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


import classes.Product;
import utility.GetConnection;

public class GetAllProductAccToQuantity {
  
	
public static void main(String[] args) {
		
		
		EntityManager em = GetConnection.entityManager();
		String sql = "from Product where quantity<=5";
		TypedQuery<Product> q = em.createQuery(sql, Product.class);
		
		List<Product> p = q.getResultList();
		p.forEach(e -> {
			System.out.println(e);
		});
		em.close();
	}
}
