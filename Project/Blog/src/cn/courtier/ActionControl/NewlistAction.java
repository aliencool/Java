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
	 *@类名：博客列表
	 *@描述：{todo}
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
	 *@属性名：id
	 *@描述：{查看点击那个博客}
	 */
	private int id;
	/**
	 *@属性名：hashMap
	 *@描述：防止重复点击
	 */
	private HashMap<String,String> hashMap=Get_HashMap.getHashMap();
	/**
	 *@属性名：flag 用来增加点击和赞
	 *@描述：标记:0:进入
	 *            1:表示点击
	 *            2:表示点赞
	 */
	private int flag;
	/**
	 *@属性名：count
	 *@描述：点击数
	 **/
	private int count;
	
	/**
	 *@属性名：其他
	 *@描述：其他
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
		
		//1:点击方法类
		switch(flag)
		{
		case 0:
			//点击文章
			Show_Operation show=new Im_Show_Operation();
			
			BlogContent blogContent=show.get_BlogContent(id);
			
			request.setAttribute("blog", blogContent);
			
			return "News";
			
		case 1:
			//获取地址没有，直接更新，有就你懂得!
			mark=hashMap.get(request.getLocalAddr());
			
			
			if(mark==null)
			{
				
				hashMap.put(request.getLocalAddr(),"has");
				crudBlog.update_click(id, count);
			}
			return NONE;
		case 2:
			//获取地址没有，直接更新，有就你懂得!award区分click
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
		//得到所有文章:
		SectionPage all_blog=operation.get_All_BlogContent(actionPageBean);
		//设置名称
		request.setAttribute("all_blog", all_blog.get_section_BlogContent());
		//页数
		request.setAttribute("count", all_blog.total_Page());
	     //类别名称
		List<Category> blog_C=operation.get_Category_All_Name();
		
		request.setAttribute("category", blog_C);
		
		
		return SUCCESS;
		
		
		
		
	}
}

