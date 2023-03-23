package mainApp;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import classes.Product;
import utility.GetConnection;

public class GetProductPriceWithId {
  
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	   System.out.println("Enter product id");
	   int pid = sc.nextInt();
		
		EntityManager em = GetConnection.entityManager();
		TypedQuery<Double> q = em.createNamedQuery("Product.getPriceById", Double.class);
		q.setParameter("pid", pid);
		double p = q.getSingleResult();
		System.out.println("Price of the product with product id "+pid+" = "+p);
		em.close();
	}
}
