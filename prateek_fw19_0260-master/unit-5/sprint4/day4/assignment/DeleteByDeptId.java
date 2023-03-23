package day16Assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteByDeptId {
    
	public static void delete () throws ClassNotFoundException {
		
	   Class.forName("com.mysql.cj.jdbc.Driver");
	   String connect = "jdbc:mysql://localhost:3306/prateekchauhan";
	   try (Connection connection = DriverManager.getConnection(connect,"root","prateekchauhan")){
		   
		   Scanner sc = new Scanner(System.in);
		   
		   System.out.println("Enter department id from which you want to delete employees");
		   int id = sc.nextInt();
		   
		   PreparedStatement ps = connection.prepareStatement("delete from employee where deptid = ?");
//		   PreparedStatement ps2 = connection.prepareStatement("select dname from department where did = ?");
//		   ps2.setInt(1, id);
		   ps.setInt(1, id);
		   
		   
//			   ResultSet rs = ps2.executeQuery();
//			   String depname = rs.getString("dname").toUpperCase();
			   int res = ps.executeUpdate();
		   
		    if(res > 0) {
//		    	System.out.println("Successfuly delete employees from of department "+depname);
		    	System.out.println("Successfuly deleted employee from the department");
		    }else {
		    	System.out.println("No employee from this department!");
		    }
		   
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	}
	
	public static void main(String[] args) {
		
		try {
			delete();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}
}
