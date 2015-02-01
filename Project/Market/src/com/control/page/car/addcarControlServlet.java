package com.control.page.car;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Bean.ShopBean;
import com.Bean.ShopCarBean;
import com.localhost.Factory.DAOFACTORY;
import com.localhost.Interface.Shop_cr;

public class addcarControlServlet extends Shop_cr{
	public addcarControlServlet() {
		super();
	}

	@Override
	public void execute_shopcontrol(HttpSession Session,
			HttpServletRequest request, HttpServletResponse response) {
		PrintWriter out=null;
		try {
			
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//ÿ��session����
		ShopCarBean shopCarBean=(ShopCarBean) Session.getAttribute("car");
		System.out.println(shopCarBean);
		//����
		int count;
		int id=Integer.parseInt(request.getParameter("id"));
		//ÿ�α���ֻ��һ������
		if(request.getParameter("count")==null)count=1;
		else count=Integer.parseInt(request.getParameter("count"));//���ø�����ֻҪ����Ϣ
		if(DAOFACTORY.getInstanceofshop().isEnogh(id, count))
		{
			//����ϸ���û�ѡ�����Ϣ���빺�ﳵ
			ShopBean shopBean=DAOFACTORY.getInstanceofshop().SelectId(id);
			//�����ù��ﳵ
			Session.setAttribute("car", shopCarBean);
			//����һ������
			System.out.println(shopCarBean.addcar(id, shopBean));
			//�õ������õ�ǰ������
			shopCarBean.Amount(id, count);
			//���û���������빺�ﳵ������
			out.println("You have already add  "+shopCarBean.getItemCount()+"  to car");
			out.flush();
			out.close();
		}
	}
	
}
