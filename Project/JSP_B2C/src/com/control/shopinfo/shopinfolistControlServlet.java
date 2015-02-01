package com.control.shopinfo;

import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Bean.ShopBean;
import com.Bean.ShopMessageBean;
import com.localhost.Factory.DAOFACTORY;
import com.localhost.Interface.Shop_cr;

public class shopinfolistControlServlet extends Shop_cr{

	/**
	 * 用户获取页面的相信信息
	 * */
	@Override
	public void execute_shopcontrol(HttpSession Session,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String id=request.getParameter("shopid");
		//等级
		int All=0;
		//这个页面的评论数
		int Page_count=0;
		//得到当前对象的信息
		ShopBean shopBean=DAOFACTORY.getInstanceofshop().SelectId(Integer.parseInt(id));
		//保存以便于遍历
		Session.setAttribute("shopinfo", shopBean);
	
		//得到所有评论和等级
		//获取集合
		Collection<ShopMessageBean> shopMessageBeans=DAOFACTORY.getInstanceofshop().selec_shopmessage(Integer.parseInt(id));
	
		//查到页面有才显示
		if(shopMessageBeans.size()!=0)
		{
			//得到评论数
			Page_count=shopMessageBeans.size();
			Session.setAttribute("show_mes", shopMessageBeans);
			//得到等级
			int level=0;
			Iterator<ShopMessageBean> iterator=shopMessageBeans.iterator();
			while(iterator.hasNext())
			{
				ShopMessageBean messageBean=iterator.next();
				level+=messageBean.getLevel();
			}
			//设置为变量
			All=level/shopMessageBeans.size();
			
		}
		Session.setAttribute("LEVEL", All);
		Session.setAttribute("count", Page_count);
		GotoUrl("/ShopInfo.jsp",request,response);
	}

}
