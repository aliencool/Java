package Test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.courtier.Until.Get_Session;
import cn.courtier.po.BlogContent;
import cn.courtier.po.Category;
import cn.courtier.po.Recommend;

public class SessionText {

	/**
	 * ��������˵��:
	 * Administrator  2014-6-8
	 * �޸�������:
	 * �޸�����:
	 * �޸�����:
	 * @������ @param args    
	 * @return void   
	 * @throws
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
	System.out.println(12399);
		SessionFactory factory=(SessionFactory) applicationContext.getBean("sessionFactory");
		 Session session=factory.openSession();
			
		 Transaction transaction=session.beginTransaction();
		 Category category=new Category();
		 category.setC_Name("����");
		 session.save(category);
		 
		 Category category1=new Category();
		 category1.setC_Name("����");
		 session.save(category1);
		 
		 Category category2=new Category();
		 category2.setC_Name("���");
		 session.save(category2);
		 
		 Category category3=new Category();
		 category3.setC_Name("����");
		 session.save(category3);
		 
		 for (int i = 0; i < 100; i++) {
			 BlogContent blog=new BlogContent();
			 blog.setAward(0);
			 if(i%2==0)
			 {
				 blog.setCategory(category);
			 } if(i%4==0)
			 {
				 blog.setCategory(category1);
			 } if(i%6==0)
			 {
				 blog.setCategory(category2);
			 }   if(i%8==0)
			 {
				 blog.setCategory(category3);
			 }
			 
			 
			 blog.setClick(0);
			 blog.setContent(i+"���3B�߸��������3�ߡ��ᴩ�������ĳǡ���ݸ��ڡ����ݻ������������ᴩ���ڡ����ݡ���ݸ���صĹ�����·���3�߽���ʽ��ͨ������·�������أ���Ϊ���������ҵ�縻ʿ������Ϊ����������Ա�������Լ��غ���ͨѹ��������������и����������н�ͨ����ίԱ����������ݡ���ݸ���ṫ����·���Ż��������֡����ڣ���ԭ���3A��3B��·�����Ż��͵���������6��10����ʽ��ͨ���Ż�����������3B��·���Ʊ��Ϊ�����3�ߡ�(ԭ3A��ֻ��΢��)��������������ͨ��ݸ�����еĹ�����·�����3�߸����������������ĳǣ���ݸ����Լ����ݻ���Ƭ����ʵ������ݸ������5�������򣨽ֵ���֮��Ŀ����У����������й����ͨ���Ǽʸ����ͳ��й������ۺϽ�ͨʵ�����޷��νӡ������·������ʿ������Ϊ���������ȴ�����ҵ������������Ա���������ѵ����⡣����·��Ҫ;��վ�㣺�����ﳤ��ʯ����վ�������ֵ��졢ƺɽ���ݿ�������������ó�ٻ�������������վ���Ƹ��Է�����ﺣ�ء�ƽ������վ����ʿ������Ϊ����Ƴǡ�������Ӫ�г���÷������վ�����ڱ�վ�����ڶ����غ����������"
	);
			 blog.setSend_Time("2014-6-9");
			 blog.setTitle("���3B��");
			 session.save(blog);
			 
			 Recommend recommend=new Recommend();
			 recommend.setBid(blog);
			 session.save(recommend);
			
		}

		 transaction.commit();
		 session.close();
		
	}

}
