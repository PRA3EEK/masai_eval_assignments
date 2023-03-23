package com.prateek.questions;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.prateek.connection.GetConnection;

public class Demo2 {

	
	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		
		Travel t = ctx.getBean("travel",Travel.class);
		
		t.journey();
		
		AnnotationConfigApplicationContext c = (AnnotationConfigApplicationContext)ctx;
		c.close();
	}
}
