package org.xml.control;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.xml.bean.Data_Bean;
import org.xml.model.Dao_Implement;
import org.xml.model.transxml;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class trans_xml extends ActionSupport{
	private String dbname;
	public String getDbname() {
		return dbname;
	}
	public void setDbname(String dbname) {
		this.dbname = dbname;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		//step 1:得到数据源:
		Data_Bean bean=new Dao_Implement().getColumn_Name(dbname);
		//step 2:转换
		transxml.trans(bean, dbname, "myzh",ServletActionContext.getRequest().getRealPath("/upload"));
		
		return SUCCESS;
	}
	
	
	
}
