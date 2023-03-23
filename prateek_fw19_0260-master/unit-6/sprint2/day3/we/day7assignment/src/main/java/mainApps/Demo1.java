package mainApps;

import java.util.HashMap;

import javax.persistence.EntityManager;

import entities.Course;
import entities.Student;
import utility.HM;

public class Demo1 {
	
	
	public static void main(String[] args) {
		
		Course c1 = new Course();
		c1.setCourseName("Java");
		c1.setDuration("6 months");
		c1.setFee(50000);
		
		Course c2 = new Course();
		c2.setCourseName("Spring");
		c2.setDuration("3 months");
		c2.setFee(30000);
		
		Student s1 = new Student();
		s1.setName("prateek chauhan");
		s1.setMobile("9315807215");
		s1.setEmail("prateek@gmail.com");
		s1.getCourses().add(c1);
		s1.getCourses().add(c2);
		
		
		Student s2 = new Student();
		s2.setName("pratham chauhan");
		s2.setMobile("9354041326");
		s2.setEmail("pratham@gmail.com");
		s2.getCourses().add(c1);
		s2.getCourses().add(c2);
		
		c1.getStudents().add(s1);
		c1.getStudents().add(s2);
		
		c2.getStudents().add(s1);
		c2.getStudents().add(s2);
		
		EntityManager eM = HM.pC();
		
		
		eM.getTransaction().begin();
		eM.persist(c1);
		eM.persist(c2);
		eM.getTransaction().commit();
		eM.close();
		
		
	}

}
