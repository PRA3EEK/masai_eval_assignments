package sprint4Evaluation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertIntoCourse {

	
	public static void insertIntoCourse() throws ClassNotFoundException{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
	  try( Connection connection = 	DriverManager.getConnection("jdbc:mysql://localhost:3306/prateekchauhan", "root", "prateekchauhan")){
	   
	   Scanner sc = new Scanner(System.in);
	   
	   
	   boolean flag = true;
	   
	   while(flag) {
		   
		   System.out.println("Enter course id");
           int id = sc.nextInt();
           sc.nextLine();
           System.out.println("Enter course name");
           String name = sc.nextLine();
           System.out.println("Enter course fee");
           int fee = sc.nextInt();
           System.out.println("Enter course duration");
           String dur = sc.next();
           
		  
		   
		   try {
			   PreparedStatement ps =  connection.prepareStatement("insert into course values (?,?,?,?)");
			   
			   ps.setInt(1, id);
			   ps.setString(2, name);
			   ps.setInt(3,fee);
			   ps.setString(4, dur);
			 int res =  ps.executeUpdate();
			 if(res > 0) {
				 System.out.println("Details added successfuly");
			 }else {
				 System.out.println("Cross check the details, Details are not added");
			 }
		   }
		   catch(SQLException e){
			   System.out.println(e.getMessage());
		   }
		   
		   System.out.println("Continue Adding (Y/N)");
			 String x = sc.next();
			 if(x.toLowerCase().equals("n")) {
				 flag = false;
			 }else if(x.toLowerCase().equals("y")){
				flag = true;
			 }
		   
	   }
	  }
	   catch(SQLException e) {
		   System.out.println(e.getMessage());
	   }
	  
		
	}
	
	public static void main(String[] args) {
		
		try {
			insertIntoCourse();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}
	
	
}
