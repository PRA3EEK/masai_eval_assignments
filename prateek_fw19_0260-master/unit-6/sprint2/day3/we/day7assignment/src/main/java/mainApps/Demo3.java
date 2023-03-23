package mainApps;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entities.Course;
import entities.Student;
import utility.HM;

public class Demo3 {
  
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		EntityManager em = HM.pC();
		System.out.println("Enter Student id");
		int id = sc.nextInt();
		
		String st = "from Student where roll = :id";
		TypedQuery<Student> q = em.createQuery(st, Student.class);
		q.setParameter("id", id);
		
		Student s = q.getSingleResult();
		
		List<Course> res = s.getCourses();
				
		res.forEach(c -> {
			System.out.println(c.getCourseId());
			System.out.println(c.getCourseName());
			System.out.println(c.getDuration());
			System.out.println(c.getFee());
			System.out.println("+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
		});
				
		
	}
	
}
