package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Customer;
import com.entity.Film;
import com.service.UserService;

public class SearchFilm extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cur = request.getParameter("cur");
		List<Film> filmList = new ArrayList<Film>();
		filmList = new UserService().getFilms(Integer.parseInt(cur)*20, 20);
		/*for (int i = 0; i < filmList.size(); i++) {
			System.out.println(filmList.get(i).getFilm_id() + " " + filmList.get(i).getTitle() );
		}*/
		
		request.setAttribute("filmList", filmList);
		RequestDispatcher rd = request.getRequestDispatcher("/ListFilme.jsp");
	    rd.forward(request, response);
		
	}

}
