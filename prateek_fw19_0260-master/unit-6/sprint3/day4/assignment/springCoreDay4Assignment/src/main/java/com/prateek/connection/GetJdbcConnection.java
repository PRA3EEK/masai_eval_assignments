package com.prateek.connection;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.prateek.questions.AppConfig;

public class GetJdbcConnection {

	public static Connection provideConnection() throws ClassNotFoundException, SQLException {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		GetConnection gc = ctx.getBean("getConnection", GetConnection.class);
		
		Connection con = gc.getConnection();
		
	return con;
		
	}
	
}
