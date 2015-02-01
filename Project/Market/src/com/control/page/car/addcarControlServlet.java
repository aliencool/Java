package com.control.page.car;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Bean.ShopBean;
import com.Bean.ShopCarBean;
import com.localhost.Factory.DAOFACTORY;
import com.localhost.Interface.Shop_cr;

public class addcarControlServlet extends Shop_cr{
	public addcarControlServlet() {
		super();
	}

	@Override
	public void execute_shopcontrol(HttpSession Session,
			HttpServletRequest request, HttpServletResponse response) {
		PrintWriter out=null;
		try {
			
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//每个session中拿
		ShopCarBean shopCarBean=(ShopCarBean) Session.getAttribute("car");
		System.out.println(shopCarBean);
		//个数
		int count;
		int id=Integer.parseInt(request.getParameter("id"));
		//每次保持只有一个加入
		if(request.getParameter("count")==null)count=1;
		else count=Integer.parseInt(request.getParameter("count"));//设置个数，只要是信息
		if(DAOFACTORY.getInstanceofshop().isEnogh(id, count))
		{
			//把详细的用户选择的信息加入购物车
			ShopBean shopBean=DAOFACTORY.getInstanceofshop().SelectId(id);
			//并设置购物车
			Session.setAttribute("car", shopCarBean);
			//加入一个购物
			System.out.println(shopCarBean.addcar(id, shopBean));
			//得到后设置当前的数量
			shopCarBean.Amount(id, count);
			//向用户输出您加入购物车的数量
			out.println("You have already add  "+shopCarBean.getItemCount()+"  to car");
			out.flush();
			out.close();
		}
	}
	
}
