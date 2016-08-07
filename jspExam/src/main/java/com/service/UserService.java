package com.service;

import java.util.ArrayList;
import java.util.List;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.entity.Customer;
import com.entity.Film;
import com.entity.Language;

public class UserService {
	
	public Customer getuser(String username){
		System.out.println("-------service-----------");
	UserDao userDao = new UserDaoImpl();
	Customer user = userDao.gerUser(username);
	return user;
	}
	
	public List<Film> getFilms(int start,int end){
		UserDao userDao = new UserDaoImpl();
		List<Film> list = new ArrayList<Film>();
		list = userDao.getFilms(start, end);
		return list;
	}
	public List<Language> getLanguages() {
		UserDao userDao = new UserDaoImpl();
		List<Language> list = new ArrayList<Language>();
		list = userDao.getLanguages();
		return list;
	}
	public int insertFilm(Film film){
		UserDao userDao = new UserDaoImpl();
		int numb = userDao.insetFilm(film);
		return numb;
	}
	/*public int insert(UserEntity user){
		int i = 0;
		UserDao userDao = new UserDaoImpl();
		i = userDao.insert(user);
	
		return i;	
	}*/
}
