package com.control.shopinfo;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.View.ChartView;
import com.localhost.Factory.DAOFACTORY;
import com.localhost.Interface.Shop_cr;

public class showcharteControlServlet extends Shop_cr{
	
	/**
	 * ��ʾͼ����Ϣ
	 * */
	@Override
	public void execute_shopcontrol(HttpSession Session,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		//�õ��ܷ���
		String category=request.getParameter("categoryname");
		//�õ�����
		ResultSet resultSet=DAOFACTORY.getInstanceofshop().search_level(category);
		//����ͼ����Ϣ
		try {
			ChartView.Create_View_Chart(resultSet, category, Session, response.getWriter(), request);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GotoUrl("/Chart.jsp",request,response);
		
	}

}
