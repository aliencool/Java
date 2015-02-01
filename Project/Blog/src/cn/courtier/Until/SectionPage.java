package cn.courtier.Until;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

import cn.courtier.ActionBean.ActionBlog;
import cn.courtier.ActionBean.ActionMessageBox;
import cn.courtier.ActionBean.ActionPage;
import cn.courtier.ActionBean.ActionSaveMessage;
import cn.courtier.po.Bloguser;
import cn.courtier.po.MessageBox;
import cn.courtier.po.Send_Message;
   //ÿ���ض����и��Եķ�ҳ����

/**
 * @�๦��˵�������� ��� ҳ������ �û����� !--��ҳ
 * @���޸��ߣ�
 * @�޸����ڣ�
 * @�޸�˵����
 * @��˾���ƣ�
 * @���ߣ�Administrator
 * @����ʱ�䣺2014-6-14 ����02:15:58
 * @�汾��V1.0
 */
public class SectionPage{
	    	
			private ActionPage pageBean;
			
			private Session session;
			
			private String sql;
			//0:���� 1:��� 2:ҳ������  3:�û����԰� ���о�Ϊ��Ŀ
			private int flag;
			//�޶�����
			private String name;
			
			/**
			 * @param pageBean �ڼ�ҳ
			 * @param session
			 * @param sql     sql���
			 * @param flag     ���
			 * @param name     �޶���ѯʲô����
			 */
			public SectionPage(ActionPage pageBean, Session session,
					String sql, int flag,String name) {
				super();
				this.pageBean = pageBean;
				this.session = session;
				this.sql = sql;
				this.name=name;
				this.flag = flag;
			}


			
	    	public int total_Page()
	    	{
	    		Long total = null;
	    		switch(flag)
	    		{
	    		case 0:total=(Long)session.createQuery(Select_Condition.getCondition(Select_Enum.count_Blog_All,null)).uniqueResult();break;
	    		case 1:total=(Long)session.createQuery(Select_Condition.getCondition(Select_Enum.count_Category_Blog__All,null)).setParameter("cName", name).uniqueResult();break;
	    		case 2:total=(Long)session.createQuery(Select_Condition.getCondition(Select_Enum.count_Message_All,null)).uniqueResult();break;
	    		case 3:total=(Long)session.createQuery(Select_Condition.getCondition(Select_Enum.count_Save_Message_All,null)).setParameter("id", Integer.parseInt(name)).uniqueResult();break;
	    		}
	    	
	    		return  ((total.intValue()+ActionPage.MAXCOUNT)/ActionPage.MAXCOUNT);
	    	}

	    	
	    	//2,���ط�ҳʵ��
	    	public List<ActionBlog> get_section_BlogContent()
	    	{
	    	 
	    	    
	    		Query query= session.createQuery(sql);
	    		
	    		query.setFirstResult((pageBean.getCurrentPage()-1)*ActionPage.MAXCOUNT);
	    		
	    		query.setMaxResults(ActionPage.MAXCOUNT);
	    		
	    		return query.list();
	    	}
	    	
	    	//3,�������Է�ҳʵ��
	    	public List<ActionMessageBox> get_section_MessageBox()
	    	{
	    		Query query= session.createQuery(sql);
	    	
	    		query.setFirstResult((pageBean.getCurrentPage()-1)*ActionPage.MAXCOUNT);
	    		
	    		query.setMaxResults(ActionPage.MAXCOUNT);
	    		
	    		//�õ�list
	    		List<ActionMessageBox> actionMessageBoxs=query.list();
	    		//����ʱ��
	    		Iterator<ActionMessageBox> iterator=actionMessageBoxs.iterator();
	    		

	    		
	    		while(iterator.hasNext())
	    		{
	    			ActionMessageBox actionMessageBox=iterator.next();
	    			//���
	    			Long time=new Date().getTime()-Long.parseLong(actionMessageBox.getReply_Time());
	    			
	    			actionMessageBox.setReply_Time(String.valueOf(time/1000/60/60));
	    		}	
	    		
	    		return actionMessageBoxs;
	    	}

            //4,�����û�����ʵ��
	    	public List<ActionSaveMessage> get_section_userMessage()
	    	{
	    		Query query=session.createQuery(sql);
	    		
	    		query.setFirstResult((pageBean.getCurrentPage()-1)*ActionPage.MAXCOUNT);
	    		
	    		System.out.println(sql);
	    		System.out.print(query.list());
	    		
	    		query.setMaxResults(ActionPage.MAXCOUNT);
	    		
	    		return query.list();
	    	}
	    	
	    	

}