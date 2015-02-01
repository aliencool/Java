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
		//ҳ��
		int page=0;
		if(request.getParameter("page")==null)page=1;
		else page=Integer.parseInt(request.getParameter("page"));
		
		//����Ϊsession
		Collection<DAOBean> daoBeans=DAOFACTORY.getInstanceofshop_admin().UserBeans(page);
		Session.setAttribute("daoBeans", daoBeans);
		Session.setAttribute("count", Shop_adminDBBean.Total_Page);
		//ȥ����ҳ��
		
		GotoUrl("admin/customs.jsp", request, response);
	}

}
