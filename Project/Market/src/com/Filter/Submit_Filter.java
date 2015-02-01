package com.Filter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Bean.DAOBean;
import com.Bean.ShopBean;
import com.Model.ShopDBBean;
import com.localhost.Factory.DAOFACTORY;

public class Submit_Filter implements Filter{

	private ShopDBBean shopDBBean=null;
	private ServletContext context=null;
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		//ÿ�ζ��ȼ�����Ʒ
		//���ϼ���������Ʒ��Ϣ
		Collection<ShopBean> collection=shopDBBean.shopBeans(1);
		context.setAttribute("All_Info",collection);

		//ת��
		HttpServletRequest httpServletRequest=(HttpServletRequest)request;
		HttpServletResponse httpServletResponse=(HttpServletResponse)response;
		//����session
		HttpSession session=httpServletRequest.getSession();
		//���ñ��
		boolean flag=false;
		//����λ��
		int place=0;
		//�õ����е�cookie
		Cookie[] cookie=((HttpServletRequest)request).getCookies();
		//����Bean
		DAOBean daobean=new DAOBean();
		//����
		if(cookie!=null&&cookie.length!=0)
		{
			for (int i = 0; i < cookie.length; i++) {
				String cook_name=cookie[i].getName();
				if(cook_name.equals("userinfo"))
				{
					flag=true;
					place=i;
				}
			}

			if(flag)
			{
				//�õ�username=xxx password=xxxxx
				String[] All_msg=cookie[place].getValue().split("&");
				//�ж��û�
				for (int j = 0; j < All_msg.length; j++) {
					String[] Single_name=All_msg[j].split("=");
					if(Single_name[0].equals("username"))
					{
						
						daobean.setUser(Single_name[1]);
						
					}
					if(Single_name[0].equals("password"))
					{
						daobean.setPassword(Single_name[1]);
					}
				}
				daobean.setTime_Start(Time_message());
				if(DAOFACTORY.getInstanceof().Cheack_user(daobean))
				{
					//Ϊ�˵õ�ҳ����ȷ��
					session.setAttribute("user", daobean);
					chain.doFilter(request, response);
					return;
				}
			}
			else
			{
				//�ͱ������ο͵�¼
				daobean.setUser("Visitor");
				daobean.setTime_Start(Time_message());
				session.setAttribute("user", daobean);
				chain.doFilter(request, response);
				return;
			}
			
		}
		else
		{
				//�ͱ������ο͵�¼
				daobean.setUser("Visitor");
				daobean.setTime_Start(Time_message());
				session.setAttribute("user", daobean);
				chain.doFilter(request, response);
				return;
				
		}
		
	}
	//����ʱ��
	public String Time_message()
	{
		String time="";
		Calendar  calendar=Calendar.getInstance();
		int hour=calendar.get(Calendar.HOUR_OF_DAY);
		
		if(hour>=0&&hour<=12)
		{
			time="���Ϻ�!";
		}
		else if(hour>=13&&hour<=18)	
		{
			time="�����!";
		}
		else if(hour>=19&&hour<=24)
		{
			time="���Ϻ�!";
		}
		
		int [] month={0,7,1,2,3,4,5,6};
		int select=month[calendar.get(Calendar.DAY_OF_WEEK)];
		switch(select)
		{
			case 1:
				time+="����������һ,����Ŷ��";
			break;
			case 2:
				time+="���������ڶ�,����Ŭ����";
			break;
			case 3:
				time+="������������,���Ͼ�Ҫ��ĩ�ˣ�";
			break;
			case 4:
				time+="������������,�ټ��;���ĩ��";
			break;
			case 5:
				time+="������������,�������ĩ��!";
			break;
			case 6:
				time+="������������,��ĩҪ��ʲô�أ�";
			break;
			case 7:
				time+="������������,��ĩ���һ��!";
			break;
		}
		return time;
		
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
	 shopDBBean=new ShopDBBean();
	 context=filterConfig.getServletContext();
	}

}
