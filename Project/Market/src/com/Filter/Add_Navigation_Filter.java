package com.Filter;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.Bean.NavigationBean;
import com.Model.ShopDBBean;

public class Add_Navigation_Filter implements Filter{
	ServletContext servletContext=null;
	private ShopDBBean shBean;
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		if(this.servletContext.getAttribute("navigation")==null)
		{
			//每个jsp都需要添加导航
			Collection<NavigationBean> collection=shBean.getNavigation();
			
			servletContext.setAttribute("navigation", collection);
		}
		//跳转下一个
		chain.doFilter(request, response);		
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		servletContext=filterConfig.getServletContext();
		shBean=new ShopDBBean();
	}

}
