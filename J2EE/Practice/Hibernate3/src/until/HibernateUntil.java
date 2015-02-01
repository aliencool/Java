package until;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUntil {
private HibernateUntil(){}
	
	private static Session session=null;

	public static Session getSession() {
		Configuration configuration=new Configuration();
		 //≤È’“hbm
   	 	configuration.configure();
		SessionFactory sessionFactory=configuration.buildSessionFactory();
		session=sessionFactory.openSession();
		return session;
	}

}
