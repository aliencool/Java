package com.test.action;
/*2014��3��1��13:31:23
 * ѧϰstructs
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
	 * 1 ����̳�action
	 * 2 form��������кܶ������ˣ�����ֱ��ǿת 
	 * 3 mapping:findforward����ת
	 * 4 ÿ�ζ������
	 * 5 ǿ��ת��
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
