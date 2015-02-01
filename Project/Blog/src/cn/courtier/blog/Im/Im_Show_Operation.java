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
 * @类功能说明：实现操作类，执行S操作
 * @类修改者：
 * @修改日期：
 * @说明：因为全都是查询，所有全部为只读
 * @公司名称：
 * @作者：Administrator
 * @创建时间：2014-6-8 上午07:46:54
 * @版本：V1.0
 */



@Transactional(timeout=1200,readOnly=true)
public class Im_Show_Operation implements Show_Operation{
	//查询
	private Query query=null;
	//得到session
	@Resource(name="session_All")
	private  Get_Session get_session;
	
	//1:全部文章
	public SectionPage get_All_BlogContent(final ActionPage actionPageBean) {
	   
		String sql=Select_Condition.getCondition(Select_Enum.All,null);
		
	    SectionPage sectionPage=new SectionPage(actionPageBean,get_session.getSession(),sql,0,null);
	    
	    
	    
		return sectionPage;
	}
	//2:得到类别下面的所有文章 
	public SectionPage get_Category_BlogContent(String category_name,final ActionPage actionPageBean) {    
			String sql=Select_Condition.getCondition(Select_Enum.blog_Of_Category,category_name);
			 
		    SectionPage sectionPage=new SectionPage(actionPageBean, get_session.getSession(),sql,1,category_name);
		 

			return sectionPage;
	
	}

    //类别名
	public String get_Category_Name(String blogName) {
		
		
	    
	    String sql=Select_Condition.getCondition(Select_Enum.Category_Name, blogName);
	    
	    query= get_session.getSession().createQuery(sql);
	    
	    String name=(String) query.uniqueResult();
	    
		return name;
	}

	
	//得到推荐文章
	public List<ActionBlog> get_Recommend_BlogContent() {
		
		
	    
	    String sql=Select_Condition.getCondition(Select_Enum.Recommend,null);
	    
	    query= get_session.getSession().createQuery(sql);
	  
		return query.list();
	}
	
	
	
	//得到所有类别名称
	public List<Category> get_Category_All_Name()
	{
		
		
	    
	    String sql=Select_Condition.getCondition(Select_Enum.Category_All_Name,null);
	    
	    query= get_session.getSession().createQuery(sql);
		
		return query.list();
	}
	
	
	
	
	
    //得到特定文章id
	public BlogContent get_BlogContent(int id) {
		
		
	    //获取字符串
	    String sql=Select_Condition.getCondition(Select_Enum.Singl,null);
	    
	    query= get_session.getSession().createQuery(sql);
	    query.setParameter("id", id);
	    
	    
	    //得到标记
	    Integer flag=(Integer)query.uniqueResult();
	    
	    //0:表示没有修改过
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
