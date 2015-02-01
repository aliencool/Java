package com.control.page;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Bean.ShopBean;
import com.localhost.Factory.DAOFACTORY;
import com.localhost.Interface.Shop_cr;

public class searchControlServlet extends Shop_cr{
	public static String keyword="";
	
	//输出到客户端
	private PrintWriter printWriter=null;
	//得到用户search的值
	public static Vector<ShopBean> serch_ve=null;
	
	
	public searchControlServlet() {
		super();
		serch_ve=new Vector<ShopBean>();
	}


	@Override
	public void execute_shopcontrol(HttpSession Session,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		keyword=request.getParameter("keyword");
		if(keyword!="")
		{
			serch_ve=DAOFACTORY.getInstanceofshop().SelectKey(keyword,1);
			try {
				printWriter = response.getWriter();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//分隔
			String msg_spit="";
			if(serch_ve.size()>0)
			{
				for(int i=0;i<serch_ve.size();i++)
				{
					msg_spit=msg_spit+serch_ve.get(i).getShop_name()+"|";
				}
				printWriter.println(msg_spit);
				printWriter.flush();
			}
			else//如果没有数据
			{	
				printWriter.println(404);
				printWriter.flush();
			}
			printWriter.close();
	}

}
}
