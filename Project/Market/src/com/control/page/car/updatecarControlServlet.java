package com.control.page.car;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Bean.ShopCarBean;
import com.Bean.ShopItemBean;
import com.localhost.Factory.DAOFACTORY;
import com.localhost.Interface.Shop_cr;

public class updatecarControlServlet extends Shop_cr {
	/**
	 * 更新购物车的价格和数量
	 * */
	@Override
	public void execute_shopcontrol(HttpSession Session,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		//商品的id
		int id=Integer.parseInt(request.getParameter("id"));
		//商品的个数
		int quantity=Integer.parseInt(request.getParameter("num"));
		//得到个别购物车
		ShopCarBean carBean=(ShopCarBean)Session.getAttribute("car");
		
		//输出到客户端
		PrintWriter printWriter=null;
		try {
			printWriter = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(DAOFACTORY.getInstanceofshop().isEnogh(id, quantity))
		{
			ShopItemBean shopItemBean=carBean.Amount(id, quantity);//为了得到价钱
			printWriter.println(shopItemBean.total_price()+"|"+carBean.total_shoplist());
			System.out.println(shopItemBean.total_price()+"|"+carBean.total_shoplist());
			printWriter.flush();
			printWriter.close();
		}
		else
		{
			printWriter.println(0);
			printWriter.flush();
			printWriter.close();
		}
	}

}
