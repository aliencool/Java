package cn.courtier.blog.Im;

import java.text.MessageFormat;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;

import org.springframework.transaction.annotation.Transactional;


import cn.courtier.ActionBean.ActionBlog;
import cn.courtier.ActionBean.ActionPage;
import cn.courtier.Interf.Show_Operation;
import cn.courtier.Until.Get_Session;
import cn.courtier.Until.SectionPage;
import cn.courtier.Until.Select_Condition;
import cn.courtier.Until.Select_Enum;
import cn.courtier.po.BlogContent;
import cn.courtier.po.Category;


/**
 * @�๦��˵����ʵ�ֲ����ִ࣬��S����
 * @���޸��ߣ�
 * @�޸����ڣ�
 * @˵������Ϊȫ���ǲ�ѯ������ȫ��Ϊֻ��
 * @��˾���ƣ�
 * @���ߣ�Administrator
 * @����ʱ�䣺2014-6-8 ����07:46:54
 * @�汾��V1.0
 */



@Transactional(timeout=1200,readOnly=true)
public class Im_Show_Operation implements Show_Operation{
	//��ѯ
	private Query query=null;
	//�õ�session
	@Resource(name="session_All")
	private  Get_Session get_session;
	
	//1:ȫ������
	public SectionPage get_All_BlogContent(final ActionPage actionPageBean) {
	   
		String sql=Select_Condition.getCondition(Select_Enum.All,null);
		
	    SectionPage sectionPage=new SectionPage(actionPageBean,get_session.getSession(),sql,0,null);
	    
	    
	    
		return sectionPage;
	}
	//2:�õ����������������� 
	public SectionPage get_Category_BlogContent(String category_name,final ActionPage actionPageBean) {    
			String sql=Select_Condition.getCondition(Select_Enum.blog_Of_Category,category_name);
			 
		    SectionPage sectionPage=new SectionPage(actionPageBean, get_session.getSession(),sql,1,category_name);
		 

			return sectionPage;
	
	}

    //�����
	public String get_Category_Name(String blogName) {
		
		
	    
	    String sql=Select_Condition.getCondition(Select_Enum.Category_Name, blogName);
	    
	    query= get_session.getSession().createQuery(sql);
	    
	    String name=(String) query.uniqueResult();
	    
		return name;
	}

	
	//�õ��Ƽ�����
	public List<ActionBlog> get_Recommend_BlogContent() {
		
		
	    
	    String sql=Select_Condition.getCondition(Select_Enum.Recommend,null);
	    
	    query= get_session.getSession().createQuery(sql);
	  
		return query.list();
	}
	
	
	
	//�õ������������
	public List<Category> get_Category_All_Name()
	{
		
		
	    
	    String sql=Select_Condition.getCondition(Select_Enum.Category_All_Name,null);
	    
	    query= get_session.getSession().createQuery(sql);
		
		return query.list();
	}
	
	
	
	
	
    //�õ��ض�����id
	public BlogContent get_BlogContent(int id) {
		
		
	    //��ȡ�ַ���
	    String sql=Select_Condition.getCondition(Select_Enum.Singl,null);
	    
	    query= get_session.getSession().createQuery(sql);
	    query.setParameter("id", id);
	    
	    
	    //�õ����
	    Integer flag=(Integer)query.uniqueResult();
	    
	    //0:��ʾû���޸Ĺ�
	    if(flag.intValue()==0)
	    {
	    	 query= get_session.getSession().createQuery(Select_Condition.Singl_0);
	    	 
	    	 query.setParameter("id", id);
	    	 
	    	 
	    }
	    else 
	    {
	    	query= get_session.getSession().createQuery(Select_Condition.Singl_1);
	    
	    	query.setParameter("id", id);
	    	 
	    }
	    
	    
		return (BlogContent) query.uniqueResult();
	}
	
	
	
	
}
