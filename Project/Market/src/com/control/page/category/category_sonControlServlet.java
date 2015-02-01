package com.control.page.category;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Bean.ShopBean;
import com.localhost.Factory.DAOFACTORY;
import com.localhost.Interface.Shop_cr;

public class category_sonControlServlet extends Shop_cr {
	private Collection<ShopBean> collection=null;
	private String category_son="";
	private String category_father="";
	@Override
	public void execute_shopcontrol(HttpSession Session,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		//�õ���ҳ��ԭ�����ַ���
		if(request.getParameter("category")!=null)
		{
			//Ϊ�˷�ҳ���´η�ҳֱ����ԭ����
			category_son=request.getParameter("category");
			category_father = request.getParameter("category_father");
		}
		collection = (Collection<ShopBean>) Session.getAttribute("Search_Info");
		//��ԭ����ɾ��
		if(collection!=null) collection.clear();
		//���»������
		collection=DAOFACTORY.getInstanceofshop().getSon_TotalNavigation(category_father,category_son,Integer.parseInt(request.getParameter("page_count")));
		//�ٴ������µ�����
		Session.setAttribute("Search_Info",collection);
		//ȥ����ҳ��
		GotoUrl("/Nagivation_son.jsp", request, response);
		
	}

}
