package org.sise.control;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.sise.Dao.DB_Factory;
import org.sise.Dao.Dao_Interface;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.sun.net.httpserver.Filter;

//��������ÿ��������ҳ���ȼ��ؽ�����
public class Action_Int implements javax.servlet.Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//1��װ������
		Dao_Interface daoInterface=DB_Factory.getInstance();
		//2:������session	
		HttpServletRequest req=(HttpServletRequest)request;
		HttpSession session=req.getSession();
		//3:����session
		session.setAttribute("Message", daoInterface.All_search_four());
		//��ת
		chain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	

}
