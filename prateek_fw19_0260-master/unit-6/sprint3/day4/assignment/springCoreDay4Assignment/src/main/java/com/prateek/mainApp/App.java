package com.prateek.mainApp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.prateek.questions.AppConfig;
import com.prateek.useCase.AddStudent;

public class App {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		AddStudent as = ctx.getBean("addStudent", AddStudent.class);
		as.insertStudent();
		
	}
	
}
