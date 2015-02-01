package com.myServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=GBK");//设置返回的
		PrintWriter  out=resp.getWriter();//设置响应的
		out.println("<HTML>");
		out.println("<HEAD><TITLE>MyServlet</TITLE><HEAD>");
		out.println("<BODY bgcolor=\"# ffffff\">");
		out.println("<form method='post' action='ResultServlet'>");//处理的servlet
	
		out.println("Input a num:<input type='text' name='param'/>");
		out.println("<input type=submit value='计算'");
		out.println("</form>");
		out.println("</BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	

}
