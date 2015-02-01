package org.sise.control;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.sise.Dao.DB_Factory;
import org.sise.Dao.Dao_Interface;
import org.sise.bean.News;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
//ɾ�����޸���
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
		//��ȡid-��װ������
		Dao_Interface daoInterface=DB_Factory.getInstance();
		//ɾ��
		if(flag.equals("delete"))
		{
			daoInterface.delete(getId());
		}
		//�޸�
		else if(flag.equals("update"))
		{
			//1:ת��
			String date_time=new SimpleDateFormat("yyyy-MM-dd").format(this.getDatetime());
			//����
			News news=new News();
			//����
			
			
			news.setContent(this.getTt());
			//����:
			news.setTitle(this.getTitle());
			//��Դ:
			news.setSource(this.getSoure());
			//�޸� ʱ�䵥���޸�
			daoInterface.update(news, getId(),date_time);
		}
	
		
		return SUCCESS;
	}
	
	

}
