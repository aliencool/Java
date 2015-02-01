package Test;
import java.util.Date;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.courtier.Until.Get_Session;
import cn.courtier.Until.Select_Condition;
import cn.courtier.Until.Select_Enum;
import cn.courtier.po.Bloguser;
import cn.courtier.po.MessageBox;
import cn.courtier.user.Im.User_Service;

public class Snippet {
	
	
	public static void main(String[] args) {
	ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
	
	Get_Session factory=(Get_Session) applicationContext.getBean("session_All");
	Transaction transaction=factory.getSession().beginTransaction();
//	Query bloguser=factory.getSession().createQuery("select new cn.courtier.ActionBean.ActionMessageBox" +
//				"(m.m_Id,m.u_Id.u_Name,m.u_Type,m.u_Id.u_Pic,m.reply_Time,m.reply_Content,m.replyStatus) from MessageBox m");
//	System.out.println(bloguser.list());
//	
//	
	
	
	Query query= factory.getSession().createQuery("from Bloguser where u_Name=:name and u_Password=:password");
	query.setParameter("name", "aa11");
	query.setParameter("password", "aa123");
	System.out.println("list:"+query.list());
	
	
	
	
	
	
	
	
	
	
	
	
//	for(int i=1;i<30;i++){
//		MessageBox messageBox=new MessageBox();
//		messageBox.setReply_Content("²âÊÔ"+i);
//		messageBox.setU_Type(0);
//		messageBox.setReply_Status(0);
//		messageBox.setU_Id(bloguser);
//		factory.getSession().save(messageBox);
//	}
//	transaction.commit();
	}
	
	
	
	
}

