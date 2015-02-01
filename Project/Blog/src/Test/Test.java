package Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.courtier.Interf.Message_Interf;
import cn.courtier.Until.Get_Session;
import cn.courtier.message.Im.Im_Message;
import cn.courtier.po.Bloguser;
import cn.courtier.po.MessageBox;

public class Test {
	public static void main(String[] args) {
		
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Get_Session factory=(Get_Session) applicationContext.getBean("session_All");
		
		Transaction transaction=factory.getSession().beginTransaction();
		
		Message_Interf imMessage= (Message_Interf) applicationContext.getBean("messageService");
		
		Query query=factory.getSession().createQuery("select u_Password from Bloguser where u_id=:name");
		query.setParameter("name", "2");
	System.out.println(query.uniqueResult());
	
	Long long1=new Date().getTime()-Long.parseLong("1402640302696");
	
	System.out.println(long1/1000/60);
	}
}
