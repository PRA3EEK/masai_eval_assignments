package day16Assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MumbaiEmployee {
	
	public static void find () throws ClassNotFoundException {
	Class.forName("com.mysql.cj.jdbc.Driver");
	
		
		String connect = "jdbc:mysql://localhost:3306/prateekchauhan";
		try (Connection connection = DriverManager.getConnection(connect, "root", "prateekchauhan")){
			
			PreparedStatement ps = connection.prepareStatement("select e.empid, e.ename, e.address, e.mobile, e.deptid, d.dname from employee e join department d on d.did = e.deptid and e.address = 'mumbai';");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.println("Employee Id "+rs.getInt("empid"));
				System.out.println("Employee name "+rs.getString("ename"));
				System.out.println("Employee Address "+rs.getString("address"));
				System.out.println("Employee Contact Number "+rs.getString("mobile"));
				System.out.println("Employee department id "+rs.getInt("deptid"));
				System.out.println("Employee department name "+rs.getString("dname"));
				System.out.println(":+:+:+:+:+:+:+:+:+:+:+:+:+:+:+:+:+:");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		try {
			find();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	
		
	}
	
}
