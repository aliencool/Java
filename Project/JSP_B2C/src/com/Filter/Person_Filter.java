package com.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Bean.DAOBean;


public class Person_Filter implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)arg0;
		HttpServletResponse response=(HttpServletResponse)arg1;
		System.out.println(((DAOBean)request.getSession().getAttribute("user")).getUser().equals("Visitor"));
		if(((DAOBean)request.getSession().getAttribute("user")).getUser().equals("Visitor")||((DAOBean)request.getSession().getAttribute("user")).getUser().equals(""))
		{
			response.sendRedirect("http://172.16.142.98:8080/ZH_2/index.jsp");
			return;
		}
		else
		{
			arg2.doFilter(request, response);
		}
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
}
