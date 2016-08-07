package com.dao;


import java.util.List;

import com.entity.Customer;
import com.entity.Film;
import com.entity.Language;

public interface UserDao {
	
	public Customer gerUser(String username);
	public List<Film> getFilms(int i,int numb);
	public List<Language> getLanguages();
	public int insetFilm(Film film);
	
}
