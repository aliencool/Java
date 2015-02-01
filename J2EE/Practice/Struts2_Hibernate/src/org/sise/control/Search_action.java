package org.sise.control;

import java.util.Iterator;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.sise.Dao.DB_Factory;
import org.sise.Dao.Dao_Interface;
import org.sise.bean.News;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
//使用ajax动态联篇
public class Search_action extends ActionSupport{
	private String Search_date;
	private String flag;//是否需要跳转
	public String getSearch_date() {
		return Search_date;
	}

	public void setSearch_date(String searchDate) {
		Search_date = searchDate;
	}
	
	
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		ServletActionContext.getRequest().setCharacterEncoding("UTF-8");
		System.out.println(Search_date);
		
		Dao_Interface daoInterface=DB_Factory.getInstance();
		//1:取标记是为了是标题还是时间
		int index=Search_date.indexOf("-");
		//保存量:
		
		//2:>0:时间 <0:标题
		if(index>0)
		{
			//截取
			String [] time_like=Search_date.split("-");
			List<String> list=daoInterface.like_search("Time", Search_date, time_like[1], time_like[0]);
			//拼装
			String msg="";
			
			Iterator<String> iterator=list.iterator();
			
			while(iterator.hasNext())
			{
				msg=msg+iterator.next()+"|";
			}
			//发回客户端
			ServletActionContext.getResponse().getWriter().println(msg);
		
		}else if(index<0)
		{
			List<String> list=daoInterface.like_search("Title", Search_date,null,null);
			//拼装
			String msg="";
		
			Iterator<String> iterator=list.iterator();
			
			while(iterator.hasNext())
			{
				msg=msg+iterator.next()+"|";
			}
			//发回客户端
			ServletActionContext.getResponse().getWriter().println(msg);
			
		}
		//3:只是查询不用跳转
		if(flag.equals("like"))
		{
			return null;
		}
		//4:查询与保存
		if(flag.equals("search"))
		{
			List<News> list=daoInterface.Part_search_title(Search_date);
			ActionContext.getContext().getSession().put("Message_search", list);
		}
	
		
		return SUCCESS;
	}
	
	

}
