package com.prateek.DAO;

import java.sql.SQLException;

import com.prateek.questions.Student;

public interface StudentDao {

	public String addStudent (int roll, String name, String add) throws ClassNotFoundException, SQLException; 
	
}
