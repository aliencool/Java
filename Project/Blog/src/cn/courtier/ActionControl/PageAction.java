package cn.courtier.ActionControl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import cn.courtier.ActionBean.ActionBlog;
import cn.courtier.ActionBean.ActionPage;
import cn.courtier.Until.SectionPage;
import cn.courtier.admin.Im.Im_Crub_Service;
import cn.courtier.blog.Im.Im_Show_Service;
import cn.courtier.message.Im.Im_Message_Service;
import cn.courtier.po.Category;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @�๦��˵������ҳ��ת
 * @���޸��ߣ�
 * @�޸����ڣ�
 * @�޸�˵����
 * @��˾���ƣ�
 * @���ߣ�Administrator
 * @����ʱ�䣺2014-6-9 ����11:50:35
 * @�汾��V1.0
 */
public class PageAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	/**
	 *@��������ҳ��ת
	 *@������{todo}
	 */
	@Resource(name="show_Service")
	private Im_Show_Service operation;
	@Resource(name="messageService")
	private Im_Message_Service messageService;
	@Autowired  
	private  HttpServletRequest request; 
	//flag:
	//0:������������ķ�ҳ
	//1:��������ķ�ҳ
	//2:��������Ϣ��
	private int flag;
	
	private String categoryName;
	
	private ActionPage actionPage;

	public ActionPage getActionPage() {
		return actionPage;
	}

	public void setActionPage(ActionPage actionPage) {
		this.actionPage = actionPage;
	}
	
	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getCategoryName() {
		return categoryName;
	}



	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String execute() throws Exception {
	
		SectionPage list_all=null;
		SectionPage list_click=null;
		List<ActionBlog> blog_N=null;
		List<Category> blog_C=null;
		
	switch(flag)
	{
	//0:����
	case 0:
		list_all=operation.get_All_BlogContent(actionPage);
		
		request.setAttribute("all_blog", list_all.get_section_BlogContent());
		//1.1��ҳ�ĸ���
		request.setAttribute("count", list_all.total_Page());
		
		
		
		//2:�������
		list_click=operation.get_All_BlogContent(actionPage);
		//2.1:����
		Collections.sort(list_click.get_section_BlogContent(),new Comparator<ActionBlog>() {

			public int compare(ActionBlog o1, ActionBlog o2) {
				// TODO Auto-generated method 
				return o1.getClick()-o2.getClick();
			}
		});
		
		request.setAttribute("click_blog", list_click.get_section_BlogContent());
		
		
		
		//3:�Ƽ�����
		blog_N=operation.get_All_BlogContent(actionPage).get_section_BlogContent();
		
		request.setAttribute("recommend", blog_N);
	     //4�������
		blog_C=operation.get_Category_All_Name();
		
		request.setAttribute("category", blog_C);
		
		return "NewList";
	//2:���
	case 1:
		    //��һ�ν�����𱣴浽session��������ǵڶ��Σ���ҳ����һֱΪ�յģ�ֱ��ȡ������
			if(categoryName!=null)
			{
				System.out.println(categoryName);
				ActionContext.getContext().getSession().put("categoryName", categoryName);
			}
			else
			  categoryName=(String) ActionContext.getContext().getSession().get("categoryName");
				
			list_all=operation.get_Category_BlogContent(categoryName, actionPage);
			
			request.setAttribute("all_blog", list_all.get_section_BlogContent());
			//1.1��ҳ�ĸ���  8��ÿҳ����
			request.setAttribute("count", list_all.total_Page());
			
			
			
			//2:�������
			list_click=operation.get_All_BlogContent(actionPage);
			//2.1:����
			Collections.sort(list_click.get_section_BlogContent(),new Comparator<ActionBlog>() {

				public int compare(ActionBlog o1, ActionBlog o2) {
					// TODO Auto-generated method 
					return o1.getClick()-o2.getClick();
				}
			});
			
			request.setAttribute("click_blog", list_click.get_section_BlogContent());
			
			
			
			//3:�Ƽ�����
			blog_N=operation.get_All_BlogContent(actionPage).get_section_BlogContent();
			
			request.setAttribute("recommend", blog_N);
		    
			//4:�������
			blog_C=operation.get_Category_All_Name();
			
			request.setAttribute("category", blog_C);
			
			return "categorynewlist";
		case 2:
		SectionPage message=messageService.show_Message(actionPage);
		
		request.setAttribute("messagebox", message.get_section_MessageBox());
		
		request.setAttribute("count",message.total_Page());
		
	
		return "messageList";
		}
	
		return SUCCESS;
		
		
		
	}
	
	

}
