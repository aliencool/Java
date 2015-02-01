package cn.courtier.ActionControl;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import cn.courtier.ActionBean.ActionBlog;
import cn.courtier.ActionBean.ActionPage;
import cn.courtier.Interf.Show_Operation;
import cn.courtier.Until.Get_HashMap;
import cn.courtier.Until.SectionPage;
import cn.courtier.admin.Im.Im_Crub_Service;
import cn.courtier.blog.Im.Im_Show_Operation;
import cn.courtier.blog.Im.Im_Show_Service;
import cn.courtier.po.BlogContent;
import cn.courtier.po.Category;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class NewlistAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	/**
	 *@�����������б�
	 *@������{todo}
	 */
	@Resource(name="crub_Service")
	private Im_Crub_Service crudBlog;

	@Resource(name="page")
	private ActionPage actionPageBean;
	
	@Resource(name="show_Service")
	private Im_Show_Service operation;
	
	@Autowired  
	private  HttpServletRequest request; 
	/**
	 *@��������id
	 *@������{�鿴����Ǹ�����}
	 */
	private int id;
	/**
	 *@��������hashMap
	 *@��������ֹ�ظ����
	 */
	private HashMap<String,String> hashMap=Get_HashMap.getHashMap();
	/**
	 *@��������flag �������ӵ������
	 *@���������:0:����
	 *            1:��ʾ���
	 *            2:��ʾ����
	 */
	private int flag;
	/**
	 *@��������count
	 *@�����������
	 **/
	private int count;
	
	/**
	 *@������������
	 *@����������
	 **/
	private String mark;
	

	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public int getId() {
		return id;
	}

	public int getFlag() {
		return flag;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}


	@Override
	public String execute() throws Exception {
		
		//1:���������
		switch(flag)
		{
		case 0:
			//�������
			Show_Operation show=new Im_Show_Operation();
			
			BlogContent blogContent=show.get_BlogContent(id);
			
			request.setAttribute("blog", blogContent);
			
			return "News";
			
		case 1:
			//��ȡ��ַû�У�ֱ�Ӹ��£��о��㶮��!
			mark=hashMap.get(request.getLocalAddr());
			
			
			if(mark==null)
			{
				
				hashMap.put(request.getLocalAddr(),"has");
				crudBlog.update_click(id, count);
			}
			return NONE;
		case 2:
			//��ȡ��ַû�У�ֱ�Ӹ��£��о��㶮��!award����click
			mark=hashMap.get(request.getLocalAddr()+"award");
		
			if(mark==null)
			{
				
				hashMap.put(request.getLocalAddr()+"award",mark+1);
				crudBlog.update_award(id, count);
			}
			return NONE;
		
		}
		
		return SUCCESS;
	}
	
	public String load() throws Exception
	{
		//�õ���������:
		SectionPage all_blog=operation.get_All_BlogContent(actionPageBean);
		//��������
		request.setAttribute("all_blog", all_blog.get_section_BlogContent());
		//ҳ��
		request.setAttribute("count", all_blog.total_Page());
	     //�������
		List<Category> blog_C=operation.get_Category_All_Name();
		
		request.setAttribute("category", blog_C);
		
		
		return SUCCESS;
		
		
		
		
	}
}

