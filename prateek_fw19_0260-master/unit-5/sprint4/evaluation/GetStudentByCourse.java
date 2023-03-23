package sprint4Evaluation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class GetStudentByCourse {
  
	public static void getStudentByCourse () throws ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Scanner sc = new Scanner(System.in);
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prateekchauhan", "root", "prateekchauhan")){
			System.out.println("Enter Course Name");
			String course = sc.next();
			PreparedStatement ps = conn.prepareStatement("select s.roll, s.name, s.address, s.mobile, c.cname from student s join course c join student_course sc on s.roll = sc.student_roll and c.cid = sc.course_enrolled and c.cname = ?");
			
			try
			{
				
			ps.setString(1, course);
			 ResultSet rs = ps.executeQuery();
		      
		      while(rs.next()) {
		    	  System.out.println("Student roll "+ rs.getInt("roll"));
		    	  System.out.println("Student name "+ rs.getString("name"));
		    	  System.out.println("Student address "+ rs.getString("address"));
		    	  System.out.println("Student mobile "+ rs.getString("mobile"));
		    	  System.out.println("Student course name "+ rs.getString("cname"));
		    	  System.out.println("+++++++++++++++++++++++++++++++++++++++");
		      }
			}
			catch(SQLException e) {
			 System.out.println(e.getMessage());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
	
	
	public static void main(String[] args) {
		try {
			getStudentByCourse();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
