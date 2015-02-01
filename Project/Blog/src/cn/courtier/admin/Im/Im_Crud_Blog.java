package cn.courtier.admin.Im;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.springframework.transaction.annotation.Transactional;
import cn.courtier.Interf.Crud_Blog;
import cn.courtier.Until.Get_Session;
import cn.courtier.Until.Select_Condition;
import cn.courtier.Until.Select_Enum;
import cn.courtier.po.BlogContent;
import cn.courtier.po.Bloguser;
import cn.courtier.po.Category;

/**
 * @�๦��˵�����������ݸ����ڿ��Ʋ����
 * @���޸��ߣ�
 * @�޸����ڣ�
 * @�޸�˵����
 * @��˾���ƣ�
 * @���ߣ�Administrator
 * @����ʱ�䣺2014-6-8 ����01:22:33
 * @�汾��V1.0
 */
@Transactional
public class Im_Crud_Blog implements Crud_Blog{
	//�õ�session
	@Resource(name="session_All")
	private  Get_Session get_session;
	
	public boolean delete_Blog(BlogContent blogContent) {
		
		
		
		 get_session.getSession().delete(blogContent);
		
		return true;
	}

	public boolean insert_Blog(BlogContent blogContent, Category category,
			Bloguser bloguser) {
		
		
		
		blogContent.setCategory(category);
		
		blogContent.setBloguser(bloguser);
		
		 get_session.getSession().save(blogContent);
		
		return true;
	}
	//���󷽷�
	public boolean update_Blog(BlogContent blogContent) {
		
		
		
		 get_session.getSession().update(blogContent);
		
	
		return true;
	}
	
	
	public int update_click(int id,int count)
	{
		
	    
	    String sql=Select_Condition.getCondition(Select_Enum.Update_click,null);
	    
	    Query query= get_session.getSession().createQuery(sql);
		
	    query.setParameter("id", id);
	    
	    query.setParameter("count", count);
	    
	    
		return query.executeUpdate();
		
	}
	
	public int update_award(int id,int count)
	{
		
	    
	    String sql=Select_Condition.getCondition(Select_Enum.Award,null);
	    
	    Query query= get_session.getSession().createQuery(sql);
		
	    query.setParameter("id", id);
	    
	    query.setParameter("count", count);
	    
	    
		return query.executeUpdate();
		
	}
	
}
