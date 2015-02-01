package com.localhost.Interface;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.localhost.Factory.Shop_Factory;
/**
 * 模板方法:
 * */
public abstract class Shop_cr {
	     /**
		 * @param url:地址
		 * @param request,response:带过去特定的请求与响应
		 * */ 
		public void GotoUrl(String url,HttpServletRequest request,HttpServletResponse response)
		{
				RequestDispatcher requestDispatcher=request.getRequestDispatcher(url);
				try {
					requestDispatcher.forward(request, response);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		/**
		 * Title:设置时间
		 * */
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

		/**
		 * 子类覆盖方法
		 * @param session
		 * @param request
		 * @param response
		 * */
		public  void execute_shopcontrol(HttpSession Session,HttpServletRequest request,HttpServletResponse response){};
		
	
}
