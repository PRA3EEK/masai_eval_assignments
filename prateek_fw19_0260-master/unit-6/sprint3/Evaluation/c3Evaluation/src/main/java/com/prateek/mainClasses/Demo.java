package com.prateek.mainClasses;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.prateek.configurations.AppConfig;
import com.prateek.services.StudentService;

public class Demo {
  
	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		StudentService ss = ctx.getBean("studentService", StudentService.class);
		ss.printMap();
		ss.printList();
		ss.printAppName();
		
		
		
	}
	
}
