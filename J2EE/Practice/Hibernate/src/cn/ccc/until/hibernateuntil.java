package cn.ccc.until;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/* 2014年4月12日16:32:27
 * 此类是工具类
 * 
 * */

public final class hibernateuntil {
    private static Session s=null; 
	private hibernateuntil(){}
     
	/*初始化必须马上加载*/
     static{
    	 //把xml加载进config中
    	 Configuration configuration=new Configuration();
    	 //查找hbm
    	 configuration.configure();
    	 //创造工厂
    	 SessionFactory sessionFactory=configuration.buildSessionFactory();
    	 //打开session 变成持久状态
    	 s=sessionFactory.openSession();
     }
     
     /*返回*/
	public static Session getS() {
		return s;
	}
     
     
}
