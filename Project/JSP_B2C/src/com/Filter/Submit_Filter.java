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
		
		//每次都先加载商品
		//马上加载所有商品信息
		Collection<ShopBean> collection=shopDBBean.shopBeans(1);
		context.setAttribute("All_Info",collection);

		//转换
		HttpServletRequest httpServletRequest=(HttpServletRequest)request;
		HttpServletResponse httpServletResponse=(HttpServletResponse)response;
		//设置session
		HttpSession session=httpServletRequest.getSession();
		//设置标记
		boolean flag=false;
		//设置位置
		int place=0;
		//得到所有的cookie
		Cookie[] cookie=((HttpServletRequest)request).getCookies();
		//设置Bean
		DAOBean daobean=new DAOBean();
		//遍历
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
				//得到username=xxx password=xxxxx
				String[] All_msg=cookie[place].getValue().split("&");
				//判断用户
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
					//为了得到页面正确性
					session.setAttribute("user", daobean);
					chain.doFilter(request, response);
					return;
				}
			}
			else
			{
				//就表明是游客登录
				daobean.setUser("Visitor");
				daobean.setTime_Start(Time_message());
				session.setAttribute("user", daobean);
				chain.doFilter(request, response);
				return;
			}
			
		}
		else
		{
				//就表明是游客登录
				daobean.setUser("Visitor");
				daobean.setTime_Start(Time_message());
				session.setAttribute("user", daobean);
				chain.doFilter(request, response);
				return;
				
		}
		
	}
	//设置时间
	public String Time_message()
	{
		String time="";
		Calendar  calendar=Calendar.getInstance();
		int hour=calendar.get(Calendar.HOUR_OF_DAY);
		
		if(hour>=0&&hour<=12)
		{
			time="早上好!";
		}
		else if(hour>=13&&hour<=18)	
		{
			time="下午好!";
		}
		else if(hour>=19&&hour<=24)
		{
			time="晚上好!";
		}
		
		int [] month={0,7,1,2,3,4,5,6};
		int select=month[calendar.get(Calendar.DAY_OF_WEEK)];
		switch(select)
		{
			case 1:
				time+="今天是星期一,加油哦！";
			break;
			case 2:
				time+="今天是星期二,继续努力！";
			break;
			case 3:
				time+="今天是星期三,马上就要周末了！";
			break;
			case 4:
				time+="今天是星期四,再加油就周末！";
			break;
			case 5:
				time+="今天是星期五,明天就周末了!";
			break;
			case 6:
				time+="今天是星期六,周末要干什么呢？";
			break;
			case 7:
				time+="今天是星期日,周末最后一天!";
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
