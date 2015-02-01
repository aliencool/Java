package com.control.person;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Bean.DAOBean;
import com.localhost.Factory.DAOFACTORY;
import com.localhost.Interface.Shop_cr;

public class Check_passControlServlet extends Shop_cr{
	private DAOBean bean=null;
	private PrintWriter out=null;
	@Override
	public void execute_shopcontrol(HttpSession Session,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//如果,密码与当前不想等
		if(bean!=null)
		{
			bean=null;
		}
		bean=DAOFACTORY.getInstanceof().Check_ALL(request.getParameter("user"));
		if(!(request.getParameter("password").equals(bean.getPassword())))
		{
			
			out.println(0);
			out.flush();
			out.close();
		}else
		{
			out.println(1);
			out.flush();
			out.close();
		}
	}
	

}
