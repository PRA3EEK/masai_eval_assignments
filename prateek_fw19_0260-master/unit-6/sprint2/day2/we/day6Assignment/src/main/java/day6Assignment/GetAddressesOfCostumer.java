package day6Assignment;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

//import antlr.collections.List;
import connection.Connection;

public class GetAddressesOfCostumer {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		EntityManager em = Connection.getConnection();
		try {
			System.out.println("Enter costumer id");
			int id = sc.nextInt();
			String st = "from Costumer where cid = :id";
			
			TypedQuery<Costumer> q = em.createQuery(st, Costumer.class);
	   	    	q.setParameter("id", id);
		        Costumer c = q.getSingleResult();
		        List<Address> res = c.getAddresses();
		        
		        System.out.println(res);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
}
