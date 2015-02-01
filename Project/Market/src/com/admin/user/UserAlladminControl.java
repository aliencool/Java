package com.admin.user;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Bean.DAOBean;
import com.Bean.ShopBean;
import com.Model.Shop_adminDBBean;
import com.localhost.Factory.DAOFACTORY;
import com.localhost.Interface.Shop_cr;

public class UserAlladminControl extends Shop_cr{

	@Override
	public void execute_shopcontrol(HttpSession Session,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		//页数
		int page=0;
		if(request.getParameter("page")==null)page=1;
		else page=Integer.parseInt(request.getParameter("page"));
		
		//设置为session
		Collection<DAOBean> daoBeans=DAOFACTORY.getInstanceofshop_admin().UserBeans(page);
		Session.setAttribute("daoBeans", daoBeans);
		Session.setAttribute("count", Shop_adminDBBean.Total_Page);
		//去到新页面
		
		GotoUrl("admin/customs.jsp", request, response);
	}

}
