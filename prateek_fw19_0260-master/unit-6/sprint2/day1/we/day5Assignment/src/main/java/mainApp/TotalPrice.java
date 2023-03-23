package mainApp;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import classes.Product;
import utility.GetConnection;

public class TotalPrice {
	public static void main(String[] args) {
		
		
		EntityManager em = GetConnection.entityManager();
		String sql = "select sum(price) from Product";
		TypedQuery<Double> q = em.createQuery(sql, Double.class);
		
		Double p = q.getSingleResult();
		System.out.println(p);
		em.close();
	}
	
}
