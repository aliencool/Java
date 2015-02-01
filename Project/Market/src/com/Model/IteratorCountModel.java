package com.Model;

import java.io.IOException;
import java.text.MessageFormat;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

import com.Bean.PageBean;


/*
 * 用于计算页数
 * */
public class IteratorCountModel extends TagSupport {
	public int count=0;
	public String id=null;
	public int All_count=ShopDBBean.Total_Page;
	private PageBean pageBean=null;
	
	
	
	@Override
	public void setPageContext(PageContext pageContext) {
		// TODO Auto-generated method stub
		super.setPageContext(pageContext);
		pageBean=new PageBean();
		//每次都重新计算
		count=0;
		//每次都要重新获取
		All_count=ShopDBBean.Total_Page;
	}


	public void setId(String id) {
		this.id = id;
	}


	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		//如果,页数小于当前
		System.out.println("All_count:"+All_count);
		if(count<All_count)
		{
			count++;
			pageBean.setCount(count);
		}
		else
		{
			return	SKIP_BODY;
		}
		 putCount();
		return EVAL_BODY_INCLUDE;
	}
	

	@Override
	public int doAfterBody() throws JspException {
		// TODO Auto-generated method stub
		if(count<All_count)
		{
			count++;
			pageBean.setCount(count);
		}
		else
		{
			return	SKIP_BODY;
		}
		 putCount();
		return EVAL_BODY_AGAIN;
	}
	
	public void putCount()
	{
		
		this.pageContext.setAttribute(id, pageBean);
	}
	
	
}
