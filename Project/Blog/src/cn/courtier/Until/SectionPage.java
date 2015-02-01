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
   //每个特定类有各自的分页功能

/**
 * @类功能说明：文章 类别 页面留言 用户留言 !--分页
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @公司名称：
 * @作者：Administrator
 * @创建时间：2014-6-14 下午02:15:58
 * @版本：V1.0
 */
public class SectionPage{
	    	
			private ActionPage pageBean;
			
			private Session session;
			
			private String sql;
			//0:文章 1:类别 2:页面留言  3:用户留言板 所有均为数目
			private int flag;
			//限定名称
			private String name;
			
			/**
			 * @param pageBean 第几页
			 * @param session
			 * @param sql     sql语句
			 * @param flag     标记
			 * @param name     限定查询什么名称
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

	    	
	    	//2,返回分页实体
	    	public List<ActionBlog> get_section_BlogContent()
	    	{
	    	 
	    	    
	    		Query query= session.createQuery(sql);
	    		
	    		query.setFirstResult((pageBean.getCurrentPage()-1)*ActionPage.MAXCOUNT);
	    		
	    		query.setMaxResults(ActionPage.MAXCOUNT);
	    		
	    		return query.list();
	    	}
	    	
	    	//3,返回留言分页实体
	    	public List<ActionMessageBox> get_section_MessageBox()
	    	{
	    		Query query= session.createQuery(sql);
	    	
	    		query.setFirstResult((pageBean.getCurrentPage()-1)*ActionPage.MAXCOUNT);
	    		
	    		query.setMaxResults(ActionPage.MAXCOUNT);
	    		
	    		//得到list
	    		List<ActionMessageBox> actionMessageBoxs=query.list();
	    		//设置时间
	    		Iterator<ActionMessageBox> iterator=actionMessageBoxs.iterator();
	    		

	    		
	    		while(iterator.hasNext())
	    		{
	    			ActionMessageBox actionMessageBox=iterator.next();
	    			//相减
	    			Long time=new Date().getTime()-Long.parseLong(actionMessageBox.getReply_Time());
	    			
	    			actionMessageBox.setReply_Time(String.valueOf(time/1000/60/60));
	    		}	
	    		
	    		return actionMessageBoxs;
	    	}

            //4,返回用户留言实体
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