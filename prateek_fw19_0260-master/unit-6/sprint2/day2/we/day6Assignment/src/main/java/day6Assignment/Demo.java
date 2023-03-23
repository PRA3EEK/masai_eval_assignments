package day6Assignment;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import connection.Connection;

public class Demo {

	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		EntityManager em = Connection.getConnection();
		 try {
		System.out.println("Enter college Id");
		int id = sc.nextInt();
		
		
		
        String st = "from College where collegeId = :id";
        
        Query q = em.createQuery(st);
        
        q.setParameter("id", id);
       
        	College c = (College)q.getSingleResult();
        	
    		List<Student> res = c.getStudentList();
    		
    		res.forEach(e -> {
    			System.out.println(e.getRoll());
    			System.out.println(e.getName());
    			System.out.println(e.getMobileNumber());
    			System.out.println(e.getEmail());
//    			System.out.println(e.getColl());
    		    System.out.println("===============================");
    		});
        }catch(Exception e) {
        	System.out.println(e.getMessage());
        }finally {
        	em.close();
        }
       
        
//		System.out.println(res);
		
		
	}
}
