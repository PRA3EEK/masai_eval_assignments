package mainApp;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import classes.Address;
import classes.Costumer;
import utility.GetConnection;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManager em = GetConnection.entityManager();
		EntityTransaction et = em.getTransaction();
		
		
     Costumer c1 = new Costumer();
     c1.setName("prateek chauhan");
     c1.setMobileNumber("9315807215");
     c1.setEmail("prateek@gamil.com");
     c1.getAddresses().add(new Address("Delhi", "new Delhi", "110051", "home"));
     c1.getAddresses().add(new Address("Delhi", "new Delhi", "110051", "office"));
     c1.getAddresses().add(new Address("Delhi", "new Delhi", "110051", "permament"));
     
     Costumer c2 = new Costumer();
     c2.setName("pratham chauhan");
     c2.setMobileNumber("9354041326");
     c2.setEmail("pratham@gamil.com");
     c2.getAddresses().add(new Address("Delhi", "karkarduma", "110092", "home"));
     c2.getAddresses().add(new Address("Delhi", "karkarduma", "110092", "office"));
     c2.getAddresses().add(new Address("Delhi", "karkarduma", "110092", "permament"));
     
		et.begin();
		em.persist(c1);
		

	
		em.persist(c2);
		
		et.commit();
		em.close();
	}

}
