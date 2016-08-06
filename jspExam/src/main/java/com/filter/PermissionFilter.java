package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class PermissionFilter
 */
public class PermissionFilter implements Filter {

    /**
     * Default constructor. 
     */
    public PermissionFilter() {
        
    }

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}


	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("开始执行权限过滤器");
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse rep = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		String username = (String) session.getAttribute("username");
		//System.out.println("session中的username:" + username);
		String servletPath = req.getServletPath();
		RequestDispatcher rd = null;
		if ("/login.jsp".equals(servletPath) ||"/loginServlet".equals(servletPath) ||
				"/index.jsp".equals(servletPath)) {
			chain.doFilter(request, response);
		}else {
			if (username != null && !"".equals(username)) {
				System.out.println("有权限：" + username);
				chain.doFilter(request, response);			
			}else {
				String path = req.getContextPath() + "/login.jsp"; 
				req.setAttribute("msg", "您还没有登录，请返回登录页面登录(系统将于5秒后返回，你也可以点此<a href=" + path + ">登录</a>)");
				rep.setHeader("Refresh", "5;login.jsp");
				rd = req.getRequestDispatcher("/error.jsp");
				rd.forward(req, rep);
			}
		}
		System.out.println("结束执行权限过滤器");
		// pass the request along the filter chain
		//chain.doFilter(request, response);
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		
	}
}
