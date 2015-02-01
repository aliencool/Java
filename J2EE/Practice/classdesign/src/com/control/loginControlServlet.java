package com.control;

import java.io.IOException;

import javax.jms.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.UserBean;


public class loginControlServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserBean daobean=new UserBean();
	    //得到全部的
		daobean.setUsername(req.getParameter("username"));
		daobean.setPassword(req.getParameter("password"));
		req.getSession().setAttribute("user", daobean.getUsername());
		GotoUrl("login_success.jsp",req,resp);
		
	
	
	}
	public void GotoUrl(String url,HttpServletRequest request,HttpServletResponse response)
	{
			RequestDispatcher requestDispatcher=request.getRequestDispatcher(url);
			try {
				requestDispatcher.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	

	
	

}
