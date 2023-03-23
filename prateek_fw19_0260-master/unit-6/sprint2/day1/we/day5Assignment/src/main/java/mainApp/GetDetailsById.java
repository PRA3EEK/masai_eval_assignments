package mainApp;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import classes.Product;
import utility.GetConnection;

public class GetDetailsById {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter product Id");
		int id = sc.nextInt();
		
		EntityManager em = GetConnection.entityManager();
		String sql = "from Product where productId = : pid";
		TypedQuery<Product> q = em.createQuery(sql, Product.class);
		q.setParameter("pid", id);
		Product p = q.getSingleResult();
		System.out.println(p);
		em.close();
	}
	
}
