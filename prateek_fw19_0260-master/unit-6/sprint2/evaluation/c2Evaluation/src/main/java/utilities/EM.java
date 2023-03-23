package utilities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EM {
  

	private static EntityManagerFactory emf;
	
	static {
		
		emf = Persistence.createEntityManagerFactory("evalUnit");
	}
	
	public static EntityManager provideEM() {
		EntityManager em = emf.createEntityManager();
		return em;
	}
	
}
