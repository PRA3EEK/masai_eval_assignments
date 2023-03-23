package com.prateek.DAO;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prateek.questions.Student;


@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentDao sdo;
	
	@Override
	public String addStudent(int roll, String name, String address) {
		// TODO Auto-generated method stub
		try {
			return sdo.addStudent(roll, name, address);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			return e.getMessage();
		}
//		return null;
	}

}
