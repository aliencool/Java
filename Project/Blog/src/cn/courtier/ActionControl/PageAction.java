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
 * @类功能说明：分页跳转
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @公司名称：
 * @作者：Administrator
 * @创建时间：2014-6-9 下午11:50:35
 * @版本：V1.0
 */
public class PageAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	/**
	 *@类名：分页跳转
	 *@描述：{todo}
	 */
	@Resource(name="show_Service")
	private Im_Show_Service operation;
	@Resource(name="messageService")
	private Im_Message_Service messageService;
	@Autowired  
	private  HttpServletRequest request; 
	//flag:
	//0:进入新闻网后的分页
	//1:进入类别后的分页
	//2:是留言信息表
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
	//0:文章
	case 0:
		list_all=operation.get_All_BlogContent(actionPage);
		
		request.setAttribute("all_blog", list_all.get_section_BlogContent());
		//1.1分页的个数
		request.setAttribute("count", list_all.total_Page());
		
		
		
		//2:点击排行
		list_click=operation.get_All_BlogContent(actionPage);
		//2.1:排序
		Collections.sort(list_click.get_section_BlogContent(),new Comparator<ActionBlog>() {

			public int compare(ActionBlog o1, ActionBlog o2) {
				// TODO Auto-generated method 
				return o1.getClick()-o2.getClick();
			}
		});
		
		request.setAttribute("click_blog", list_click.get_section_BlogContent());
		
		
		
		//3:推荐文章
		blog_N=operation.get_All_BlogContent(actionPage).get_section_BlogContent();
		
		request.setAttribute("recommend", blog_N);
	     //4类别名称
		blog_C=operation.get_Category_All_Name();
		
		request.setAttribute("category", blog_C);
		
		return "NewList";
	//2:类别
	case 1:
		    //第一次进入类别保存到session，如果，是第二次（分页）是一直为空的，直接取就行了
			if(categoryName!=null)
			{
				System.out.println(categoryName);
				ActionContext.getContext().getSession().put("categoryName", categoryName);
			}
			else
			  categoryName=(String) ActionContext.getContext().getSession().get("categoryName");
				
			list_all=operation.get_Category_BlogContent(categoryName, actionPage);
			
			request.setAttribute("all_blog", list_all.get_section_BlogContent());
			//1.1分页的个数  8是每页个数
			request.setAttribute("count", list_all.total_Page());
			
			
			
			//2:点击排行
			list_click=operation.get_All_BlogContent(actionPage);
			//2.1:排序
			Collections.sort(list_click.get_section_BlogContent(),new Comparator<ActionBlog>() {

				public int compare(ActionBlog o1, ActionBlog o2) {
					// TODO Auto-generated method 
					return o1.getClick()-o2.getClick();
				}
			});
			
			request.setAttribute("click_blog", list_click.get_section_BlogContent());
			
			
			
			//3:推荐文章
			blog_N=operation.get_All_BlogContent(actionPage).get_section_BlogContent();
			
			request.setAttribute("recommend", blog_N);
		    
			//4:类别名称
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
