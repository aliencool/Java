package com.control.person;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Bean.DAOBean;
import com.localhost.Interface.Shop_cr;

public class check_userControlServlet extends Shop_cr{

	@Override
	/*
	 * ע���ʱ���ж��û����Ƿ����
	 * */
	public void execute_shopcontrol(HttpSession Session,
			HttpServletRequest request, HttpServletResponse response) {
		   //����userBean
		DAOBean daobean=new DAOBean();
		PrintWriter printWriter = null;
		//�����û���
		String user=request.getParameter("user_name");
		//��ӡ
		
		try {
			printWriter = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		daobean.setUser(user);
		System.out.println("user:"+user);
		System.out.println("�ж�Ϊ:"+Check_user_object.check_name(daobean));
		if(Check_user_object.check_name(daobean))
		{
			
			printWriter.println(0);
		}
		else
		{
			printWriter.println(1);
		}
		printWriter.flush();
		printWriter.close();
	}
}

