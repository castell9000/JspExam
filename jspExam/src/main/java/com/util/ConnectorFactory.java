package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorFactory {
	
	private Connection connection;
	
	private static final ConnectorFactory connector = new ConnectorFactory();
	private ConnectorFactory(){};
	public static ConnectorFactory getFactory(){
		return connector;
	}
	public Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root","shidaiqian");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	
}
