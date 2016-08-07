package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.UserDao;
import com.entity.Customer;
import com.entity.Film;
import com.entity.Language;
import com.util.ConnectorFactory;

public class UserDaoImpl implements UserDao {
	
	private Connection connection = null;
	private PreparedStatement statement = null;

	public Customer gerUser(String username) {
		System.out.println("-------impl-----------");
		Customer user = new Customer();
		String sql = "select * from customer where first_name=?";
		connection = ConnectorFactory.getFactory().getConnection();
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
	
	public List<Film> getFilms(int i, int numb) {
		List<Film> list = new ArrayList<Film>();
		
		String sql = "SELECT * FROM(SELECT film_id, title, description, name FROM film, language WHERE +"
        + "film.language_id = language.language_id) d WHERE d.film_id LIMIT ? , ?";
		connection = ConnectorFactory.getFactory().getConnection();
		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, i);
			statement.setInt(2, numb);
			ResultSet set = statement.executeQuery();
			while (set.next()) {
				Film film = new Film();
				film.setFilm_id(set.getInt("film_id"));
				film.setTitle(set.getString("title"));
				film.setDescription(set.getString("description"));
				film.setLanguageName(set.getString("name"));
				list.add(film);
			}
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
		return list;
	}
	
	public List<Language> getLanguages() {
		List<Language> list = new ArrayList<Language>();
		String sql = "select language_id,name from language";
		connection = ConnectorFactory.getFactory().getConnection();
		try {
			statement = connection.prepareStatement(sql);
			ResultSet set = statement.executeQuery();
			while (set.next()) {
				Language language = new Language();
				language.setLanguage_id(set.getInt("language_id"));
				language.setName(set.getString("name"));
				list.add(language);
			}
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
		return list;
	}

	public int insetFilm(Film film) {
		int i = 0;
		String sql = "insert into film(title,description,language_id) values(?,?,?)";
		connection = ConnectorFactory.getFactory().getConnection();
		try {
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			statement.setString(1, film.getTitle());
			statement.setString(2, film.getDescription());
			statement.setInt(3, film.getLanguage_id());
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
	}
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

