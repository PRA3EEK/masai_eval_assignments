package connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Connection {

	
	private static EntityManagerFactory emf;
	
	static {
		
		emf = Persistence.createEntityManagerFactory("day6assignment");
	}
	
	public static EntityManager getConnection () {
	
		EntityManager em = emf.createEntityManager();
		
		return em;
		
	}
}
