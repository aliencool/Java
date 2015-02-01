package com.control.page.car;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Bean.ShopCarBean;
import com.localhost.Interface.Shop_cr;

public class firstControlServlet extends Shop_cr{
	/**
	 * ���ع��ﳵ
	 * */
	@Override
	public void execute_shopcontrol(HttpSession Session,
			HttpServletRequest request, HttpServletResponse response) {
		ShopCarBean carBean=(ShopCarBean)Session.getAttribute("car");
		//��Ϣһ���ڼ���
		try {
			Thread.sleep(50);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//û����Ʒ�Ͳ�����
		if(carBean!=null)
		{
			//������ͻ���
			PrintWriter printWriter=null;
			try {
				printWriter = response.getWriter();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			printWriter.println(carBean.total_shoplist());
			printWriter.flush();
			printWriter.close();
		}
	}

}
