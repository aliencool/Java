package com.control.page;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Bean.ShopBean;
import com.localhost.Factory.DAOFACTORY;
import com.localhost.Interface.Shop_cr;

public class pageControlServlet extends Shop_cr{
	private Collection<ShopBean> collection=null;
	/**
	 * 双重分页
	 * 1:搜索
	 * 2:主页面
	 * */
	@Override
	public void execute_shopcontrol(HttpSession Session,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String other=request.getParameter("search");
		if(other!=null)
		{
			collection=(Collection<ShopBean>) Session.getAttribute("Search_Info");
			//将原来的删除
			if(collection!=null) collection=null;
			//重新获得数据
			collection=DAOFACTORY.getInstanceofshop().SelectKey(searchControlServlet.keyword,Integer.parseInt(request.getParameter("page_count")));//keyword是共享搜索controlservlet
			//再次设置新的数据
			Session.setAttribute("Search_Info",collection);
			//去到新的页面
			GotoUrl("/search.jsp",request,response);
		}
		else
		{
			collection=(Collection<ShopBean>) Session.getAttribute("All_Info");
			//将原来的删除
			if(collection!=null) collection=null;
			//重新获得数据
			collection=DAOFACTORY.getInstanceofshop().shopBeans(Integer.parseInt(request.getParameter("page_count")));
			//再次设置新的数据
			Session.setAttribute("All_Info",collection);
			GotoUrl("/success.jsp",request,response);
		}
	}

}
