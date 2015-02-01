package cn.courtier.Until;

import java.text.MessageFormat;


/**
 * @�๦��˵����������𷵻ز�ִͬ�����
 * @���޸��ߣ�
 * @�޸����ڣ�
 * @�޸�˵����
 * @��˾���ƣ�
 * @���ߣ�Administrator
 * @����ʱ�䣺2014-6-8 ����07:29:59
 * @�汾��V1.0
 */
public class Select_Condition {
	//0.0  count ��������
	private final static String count_Blog_All="select count(*) from BlogContent";
	private final static String count_Category_Blog__All="select count(*) from BlogContent b where b.category.c_Name=:cName";
	private final static String count_Message_All="select count(*) from MessageBox ";
	private final static String count_Save_Message_All="select count(*) from Send_Message where save_M.u_Id=:id";
	//1.0:������������
	private final static String select_All="select new cn.courtier.ActionBean.ActionBlog(category.c_Name,b.title,b.content,b.send_Time,b.img_Name,b.click,b.award) from BlogContent b order by log_Id desc";
	//1.1:��������µ�����
	private final static String blog_Of_Category="select new cn.courtier.ActionBean.ActionBlog(b.category.c_Name,b.title,b.content,b.send_Time,b.img_Name,b.click,b.award) from BlogContent b where b.category.c_Name=''{0}''";
	//1.2:�������µ�����
	private final static String category_Of_BlogCotent="select new cn.courtier.ActionBean.ActionCategory(c_name) from category where c_id=(select c_id from BlogContent where c_name=''"+"{0}"+"'')";
	//1.3�����Ƽ�������
	private final static String recommend_All="select new cn.courtier.ActionBean.ActionBlog(b.category.c_Name,b.title,b.content,b.send_Time,b.img_Name,b.click,b.award) from BlogContent b"+
 " left join b.category on b.category.id=b.log_Id where log_Id in (select bid from Recommend) " ;
	//1.4����һ�����µı�ǣ��Ƿ��޸Ĺ� ��
	private final static String Singl="select flag from BlogContent where log_Id=:id";
	//1.5��� 0 û���޸Ĺ�
	public final static String Singl_0="select new cn.courtier.ActionBean.ActionBlog(category.c_Name,b.title,b.content,b.send_Time,b.img_Name,b.click,b.award) from BlogContent where log_Id=:id";
	//1.6���1 �޸Ĺ�  
	public final static String Singl_1="select new cn.courtier.ActionBean.ActionBlog(category.c_Name,b.title,b.content,b.correct_Time,b.img_Name,b.click,b.award) from BlogContent where log_Id=:id";
	//1.7��������µ���������
	private final static String category_All_Name="from Category";
	//2.0:���µ��
	public final static String update_Click="update from BlogContent  set click=:count where log_Id=:id";
	//2.1:������
	public final static String update_Award="update from BlogContent  set award=:count where log_Id=:id";
	
	private Select_Condition(){
		
	}
	
	
	
	/**
	 * ��������˵��:�����ض���ѯ����
	 * Administrator  2014-6-8
	 * �޸�������:
	 * �޸�����:
	 * �޸�����:
	 * @������ @param lect_Enum ö��
	 * @������ @param name   ��ѯ������Ʋ���
	 * @������ @return    
	 * @return String   
	 * @throws
	 */
	public static String getCondition(Select_Enum lect_Enum,final String name)
	{
		switch(lect_Enum)
		{
		//1: ��
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
			   //Ϊ�գ�ֱ�Ӳ�ѯȫ���ַ���
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
			   //Ϊ�գ�ֱ�Ӳ�ѯȫ���ַ���
			   return select_All;
		   case Singl:
			   //�������Ȳ����Ƿ��޸�
			   return Singl;
			   
			   //�����������
		   case Category_All_Name:
			   return category_All_Name;
			    
		  //2:��
		   case Award:
			  return update_Award;
			  
		   case Update_click:
			   return update_Click;
		}
		return null;
		
	}
}
