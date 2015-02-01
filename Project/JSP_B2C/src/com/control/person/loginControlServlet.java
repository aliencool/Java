package com.control.person;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Bean.DAOBean;
import com.localhost.Interface.Shop_cr;

public class loginControlServlet extends Shop_cr{

	/**
	 *登陆控制器
	 * */
	@Override
	public void execute_shopcontrol(HttpSession Session,
			HttpServletRequest request, HttpServletResponse response) {
		 //设置userBean
		DAOBean daobean=new DAOBean();
	    //得到全部的
		daobean.setUser(request.getParameter("user"));
		daobean.setPassword(request.getParameter("password"));
		//设置时间加入提示
		daobean.setTime_Start(Time_message());
		
		//加入是免登陆
		StringBuilder sb=new StringBuilder();
		sb.append("username="+daobean.getUser());
		sb.append("&password="+daobean.getPassword());
		if(Check_user_object.check_name(daobean))
		{
			Cookie cookies=new Cookie("userinfo", sb.toString());
			cookies.setMaxAge(1800);//设置最大时间
			cookies.setPath("/ZH_2");
			response.addCookie(cookies);
			
			Session.setAttribute("user", daobean);
			GotoUrl("/success.jsp",request,response);
			
		}
		else
		{
			GotoUrl("/WEB-INF/index.jsp",request,response);
		}		
	}
	
	

}
