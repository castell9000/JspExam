package com.service;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.entity.Customer;

public class UserService {
	
	public Customer getuser(String username){
		System.out.println("-------service-----------");
	UserDao userDao = new UserDaoImpl();
	Customer user = userDao.gerUser(username);
	return user;
	}
	
	/*public int insert(UserEntity user){
		int i = 0;
		UserDao userDao = new UserDaoImpl();
		i = userDao.insert(user);
	
		return i;	
	}*/
}
