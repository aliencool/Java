package com.execute;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.localhost.Factory.Shop_Factory;
import com.localhost.Interface.Shop_cr;
/*策略模式
 * 动态执行特定对象的特定方法
 * 让代理为我们工厂创建对象
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
