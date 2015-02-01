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
 * @类功能说明：得到操作数据库的实体Seesion
 * @类修改者：
 * @修改日期：
 * @说明：
 * @公司名称：
 * @作者：Administrator
 * @创建时间：2014-6-8 上午07:52:23
 * @版本：V1.0
 */
public class Get_Session  {
	@Resource(name="sessionFactory")
	private  SessionFactory factory;
	
	
	private  ThreadLocal<Session> local = new ThreadLocal<Session> ();

	/**
	 * 函数功能说明:生成一个session,使用本地线程，生成克隆，保证安全性
	 * Administrator  2014-6-8
	 * 修改者名字:
	 * 修改日期:
	 * 修改内容:
	 * @参数： @return    
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
