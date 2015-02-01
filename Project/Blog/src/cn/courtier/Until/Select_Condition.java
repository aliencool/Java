package cn.courtier.Until;

import java.text.MessageFormat;


/**
 * @类功能说明：根据类别返回不同执行语句
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @公司名称：
 * @作者：Administrator
 * @创建时间：2014-6-8 上午07:29:59
 * @版本：V1.0
 */
public class Select_Condition {
	//0.0  count 所有内容
	private final static String count_Blog_All="select count(*) from BlogContent";
	private final static String count_Category_Blog__All="select count(*) from BlogContent b where b.category.c_Name=:cName";
	private final static String count_Message_All="select count(*) from MessageBox ";
	private final static String count_Save_Message_All="select count(*) from Send_Message where save_M.u_Id=:id";
	//1.0:查找所有文章
	private final static String select_All="select new cn.courtier.ActionBean.ActionBlog(category.c_Name,b.title,b.content,b.send_Time,b.img_Name,b.click,b.award) from BlogContent b order by log_Id desc";
	//1.1:查找类别下的文章
	private final static String blog_Of_Category="select new cn.courtier.ActionBean.ActionBlog(b.category.c_Name,b.title,b.content,b.send_Time,b.img_Name,b.click,b.award) from BlogContent b where b.category.c_Name=''{0}''";
	//1.2:查找文章的类名
	private final static String category_Of_BlogCotent="select new cn.courtier.ActionBean.ActionCategory(c_name) from category where c_id=(select c_id from BlogContent where c_name=''"+"{0}"+"'')";
	//1.3查找推荐表文章
	private final static String recommend_All="select new cn.courtier.ActionBean.ActionBlog(b.category.c_Name,b.title,b.content,b.send_Time,b.img_Name,b.click,b.award) from BlogContent b"+
 " left join b.category on b.category.id=b.log_Id where log_Id in (select bid from Recommend) " ;
	//1.4查找一个文章的标记（是否被修改过 ）
	private final static String Singl="select flag from BlogContent where log_Id=:id";
	//1.5标记 0 没有修改过
	public final static String Singl_0="select new cn.courtier.ActionBean.ActionBlog(category.c_Name,b.title,b.content,b.send_Time,b.img_Name,b.click,b.award) from BlogContent where log_Id=:id";
	//1.6标记1 修改过  
	public final static String Singl_1="select new cn.courtier.ActionBean.ActionBlog(category.c_Name,b.title,b.content,b.correct_Time,b.img_Name,b.click,b.award) from BlogContent where log_Id=:id";
	//1.7查找类别下的所有名称
	private final static String category_All_Name="from Category";
	//2.0:更新点击
	public final static String update_Click="update from BlogContent  set click=:count where log_Id=:id";
	//2.1:更新赞
	public final static String update_Award="update from BlogContent  set award=:count where log_Id=:id";
	
	private Select_Condition(){
		
	}
	
	
	
	/**
	 * 函数功能说明:返回特定查询条件
	 * Administrator  2014-6-8
	 * 修改者名字:
	 * 修改日期:
	 * 修改内容:
	 * @参数： @param lect_Enum 枚举
	 * @参数： @param name   查询类别名称参数
	 * @参数： @return    
	 * @return String   
	 * @throws
	 */
	public static String getCondition(Select_Enum lect_Enum,final String name)
	{
		switch(lect_Enum)
		{
		//1: 查
		   case  count_Blog_All:return count_Blog_All;
		   case  count_Category_Blog__All:return count_Category_Blog__All;
		   case   count_Message_All: return count_Message_All;
		   case   count_Save_Message_All: return count_Save_Message_All;
		   case  All:
			   return select_All;
			   
		   case Category_Name:
			   if(name!=null)
			   {
				   String format=MessageFormat.format(category_Of_BlogCotent, name);
				   return format;
			   }
			   //为空，直接查询全部字符串
			   return select_All;
			   
		   case Recommend:
		       return recommend_All;
		       
		   case blog_Of_Category:
			   if(name!=null)
			   {
				   
				   String format=MessageFormat.format(blog_Of_Category, name);
				   System.out.println("name:"+format);
				   return format;
			   }
			   //为空，直接查询全部字符串
			   return select_All;
		   case Singl:
			   //查文章先查标记是否被修改
			   return Singl;
			   
			   //类别所有名称
		   case Category_All_Name:
			   return category_All_Name;
			    
		  //2:改
		   case Award:
			  return update_Award;
			  
		   case Update_click:
			   return update_Click;
		}
		return null;
		
	}
}
