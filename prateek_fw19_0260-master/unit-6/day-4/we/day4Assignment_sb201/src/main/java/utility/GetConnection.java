package utility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GetConnection {

	private static EntityManagerFactory emf ;
	
	static {
		emf = Persistence.createEntityManagerFactory("employeeUnit");
	}
	
	public static EntityManager entityManager() {
		
		
		EntityManager em = emf.createEntityManager();
		
		return em;
	}
	
}
