package com.control.page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.localhost.Interface.Shop_cr;

public class search_enterControlServlet extends Shop_cr{

	@Override
	public void execute_shopcontrol(HttpSession Session,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		if(searchControlServlet.serch_ve.size()>0)
		{
			//得到选择的所有对象
			Session.setAttribute("Search_Info",searchControlServlet.serch_ve);
			GotoUrl("/search.jsp",request,response);
		}
	}

}
