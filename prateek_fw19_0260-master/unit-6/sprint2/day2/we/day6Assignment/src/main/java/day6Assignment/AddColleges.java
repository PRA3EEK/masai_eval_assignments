package day6Assignment;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import connection.Connection;

public class AddColleges {

	
	public static void main(String[] args) {
		
		EntityManager em = Connection.getConnection();
		
		College c1 = new College();
		
		c1.setCollegeName("DU");
		c1.setCollegeAdrress("Delhi");
		
		
		Student s1 = new Student();
		s1.setName("prateek chauhan");
		s1.setMobileNumber("9354041326");
		s1.setEmail("prateek@gmail.com");
		s1.setColl(c1);
		
		Student s2 = new Student();
		s2.setName("pratham chauhan");
		s2.setMobileNumber("9378041326");
		s2.setEmail("pratham@gmail.com");
		s2.setColl(c1);
		Student s3 = new Student();
		s3.setName("aniket rawal");
		s3.setMobileNumber("9354041845");
		s3.setEmail("aniket@gmail.com");
		s3.setColl(c1);
		Student s4 = new Student();
		s4.setName("bhoomika");
		s4.setMobileNumber("9348341326");
		s4.setEmail("bhoomika@gmail.com");
		s4.setColl(c1);
		
	c1.getStudentList().add(s1);
	c1.getStudentList().add(s2);
	c1.getStudentList().add(s3);
	c1.getStudentList().add(s4);
		
		
		
		College c2 = new College();
		
		c2.setCollegeName("IIT Delhi");
		c2.setCollegeAdrress("Delhi");
		
		Student s5 = new Student();
		s5.setName("monty");
		s5.setMobileNumber("7845968325");
		s5.setEmail("monty@gmail.com");
		s5.setColl(c2);
		
		Student s6 = new Student();
		s6.setName("shobhhit");
		s6.setMobileNumber("8469235875");
		s6.setEmail("shobhhit@gmail.com");
		s6.setColl(c2);
		
		Student s7 = new Student();
		s7.setName("sandeep");
		s7.setMobileNumber("5486958325");
		s7.setEmail("sandeep@gmail.com");
		s7.setColl(c2);
		
		Student s8 = new Student();
		s8.setName("vishal");
		s8.setMobileNumber("9568325461");
		s8.setEmail("vishal@gmail.com");
		s8.setColl(c2);
		
		c2.getStudentList().add(s5);
		c2.getStudentList().add(s6);
		c2.getStudentList().add(s7);
		c2.getStudentList().add(s8);
		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(c1);
		em.persist(c2);
        et.commit();
        em.close();
	}
}
