package cn.ccc.until;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/* 2014��4��12��16:32:27
 * �����ǹ�����
 * 
 * */

public final class hibernateuntil {
    private static Session s=null; 
	private hibernateuntil(){}
     
	/*��ʼ���������ϼ���*/
     static{
    	 //��xml���ؽ�config��
    	 Configuration configuration=new Configuration();
    	 //����hbm
    	 configuration.configure();
    	 //���칤��
    	 SessionFactory sessionFactory=configuration.buildSessionFactory();
    	 //��session ��ɳ־�״̬
    	 s=sessionFactory.openSession();
     }
     
     /*����*/
	public static Session getS() {
		return s;
	}
     
     
}
