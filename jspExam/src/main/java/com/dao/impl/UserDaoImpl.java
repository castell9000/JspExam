package com.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dao.UserDao;
import com.entity.Customer;

public class UserDaoImpl implements UserDao {
	
	private Connection connection = null;
	private PreparedStatement statement = null;
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root","shidaiqian");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
		//return ConnectorFactory.getFactory().getConnection();
	}

	public Customer gerUser(String username) {
		System.out.println("-------impl-----------");
		Customer user = new Customer();
		String sql = "select * from customer where first_name=?";
		connection = this.getConnection();
		//connection = ConnectorFactory.getFactory().getConnection();
		try {
			statement = connection.prepareCall(sql);
			statement.setString(1, username);
			//user = (UserEntity) statement.executeQuery().;
			ResultSet set = statement.executeQuery();
			while (set.next()) {
				System.out.println(set.getString(2) + set.getInt("customer_id"));
				user.setCustomer_id(set.getInt("customer_id"));
				user.setFirst_name(set.getString("first_name"));				
			}
			//System.out.println(user.getName() + " " + user.getId() + "测试");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection != null){
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return user;
	}
	/*public int insert(UserEntity user) {
		int i = 0;
		String sql = "insert into user(name,password,email) values(?,?,?)";
		connection = this.getConnection();
		try {
			connection.setAutoCommit(false);
			statement = connection.prepareCall(sql);
			statement.setString(1, user.getName());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getEmail());
			i = statement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
				System.out.println("===========事务回滚===========");
				return 0;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			System.out.println(e);
			e.printStackTrace();
		}finally{
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection != null){
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return i;
	}*/
}
