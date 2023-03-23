package mainApps;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entities.Course;
import entities.Student;
import utility.HM;

public class Demo2 {
  
	
	public static void main(String[] args) {
		EntityManager em = HM.pC();
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter course Id");
		    int id = sc.nextInt();
			
			
			String st = "from Course where courseId = :id";
			TypedQuery<Course> q = em.createQuery(st, Course.class);
			q.setParameter("id", id);
			Course c = q.getSingleResult();
			List<Student> res = c.getStudents();
			
			
			res.forEach(s -> {
				System.out.println(s.getRoll());
				System.out.println(s.getName());
				System.out.println(s.getMobile());
				System.out.println(s.getEmail());
				System.out.println("+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
			});
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			em.close();
		}
	    
				
				
		
	}
}
