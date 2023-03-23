package com.prateek.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;


@Repository
public class GetConnection {
    
	@Value("${db.driver}")
    private String dbDriver;
	
	@Value("${db.protocol}")
	private String dbProtocol;
	
	@Value("${db.username}")
	private String dbUsername;
	
	@Value("${db.password}")
	private String dbPassword;
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName(dbDriver);
		
		Connection con = DriverManager.getConnection(dbProtocol, dbUsername, dbPassword);
		
		return con;
		
	}
}
