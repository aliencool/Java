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
	 * 函数功能说明:
	 * Administrator  2014-6-8
	 * 修改者名字:
	 * 修改日期:
	 * 修改内容:
	 * @参数： @param args    
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
		 category.setC_Name("生活");
		 session.save(category);
		 
		 Category category1=new Category();
		 category1.setC_Name("程序");
		 session.save(category1);
		 
		 Category category2=new Category();
		 category2.setC_Name("随笔");
		 session.save(category2);
		 
		 Category category3=new Category();
		 category3.setC_Name("其他");
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
			 blog.setContent(i+"深惠3B线更名“深惠3线”贯穿龙岗中心城、东莞凤岗、惠州惠阳明天首条贯穿深圳、惠州、东莞三地的公交线路深惠3线将正式开通。该线路连接三地，将为缓解大型企业如富士康、华为、伯恩厂的员工出行以及沿海交通压力。三地市民出行更方便深圳市交通运输委员会着力于深惠、深莞交会公交线路的优化及合理布局。近期，将原深惠3A、3B线路进行优化和调整，将于6月10日正式开通。优化调整后的深惠3B线路名称变更为“深惠3线”(原3A线只作微调)，是至今首条贯通深莞惠三市的公交线路。深惠3线覆盖了深圳龙岗中心城，东莞凤岗以及惠州惠阳片区，实现了深莞惠三地5个毗邻镇（街道）之间的跨界出行，并且与我市轨道交通、城际高铁和城市公交等综合交通实现了无缝衔接。因该线路经过富士康、华为，伯恩厂等大型企业，缓解了他们员工出行困难的问题。该线路主要途经站点：惠阳秋长白石汽车站、坑梓街道办、坪山国惠康、五洲龙、世贸百货、龙岗汽车总站、黄阁翠苑、雁田海关、平湖汽车站、富士康、华为、万科城、坂田民营市场、梅林联检站、深圳北站。深圳东部沿海公交更便捷"
	);
			 blog.setSend_Time("2014-6-9");
			 blog.setTitle("深惠3B线");
			 session.save(blog);
			 
			 Recommend recommend=new Recommend();
			 recommend.setBid(blog);
			 session.save(recommend);
			
		}

		 transaction.commit();
		 session.close();
		
	}

}
