package day16Assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertIntoEmployee {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String connect = "jdbc:mysql://localhost:3306/prateekchauhan";
		try(Connection connection = DriverManager.getConnection(connect, "root", "prateekchauhan")) {
			boolean flag = true;
			while(flag) {
				
				Scanner sc = new Scanner(System.in);
			    System.out.println("Enter employee id");
			    int id = sc.nextInt();
			    sc.nextLine();
			    System.out.println("Enter employee name");
			    String name = sc.nextLine();
			    System.out.println("Enter employee address");
			    String add = sc.nextLine();
			    System.out.println("Enter employee mobile number");
			    String num = sc.nextLine();
				System.out.println("Enter employee department id");
				int deptid = sc.nextInt();
				PreparedStatement ps = connection.prepareStatement("insert into employee values(?,?,?,?,?)");
				       ps.setInt(1, id);
				       ps.setString(2, name);
				       ps.setString(3, add);
				       ps.setString(4, num);
				       ps.setInt(5, deptid);
				       
				       try {
				    	   int upd = ps.executeUpdate();
							if(upd>0) {
								System.out.println("Details added successfully");
							}
				       }catch(SQLException e) {
				    	   System.out.println("Details are not added please cross check the details");
				       }
				       
				
				       
				System.out.println("Continue adding (Y/N)"); 
				String inp = sc.next();
				if(inp.toLowerCase().equals("n")) {
					flag = false;
				}
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	
}
