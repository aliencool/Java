package com.test.action;
/*2014年3月1日13:31:23
 * 学习structs
 * */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.test.Form.UserForm;

public class LoginAction extends Action{
	
	@Override
	/*
	 * 1 必须继承action
	 * 2 form：里面具有很多属性了，所以直接强转 
	 * 3 mapping:findforward来跳转
	 * 4 每次都会调用
	 * 5 强制转换
	 * */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		UserForm userForm=(UserForm)form;
		System.out.println(userForm.getPassword().equals("123"));
		if(userForm.getPassword().equals("123"))
		{
			return mapping.findForward("welcome");
		}
		else
		{
			return mapping.findForward("error");
		}
		
	}
	

}
