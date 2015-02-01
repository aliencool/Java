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
 * ģ�巽��:
 * */
public abstract class Shop_cr {
	     /**
		 * @param url:��ַ
		 * @param request,response:����ȥ�ض�����������Ӧ
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
		 * Title:����ʱ��
		 * */
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

		/**
		 * ���า�Ƿ���
		 * @param session
		 * @param request
		 * @param response
		 * */
		public  void execute_shopcontrol(HttpSession Session,HttpServletRequest request,HttpServletResponse response){};
		
	
}
