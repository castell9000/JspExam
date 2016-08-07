package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Film;
import com.service.UserService;

public class AddFilm extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
		
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String language_id = request.getParameter("select");
		Film film = new Film();
		film.setTitle(title);
		film.setDescription(description);
		film.setLanguage_id(Integer.parseInt(language_id));
		int i = new UserService().insertFilm(film);
		if (i >0) {
			System.err.println("新增电影成功");
			out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
			out.println("<HTML>");
			out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
			out.println("  <BODY>");
			out.println("    新增电影成功");
			String path = request.getContextPath() + "/selectLanguage";
			out.println("<b><a href="+path+">返回继续添加</a></b>");
			out.println("</HTML>");
			out.flush();
			out.close();
		}else {
			System.err.println("新增电影失败");
			out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
			out.println("<HTML>");
			out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
			out.println("  <BODY>");
			out.println("    新增电影失败");
			String path = request.getContextPath() + "/selectLanguage";
			out.println("<b><a href="+path+">返回继续添加</a></b>");
			out.println("</HTML>");
			out.flush();
			out.close();
		}
		
	}

}
