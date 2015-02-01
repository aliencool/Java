package cn.courtier.Until;



import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

/**
 * @�๦��˵�����õ��������ݿ��ʵ��Seesion
 * @���޸��ߣ�
 * @�޸����ڣ�
 * @˵����
 * @��˾���ƣ�
 * @���ߣ�Administrator
 * @����ʱ�䣺2014-6-8 ����07:52:23
 * @�汾��V1.0
 */
public class Get_Session  {
	@Resource(name="sessionFactory")
	private  SessionFactory factory;
	
	
	private  ThreadLocal<Session> local = new ThreadLocal<Session> ();

	/**
	 * ��������˵��:����һ��session,ʹ�ñ����̣߳����ɿ�¡����֤��ȫ��
	 * Administrator  2014-6-8
	 * �޸�������:
	 * �޸�����:
	 * �޸�����:
	 * @������ @return    
	 * @return Session   
	 * @throws
	 */
	public  Session getSession() {
	
		Session session = local.get();
		
		if(session == null)
		{
			session = factory.openSession();
			
			local.set(session);
			
			return session;
		}
		else
		{
			session = local.get();
			return session;
		}
	}
	 
}
