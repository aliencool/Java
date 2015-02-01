package com.myFilter;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MultiFilter implements Filter {
	private FilterConfig filterConfig;
	private String msg="param";
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		Vector<String> vector=new Vector<String>(); 
		
		if((arg0.getParameter("param")==null)||(arg0.getParameter("param").length()==0))
		{
			//把这个容器设置为全局共享
			System.out.println(12);
			this.filterConfig.getServletContext().setAttribute("result", vector);
		}
		else
		{
			//得到全局变量
			Vector<String> vec=(Vector<String>)this.filterConfig.getServletContext().getAttribute("result");
			
			if(vec.size()==0)
			{
				vec.add(arg0.getParameter(msg));
			}
			
			vec.add("*");
			vec.add(this.filterConfig.getInitParameter("multi"));
			this.filterConfig.getServletContext().setAttribute("result", vec);
		}
		arg2.doFilter(arg0, arg1);
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		this.filterConfig=arg0;
	}
	
}
