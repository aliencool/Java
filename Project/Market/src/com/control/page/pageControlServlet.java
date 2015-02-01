package com.control.page;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Bean.ShopBean;
import com.localhost.Factory.DAOFACTORY;
import com.localhost.Interface.Shop_cr;

public class pageControlServlet extends Shop_cr{
	private Collection<ShopBean> collection=null;
	/**
	 * ˫�ط�ҳ
	 * 1:����
	 * 2:��ҳ��
	 * */
	@Override
	public void execute_shopcontrol(HttpSession Session,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String other=request.getParameter("search");
		if(other!=null)
		{
			collection=(Collection<ShopBean>) Session.getAttribute("Search_Info");
			//��ԭ����ɾ��
			if(collection!=null) collection=null;
			//���»������
			collection=DAOFACTORY.getInstanceofshop().SelectKey(searchControlServlet.keyword,Integer.parseInt(request.getParameter("page_count")));//keyword�ǹ�������controlservlet
			//�ٴ������µ�����
			Session.setAttribute("Search_Info",collection);
			//ȥ���µ�ҳ��
			GotoUrl("/search.jsp",request,response);
		}
		else
		{
			collection=(Collection<ShopBean>) Session.getAttribute("All_Info");
			//��ԭ����ɾ��
			if(collection!=null) collection=null;
			//���»������
			collection=DAOFACTORY.getInstanceofshop().shopBeans(Integer.parseInt(request.getParameter("page_count")));
			//�ٴ������µ�����
			Session.setAttribute("All_Info",collection);
			GotoUrl("/success.jsp",request,response);
		}
	}

}
