package cn.courtier.Interf;

import cn.courtier.po.BlogContent;
import cn.courtier.po.Bloguser;
import cn.courtier.po.Category;

/**
 * @类功能说明：管理员专门类
 * @类修改者：
 * @修改日期：
 * @说明：CRUD
 * @公司名称：
 * @作者：Administrator
 * @创建时间：2014-6-8 下午01:00:26
 * @版本：V1.0
 */
public interface Crud_Blog {
	
	   /**
	 * 函数功能说明:插入文章
	 * Administrator  2014-6-8
	 * 修改者名字:
	 * 修改日期:
	 * 修改内容:
	 * @参数： @param blogContent
	 * @参数： @param category 保存特定类别
	 * @参数： @param bloguser 保存特定的用户名
	 * @参数： @return    
	 * @return boolean   
	 * @throws
	 */
	public boolean insert_Blog(BlogContent blogContent,Category category,Bloguser bloguser);
	
	/**
	 * 函数功能说明:更新当前
	 * Administrator  2014-6-8
	 * 修改者名字:
	 * 修改日期:
	 * 修改内容:
	 * @参数： @param blogContent 文章
	 * @参数： @return    
	 * @return boolean   
	 * @throws
	 */
	public boolean update_Blog(BlogContent blogContent);
	
	
	
	/**
	 * 函数功能说明:删除这个id的文章
	 * Administrator  2014-6-8
	 * 修改者名字:
	 * 修改日期:
	 * 修改内容:
	 * @参数： @param id
	 * @参数： @return    
	 * @return boolean   
	 * @throws
	 */
	public boolean delete_Blog(BlogContent blogContent);
	
	/**
	 * 函数功能说明:更新点击与赞
	 * Administrator  2014-6-8
	 * 修改者名字:
	 * 修改日期:
	 * 修改内容:
	 * @参数： @param id
	 * @参数： @param count
	 * @参数： @return    
	 * @return int   
	 * @throws
	 */
	public int update_click(int id,int count);
	public int update_award(int id,int count);
	
}