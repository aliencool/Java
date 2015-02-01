package com.execute;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.localhost.Factory.Shop_Factory;
import com.localhost.Interface.Shop_cr;
/*����ģʽ
 * ��ִ̬���ض�������ض�����
 * �ô���Ϊ���ǹ�����������
 * */
public class Content {
	private static Shop_Factory shopFactory;
	private static Shop_cr shop_ab;
	private static Proxy proxy=new Proxy();
	
	public  static void execute(String className,HttpSession session,HttpServletRequest request,HttpServletResponse response)
	{
		shopFactory=proxy.createInstanceof(className);
		shop_ab=shopFactory.createShop_ab();
		shop_ab.execute_shopcontrol(session,request,response);
	}
	
}
