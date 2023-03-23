package com.prateek.questions;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Demo {
	
	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		Question1 q = ctx.getBean("question1",Question1.class);
		q.showStudents();
		
//		Travel t =ctx.getBean("travel",Travel.class);
//		t.journey();
	}

}
