package com.Model;

import java.io.IOException;
import java.text.MessageFormat;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

import com.Bean.PageBean;


/*
 * ���ڼ���ҳ��
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
		//ÿ�ζ����¼���
		count=0;
		//ÿ�ζ�Ҫ���»�ȡ
		All_count=ShopDBBean.Total_Page;
	}


	public void setId(String id) {
		this.id = id;
	}


	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		//���,ҳ��С�ڵ�ǰ
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
