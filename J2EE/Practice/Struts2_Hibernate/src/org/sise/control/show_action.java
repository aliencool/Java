package org.sise.control;

import org.sise.Dao.DB_Factory;
import org.sise.Dao.Dao_Interface;
import org.sise.bean.News;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
//������
public class show_action extends ActionSupport{
	private int id;
	private News news;
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
		news=daoInterface.Part_search_id(String.valueOf(id));
		//�Ž�session
		ActionContext.getContext().getSession().put("news", news);
		
		return SUCCESS;
	}
	
	

}
