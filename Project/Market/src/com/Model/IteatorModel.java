package com.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.Bean.ShopBean;
import com.Bean.ShopCarBean;
import com.Bean.ShopItemBean;

@SuppressWarnings("serial")
public class IteatorModel extends TagSupport{
	private Iterator<ShopBean> iteator=null;
	private String shopid=null;
	private ShopBean shop_mes=null;
	
	public void putsession()
	{
		if(shop_mes!=null)
		{
			pageContext.setAttribute(shopid,shop_mes);
		}
	}

	public void setIteator(Collection<ShopBean> shopBeans) {
		iteator=shopBeans.iterator();
	}



	public void setShopid(String shopid) {
		this.shopid = shopid;
	}	
	
	/*
	 *��Ϊ,ÿ��ִ���궼��ȥҳ�����,����,���ر�ǩ��ʹ��һ�� 
	 * */
	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		if(iteator.hasNext())
		{
			shop_mes=iteator.next();//ÿ�εõ�һ��Bean;
		}
		else
		{
			return SKIP_BODY;
		}
		putsession();
		return EVAL_BODY_INCLUDE;
	}
	@Override
	public int doAfterBody() throws JspException {
		// TODO Auto-generated method stub
		if(iteator.hasNext())
		{
			shop_mes=iteator.next();//ÿ�εõ�һ��Bean;
		}
		else
		{
			return SKIP_BODY;
		}
		putsession();
		return EVAL_BODY_AGAIN;
	}

	
	
	


}
