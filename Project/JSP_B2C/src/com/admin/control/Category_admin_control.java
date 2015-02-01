package com.admin.control;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Bean.NavigationBean;
import com.Bean.ShopBean;
import com.Bean.ShopCarBean;
import com.Model.ShopDBBean;
import com.execute.Content;

public class Category_admin_control extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Content.execute("com.Factory.admin.production."+req.getParameter("action")+"Production",req.getSession(), req, resp);
	}
	

}
