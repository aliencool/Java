package com.control.page.category;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Bean.ShopBean;
import com.localhost.Factory.DAOFACTORY;
import com.localhost.Interface.Shop_cr;

public class categoryControlServlet extends Shop_cr {
	private Collection<ShopBean> collection=null;
	private String category="";
	@Override
	public void execute_shopcontrol(HttpSession Session,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		//得到分页用原来的字符串
		if(request.getParameter("category")!=null)
		{
			category=request.getParameter("category");
			
		}
		collection = (Collection<ShopBean>) Session.getAttribute("Search_Info");
		//将原来的删除
		if(collection!=null) collection.clear();
		//重新获得数据
		collection=DAOFACTORY.getInstanceofshop().getTotalNavigation(category,Integer.parseInt(request.getParameter("page_count")));
		//再次设置新的数据
		Session.setAttribute("Search_Info",collection);
		//去到新的页面
		GotoUrl("/Nagivation.jsp", request, response);
		
	}

}
