package com.admin.page;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Bean.ShopBean;
import com.Model.Shop_adminDBBean;
import com.localhost.Factory.DAOFACTORY;
import com.localhost.Interface.Shop_cr;

public class shopadminlistControl extends Shop_cr{

	@Override
	public void execute_shopcontrol(HttpSession Session,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		//ҳ��
		int page=0;
		if(request.getParameter("page")==null)page=1;
		else page=Integer.parseInt(request.getParameter("page"));
		
		//����Ϊsession
		Collection<ShopBean> admin_shopbean=DAOFACTORY.getInstanceofshop_admin().shopBeans(page);
		Session.setAttribute("adminshoplist", admin_shopbean);
		Session.setAttribute("count", Shop_adminDBBean.Total_Page);
		//ȥ����ҳ��
		
		GotoUrl("admin/Updateshop.jsp", request, response);
	}

}
