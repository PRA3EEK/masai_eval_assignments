package utility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HM {

	
	private static EntityManagerFactory emf;
	
	static {
		
		emf = Persistence.createEntityManagerFactory("day7assignment");
	}
	
	public static EntityManager pC() {
		
		EntityManager em = emf.createEntityManager();

		return em;
	}
	
}
