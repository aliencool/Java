package com.control.page;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Bean.DAOBean;
import com.localhost.Factory.Shop_Factory;
import com.localhost.Interface.Shop_cr;

public class outControlServlet  extends Shop_cr{

	@Override
	public void execute_shopcontrol(HttpSession Session,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		//…Ë÷√ ß–ß
		Cookie killMyCookie = new Cookie("userinfo", null);
		 killMyCookie.setMaxAge(0);
		 killMyCookie.setPath("/ZH_2");
		 response.addCookie(killMyCookie);
	    
	    GotoUrl("/index.jsp", request, response);
	}


}
