package com.control.person;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Bean.DAOBean;
import com.localhost.Interface.Shop_cr;

public class loginControlServlet extends Shop_cr{

	/**
	 *��½������
	 * */
	@Override
	public void execute_shopcontrol(HttpSession Session,
			HttpServletRequest request, HttpServletResponse response) {
		 //����userBean
		DAOBean daobean=new DAOBean();
	    //�õ�ȫ����
		daobean.setUser(request.getParameter("user"));
		daobean.setPassword(request.getParameter("password"));
		//����ʱ�������ʾ
		daobean.setTime_Start(Time_message());
		
		//���������½
		StringBuilder sb=new StringBuilder();
		sb.append("username="+daobean.getUser());
		sb.append("&password="+daobean.getPassword());
		if(Check_user_object.check_name(daobean))
		{
			Cookie cookies=new Cookie("userinfo", sb.toString());
			cookies.setMaxAge(1800);//�������ʱ��
			cookies.setPath("/ZH_2");
			response.addCookie(cookies);
			
			Session.setAttribute("user", daobean);
			GotoUrl("/success.jsp",request,response);
			
		}
		else
		{
			GotoUrl("/WEB-INF/index.jsp",request,response);
		}		
	}
	
	

}
