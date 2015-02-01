package cn.courtier.Interf;

import java.util.List;

import com.opensymphony.xwork2.Action;

import cn.courtier.ActionBean.ActionBlog;
import cn.courtier.ActionBean.ActionPage;
import cn.courtier.Until.SectionPage;
import cn.courtier.po.BlogContent;
import cn.courtier.po.Category;

/**
 * @�๦��˵������ʾ�����ӿ�
 * @���޸��ߣ�
 * @�޸����ڣ�
 * @˵�������෽�����ܣ��鿴����
 * @��˾���ƣ�
 * @���ߣ�Administrator
 * @����ʱ�䣺2014-6-7 ����11:29:32
 * @�汾��V1.0
 */
public interface Show_Operation {
	/**
	 * ��������˵��:��ѯȫ��
	 * Administrator  2014-6-8
	 * �޸�������:
	 * �޸�����:
	 * �޸�����:
	 * @������ @param actionPageBean ��ҳ
	 * @������ @return    
	 * @return List<BlogContent>   
	 * @throws
	 */
	public SectionPage get_All_BlogContent(ActionPage actionPageBean);
	/**
	 * ��������˵��:��ѯ�����������
	 * Administrator  2014-6-8
	 * �޸�������:
	 * �޸�����:
	 * �޸�����:
	 * @������ @param category_name
	 * @������ @param actionPageBean ��ҳ
	 * @������ @return    
	 * @return List<BlogContent>   
	 * @throws
	 */
	public  SectionPage get_Category_BlogContent(String category_name,ActionPage actionPageBean);
	
	
	/**
	 * ��������˵��:�Ƽ�����
	 * Administrator  2014-6-8
	 * �޸�������:
	 * �޸�����:
	 * �޸�����:
	 * @������ @return    
	 * @return List<BlogContent>   
	 * @throws
	 */
	public   List<ActionBlog> get_Recommend_BlogContent();
	
	
	
	/**
	 * ��������˵��:�������µõ����
	 * Administrator  2014-6-8
	 * �޸�������:
	 * �޸�����:
	 * �޸�����:
	 * @������ @param blog_Name
	 * @������ @return    
	 * @return String   
	 * @throws
	 */
	public   String get_Category_Name(String blog_Name);
	
	
	/**
	 * ��������˵��:������������
	 * Administrator  2014-6-8
	 * �޸�������:
	 * �޸�����:
	 * �޸�����:
	 * @������ @return    
	 * @return List<BlogContent>   
	 * @throws
	 */
	public List<Category> get_Category_All_Name();
	/**
	 * ��������˵��:���ҵ�������
	 * Administrator  2014-6-8
	 * �޸�������:
	 * �޸�����:
	 * �޸�����:
	 * @������ @param id
	 * @������ @return    
	 * @return BlogContent   
	 * @throws
	 */
	public BlogContent get_BlogContent(int id);
}
