package com.control.person.update;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Bean.DAOBean;
import com.localhost.Factory.DAOFACTORY;
import com.localhost.Interface.Shop_cr;

public class updatepasControlServlet extends Shop_cr{
	private DAOBean bean=null;
	
	//ÿ�ζ�������������
	public void SelectAll(HttpServletRequest req, HttpServletResponse resp)
	{
		if(bean!=null)
		{
			bean=null;
		}
		bean=DAOFACTORY.getInstanceof().Check_ALL(req.getParameter("user"));
		//����Session
		req.getSession().setAttribute("InfoBean", bean);
		
		GotoUrl("Person_edit/edit_password.jsp",req,resp);
		
	}
	
	
	
	
	
	/**
	 * ��������Ϣ
	 * */
	@Override
	public void execute_shopcontrol(HttpSession Session,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		//���,��Ϊ�ս�ȥ����
		if(request.getParameter("address")!=null&&request.getParameter("city")!=null&&request.getParameter("country")!=null)
		{
			String sql="update register set address='"+request.getParameter("address")+"', city='"+request.getParameter("city")+
			"' ,country='"+request.getParameter("country")+"' where user_n='"+bean.getUser()+"'";
			DAOFACTORY.getInstanceof().update_re(sql);
		}
		SelectAll(request,response);
		GotoUrl("Person_edit/edit_password.jsp",request,response);
	}

}
