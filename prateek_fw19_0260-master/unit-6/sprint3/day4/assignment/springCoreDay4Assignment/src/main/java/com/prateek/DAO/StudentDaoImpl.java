package com.prateek.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.prateek.connection.GetJdbcConnection;
import com.prateek.questions.Student;


@Repository
public class StudentDaoImpl implements StudentDao{

	@Override
	public String addStudent(int roll, String name, String add) throws ClassNotFoundException, SQLException {
	    
		Connection con = GetJdbcConnection.provideConnection();
		
		  PreparedStatement ps = con.prepareStatement("insert into student values (?, ?, ?) ");

		  ps.setInt(1, roll);
		  ps.setString(2, name);
		  ps.setString(3, add);
		  
		 int res =  ps.executeUpdate();
		if(res > 0) {
			con.close();
			return "Student added successfully";
		}else {
			con.close();
			return null;
		}
	
		
	}

	
	
}
