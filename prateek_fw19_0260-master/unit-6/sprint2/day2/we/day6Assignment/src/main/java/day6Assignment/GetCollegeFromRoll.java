package day6Assignment;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import connection.Connection;

public class GetCollegeFromRoll {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		EntityManager em = Connection.getConnection();
		try {
		System.out.println("Enter Student roll number");
		int roll = sc.nextInt();
		
		
		
		String st = "from Student where roll = :r";
		
		TypedQuery<Student> q = em.createQuery(st, Student.class);
		
		q.setParameter("r", roll);
	
			Student s = q.getSingleResult();
			
			System.out.println("College Id : "+ s.getColl().getCollegeId());
			System.out.println("College name : "+s.getColl().getCollegeName());
			System.out.println("College address : "+s.getColl().getCollegeAdrress());
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			em.close();
		}
		

		
	}
	
}
