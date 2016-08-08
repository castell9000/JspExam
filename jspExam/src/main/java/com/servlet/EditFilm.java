package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class EditFilm extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Configuration cfg; 
	
	@Override
	public void init() throws ServletException {
		cfg = new Configuration();
        cfg.setServletContextForTemplateLoading(
                getServletContext(), "WEB-INF/templates");
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map root = new HashMap();
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String name = request.getParameter("name");
		root.put("title", title);
		root.put("description", description);
		root.put("name", name);
		Template template = cfg.getTemplate("editFilm.ftl");
		System.out.println(template.getEncoding());
		response.setContentType("text/html; charset=" + template.getEncoding());
		Writer out = response.getWriter();
		try {
            template.process(root, out);
        } catch (TemplateException e) {
            throw new ServletException(
                    "Error while processing FreeMarker template", e);
        }
		
	}

}
