package com.prateek.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.prateek.beans.Course;
import com.prateek.beans.Student;


@Service
public class StudentService {
    @Autowired
	private Map<Student, Course> theMap;
    @Autowired
	private List<Student> theList;
	
	@Value("${name}")
	private String appName;
	
	public void printMap() {
		
	  for(Map.Entry<Student, Course> m:theMap.entrySet()) {
		  System.out.println("Student Details : "+m.getKey());
		  System.out.println("Course Details : "+m.getValue());
		  System.out.println("================================");
	  }
		
	}
	
	public void printList() {
		
		theList.forEach(s -> {
			
			System.out.println(s);
			System.out.println("==============================");
		});
		
	}
	
	public void printAppName() {
		
		System.out.println(appName);
	}
	
}
