package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Customer;
import com.service.UserService;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	HttpSession session = null;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		response.setContentType("text/html");
//		response.setCharacterEncoding("UTF-8");
		doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("-------servlet-----------");
		RequestDispatcher rd = null;

//		response.setContentType("text/html");
//		response.setCharacterEncoding("UTF-8");
		
		Customer user = new Customer(); 
		String username = request.getParameter("username");
		System.out.println(username);
		if (username != null && !"".equals(username)) {
			System.out.println("-------servlet-----------");
			user = new UserService().getuser(username);
			System.out.println(user.getFirst_name() + "sadfgsdfgsdfcgv");
			System.out.println(user != null);
			if(user != null && user.getFirst_name()!=null && !"".equals(user.getFirst_name())){
				session = request.getSession();
				session.setAttribute("username", user.getFirst_name());
				//response.sendRedirect("welcome.jsp"); //重定向
				//response.setHeader("Refresh", "2;welcome.jsp");//重定向
				//转发
				String path = request.getContextPath() + "/logoutServlet"; 
				request.setAttribute("msg", "登录成功，欢迎你:" + user.getFirst_name() + "<a href=" + path + ">登出</a>");
				rd = request.getRequestDispatcher("/welcome.jsp");
				rd.forward(request, response);
				
			}else {
				String path = request.getContextPath() + "/login.jsp"; 
				request.setAttribute("msg", "密码或者账号错误，请返回填写(系统将于5秒后返回，你也可以点次<a href=" + path + ">登录</a>)");
				response.setHeader("Refresh", "5;login.jsp");
				rd = request.getRequestDispatcher("/error.jsp");
				rd.forward(request, response);
			}
		}else {
			String path = request.getContextPath() + "/login.jsp"; 
			request.setAttribute("msg", "密码或者账号为空，请返回填写(系统将于5秒后返回，你也可以点次<a href=" + path + ">登录</a>)");
			response.setHeader("Refresh", "5;login.jsp");
			rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}
		
	}

}
