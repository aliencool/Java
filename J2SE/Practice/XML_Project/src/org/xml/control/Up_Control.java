package org.xml.control;

import java.io.IOException;

import javax.jms.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.SessionAware;
import org.xml.bean.Data_Bean;
import org.xml.model.Dao_Implement;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Up_Control extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		Data_Bean bean=new Dao_Implement().getData_Name();
		ActionContext.getContext().getSession().put("bean_name", bean);
		
		
		
		return SUCCESS;
	}
	
	
	
	
	
}
