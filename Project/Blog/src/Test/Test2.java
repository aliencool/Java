package Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import net.sf.json.JSONArray;

import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.courtier.Until.Get_Session;
import cn.courtier.po.Bloguser;
import cn.courtier.po.Send_Message;

public class Test2 {
	public static void main(String[] args) {
		
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Get_Session factory=(Get_Session) applicationContext.getBean("session_All");

		Transaction transaction=factory.getSession().beginTransaction();
		
		
		
		System.out.println(factory.getSession().createQuery("select save_M.u_Pic from Send_Message  where save_M.u_Id=2").list());
		
	
		
		
		
		
//		for(int i=1;i<=15;i++)
//		{
//			Send_Message message=new Send_Message();
//			message.setFlag(0);
//			message.setMsg_Content("ceshi"+i);
//			message.setSave_M(bloguser);
//			message.setSend_Time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
//			factory.getSession().save(message);
//		}
//		
//		transaction.commit();
		
		
		
		
		
		
	}
}
