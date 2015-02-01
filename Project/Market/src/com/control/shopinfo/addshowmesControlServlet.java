package com.control.shopinfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.localhost.Factory.DAOFACTORY;
import com.localhost.Interface.Shop_cr;

public class addshowmesControlServlet extends Shop_cr{
	
	/**
	 * 添加商品页面的信息
	 * */
	@Override
	public void execute_shopcontrol(HttpSession Session,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		//获取id
		int shop_id=Integer.parseInt(request.getParameter("shopid"));
		//获取用户名的id
		int id=DAOFACTORY.getInstanceof().Cheack_id(request.getParameter("user"));

		//获取等级
		int level=Integer.parseInt(request.getParameter("level"));
		//获取用户评论的内容
		String mesg="";
		try {
			mesg =new String(request.getParameter("msg").getBytes("ISO-8859-1"),"UTF-8");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		System.out.println(mesg);
		//时间
		String time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

		if(DAOFACTORY.getInstanceofshop().insert_shopmessage(shop_id,id,level,mesg,time))
		{
			PrintWriter printWriter;
			try {
				printWriter = response.getWriter();
				printWriter.println("successfuly submit");
				printWriter.flush();
				printWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
