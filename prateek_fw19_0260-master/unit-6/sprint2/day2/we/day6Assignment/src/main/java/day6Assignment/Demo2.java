package day6Assignment;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import connection.Connection;

public class Demo2 {

	public static void main(String[] args) {
		EntityManager em = Connection.getConnection();
		
		Costumer c1 = new Costumer();
		c1.setName("prateek chauhan");
		c1.setMobileNumber("9315807215");
		c1.setEmail("prateek@gmail.com");
		
		Address a1 = new Address();
		a1.setState("Delhi");
		a1.setCity("New Delhi");
		a1.setPincode("110051");
		a1.setType("home");
		
		Address a2 = new Address();
		a2.setState("Delhi");
		a2.setCity("Noida");
		a2.setPincode("110062");
		a2.setType("office");
		
		
		c1.getAddresses().add(a1);
		c1.getAddresses().add(a2);
		
		Costumer c2 = new Costumer();
		c2.setName("pratham chauhan");
		c2.setMobileNumber("9354041326");
		c2.setEmail("pratham@gmail.com");
		
		Address a3 = new Address();
		a3.setState("Delhi");
		a3.setCity("New Delhi");
		a3.setPincode("110092");
		a3.setType("home");

		
		Address a4 = new Address();
		a4.setState("Haryana");
		a4.setCity("Gururgram");
		a4.setPincode("110015");
		a4.setType("office");

		
		c2.getAddresses().add(a3);
		c2.getAddresses().add(a4);
		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(c1);
		em.persist(c2);
		et.commit();
		em.close();
	}
}
