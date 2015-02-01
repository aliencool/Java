package com.control.person;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Bean.DAOBean;
import com.localhost.Factory.DAOFACTORY;
import com.localhost.Interface.Shop_cr;

public class registercontrolServlet  extends Shop_cr{

	/**
	 * 注册控制器
	 * */
	@Override
	public void execute_shopcontrol(HttpSession Session,
			HttpServletRequest request, HttpServletResponse response) {
		DAOBean bean=new DAOBean();
   	 	bean.setUser(request.getParameter("firstname"));
   	 	bean.setIp(request.getRemoteAddr());
   	 	bean.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
   	 	bean.setPassword(request.getParameter("password"));
   	 	bean.setemail(request.getParameter("email"));
   	 	bean.setPhone(request.getParameter("telephone"));
   	 	bean.setAddress(request.getParameter("address_1"));
   	 	bean.setCity(request.getParameter("city"));
   	 	bean.setCountry(request.getParameter("country_id"));
   		if(DAOFACTORY.getInstanceof().Insert_user(bean))
   	 	{
   			//注册成功更改seesion
   			Session.setAttribute("user", bean);
   			GotoUrl("/Person_Info.jsp",request,response);
   	 	}
	}

}
