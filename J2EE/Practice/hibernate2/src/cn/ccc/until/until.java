package cn.ccc.until;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class until {
	private until(){}
	
	private static Session session=null;

	public static Session getSession() {
		Configuration configuration=new Configuration();
		 //����hbm
   	 	configuration.configure();
		SessionFactory sessionFactory=configuration.buildSessionFactory();
		session=sessionFactory.openSession();
		return session;
	}

}
