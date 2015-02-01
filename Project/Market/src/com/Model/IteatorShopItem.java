package com.Model;

import java.util.Collection;
import java.util.Iterator;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.Bean.ShopCarBean;
import com.Bean.ShopItemBean;

/*
 * �����Ϊ�˻�������ͼ۸�
 * */

public class IteatorShopItem extends TagSupport{
	private ShopItemBean shopItemBean=null;
	private ShopCarBean shopCarBean=null;
	private Iterator<ShopItemBean> iterator=null;
	private String id;

	public void setId(String id) {
		this.id = id;
	}
	
	public void setShopCarBean(ShopCarBean shopCarBean) {
		this.shopCarBean = shopCarBean;
		
		Collection<ShopItemBean> itemBeans=shopCarBean.shopAllBeans();
		
		if(itemBeans!=null)
		{
			
			iterator=itemBeans.iterator();
		}
	}

	/**/
	@Override
	public int doAfterBody() throws JspException {
		// TODO Auto-generated method stub
		if(iterator.hasNext())
		{
			shopItemBean=iterator.next();
		}
		else
		{
			return SKIP_BODY;
		}
		putAttribute();
		return EVAL_BODY_AGAIN;
	}

	/*��һ�Σ��ͱ������
	 * ��Ϊ����һ����ɺ��������
	 * */
	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		if(iterator.hasNext())
		{
			shopItemBean=iterator.next();
		}
		else
		{
			return SKIP_BODY;
		}
		putAttribute();
		return EVAL_BODY_INCLUDE;
	}
	
	
	public void putAttribute()
	{
		if(shopItemBean!=null)
		{
			
			pageContext.setAttribute(id, shopItemBean);
		}
	}
	
	
	
}
