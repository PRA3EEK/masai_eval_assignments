package day15Assignmen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCAssignmentQuestion2 {
  
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/prateekchauhan","root","prateekchauhan");
		
		System.out.println(connection);
		
	}
}
