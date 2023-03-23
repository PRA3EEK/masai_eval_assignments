package sprint4Evaluation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertIntoStudent {
      
	public static void insertValues() throws ClassNotFoundException {
		
	  Class.forName("com.mysql.cj.jdbc.Driver");
	  
	  
	try  ( Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/prateekchauhan", "root", "prateekchauhan")){
		 Scanner sc = new Scanner(System.in);
		 
		 boolean flag = true;
		 
		 while(flag) {
			 
	            System.out.println("Enter student roll");
	            int roll = sc.nextInt();
	            sc.nextLine();
	            System.out.println("Enter student name");
	            String name = sc.nextLine();
	            System.out.println("Enter Address");
	            String add = sc.nextLine();
	            System.out.println("Enter Contact number");
	            String num = sc.next();
	            
			 PreparedStatement ps =  connection.prepareStatement("insert into student values (?,?,?,?)");
			 
			 ps.setInt(1, roll);
			 ps.setString(2,name);
			 ps.setString(3, add);
			 ps.setString(4, num);
			 
			 int res = ps.executeUpdate();
	   
			 if(res > 0) {
				System.out.println("Details added successfuly");
			 }else {
				System.out.println("Details are not added please checkk the details carefully");
			 }
			 System.out.println("Continue Adding (Y/N)");
			 String x = sc.next();
			 if(x.toLowerCase().equals("n")) {
				 flag = false;
			 }else if(x.toLowerCase().equals("y")){
				flag = true;
			 }
		
	} 
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	  
	
		 
	 }
	 
	
	
		
	
	
	public static void main(String[] args) {
		
		try {
			insertValues();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}
	
}
