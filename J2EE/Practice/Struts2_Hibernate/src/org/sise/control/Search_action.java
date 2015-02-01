package org.sise.control;

import java.util.Iterator;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.sise.Dao.DB_Factory;
import org.sise.Dao.Dao_Interface;
import org.sise.bean.News;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
//ʹ��ajax��̬��ƪ
public class Search_action extends ActionSupport{
	private String Search_date;
	private String flag;//�Ƿ���Ҫ��ת
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
		//1:ȡ�����Ϊ���Ǳ��⻹��ʱ��
		int index=Search_date.indexOf("-");
		//������:
		
		//2:>0:ʱ�� <0:����
		if(index>0)
		{
			//��ȡ
			String [] time_like=Search_date.split("-");
			List<String> list=daoInterface.like_search("Time", Search_date, time_like[1], time_like[0]);
			//ƴװ
			String msg="";
			
			Iterator<String> iterator=list.iterator();
			
			while(iterator.hasNext())
			{
				msg=msg+iterator.next()+"|";
			}
			//���ؿͻ���
			ServletActionContext.getResponse().getWriter().println(msg);
		
		}else if(index<0)
		{
			List<String> list=daoInterface.like_search("Title", Search_date,null,null);
			//ƴװ
			String msg="";
		
			Iterator<String> iterator=list.iterator();
			
			while(iterator.hasNext())
			{
				msg=msg+iterator.next()+"|";
			}
			//���ؿͻ���
			ServletActionContext.getResponse().getWriter().println(msg);
			
		}
		//3:ֻ�ǲ�ѯ������ת
		if(flag.equals("like"))
		{
			return null;
		}
		//4:��ѯ�뱣��
		if(flag.equals("search"))
		{
			List<News> list=daoInterface.Part_search_title(Search_date);
			ActionContext.getContext().getSession().put("Message_search", list);
		}
	
		
		return SUCCESS;
	}
	
	

}
