package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class EnclodingFilter
 */
public class EnclodingFilter implements Filter {
	private String encloding = null;

    /**
     * Default constructor. 
     */
    public EnclodingFilter() {
        System.out.println("编码过滤器构造函数");
    }

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		encloding = fConfig.getInitParameter("encloding");
		if (encloding == null) {
			throw new ServletException("字符集编码为空");
		}
		System.out.println("初始化编码过滤器");
	}
	
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("开始执行过滤器");
		if (!encloding.equals(request.getCharacterEncoding())) {
			request.setCharacterEncoding(encloding);
		}
		response.setCharacterEncoding(encloding);
		// pass the request along the filter chain
		System.out.println("执行完成过滤器");
		chain.doFilter(request, response);
	}


	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

}
