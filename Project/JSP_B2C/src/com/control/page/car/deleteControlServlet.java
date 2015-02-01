package com.control.page.car;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Bean.ShopCarBean;
import com.localhost.Interface.Shop_cr;

public class deleteControlServlet extends Shop_cr{
	
	@Override
	public void execute_shopcontrol(HttpSession Session,
			HttpServletRequest request, HttpServletResponse response) {
		//得到购物车
		ShopCarBean carBean=(ShopCarBean)Session.getAttribute("car");
		
		int id=Integer.parseInt(request.getParameter("id"));
		
		carBean.deletecar(id);
	}
	

}
