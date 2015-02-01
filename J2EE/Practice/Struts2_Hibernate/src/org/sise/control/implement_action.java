package org.sise.control;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.sise.Dao.DB_Factory;
import org.sise.Dao.Dao_Interface;
import org.sise.bean.News;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
//删除与修改类
public class implement_action extends ActionSupport{
	private int id;
	private News news;
	private String flag;
	
	
	private String title;
	private String soure;
	private Date datetime;
	private String tt;
	public String getTitle() {
		return title;
	}
	public String getSoure() {
		return soure;
	}
	public Date getDatetime() {
		return datetime;
	}
	public String getTt() {
		return tt;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setSoure(String soure) {
		this.soure = soure;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	public void setTt(String tt) {
		this.tt = tt;
	}
	
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		//获取id-并装载内容
		Dao_Interface daoInterface=DB_Factory.getInstance();
		//删除
		if(flag.equals("delete"))
		{
			daoInterface.delete(getId());
		}
		//修改
		else if(flag.equals("update"))
		{
			//1:转换
			String date_time=new SimpleDateFormat("yyyy-MM-dd").format(this.getDatetime());
			//设置
			News news=new News();
			//内容
			
			
			news.setContent(this.getTt());
			//标题:
			news.setTitle(this.getTitle());
			//来源:
			news.setSource(this.getSoure());
			//修改 时间单独修改
			daoInterface.update(news, getId(),date_time);
		}
	
		
		return SUCCESS;
	}
	
	

}
