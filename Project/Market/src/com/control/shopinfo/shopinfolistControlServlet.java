package com.control.shopinfo;

import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Bean.ShopBean;
import com.Bean.ShopMessageBean;
import com.localhost.Factory.DAOFACTORY;
import com.localhost.Interface.Shop_cr;

public class shopinfolistControlServlet extends Shop_cr{

	/**
	 * �û���ȡҳ���������Ϣ
	 * */
	@Override
	public void execute_shopcontrol(HttpSession Session,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String id=request.getParameter("shopid");
		//�ȼ�
		int All=0;
		//���ҳ���������
		int Page_count=0;
		//�õ���ǰ�������Ϣ
		ShopBean shopBean=DAOFACTORY.getInstanceofshop().SelectId(Integer.parseInt(id));
		//�����Ա��ڱ���
		Session.setAttribute("shopinfo", shopBean);
	
		//�õ��������ۺ͵ȼ�
		//��ȡ����
		Collection<ShopMessageBean> shopMessageBeans=DAOFACTORY.getInstanceofshop().selec_shopmessage(Integer.parseInt(id));
	
		//�鵽ҳ���в���ʾ
		if(shopMessageBeans.size()!=0)
		{
			//�õ�������
			Page_count=shopMessageBeans.size();
			Session.setAttribute("show_mes", shopMessageBeans);
			//�õ��ȼ�
			int level=0;
			Iterator<ShopMessageBean> iterator=shopMessageBeans.iterator();
			while(iterator.hasNext())
			{
				ShopMessageBean messageBean=iterator.next();
				level+=messageBean.getLevel();
			}
			//����Ϊ����
			All=level/shopMessageBeans.size();
			
		}
		Session.setAttribute("LEVEL", All);
		Session.setAttribute("count", Page_count);
		GotoUrl("/ShopInfo.jsp",request,response);
	}

}
