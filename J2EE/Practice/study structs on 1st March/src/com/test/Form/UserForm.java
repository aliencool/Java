package com.test.Form;

import java.lang.reflect.Field;

import org.apache.struts.action.ActionForm;

public class UserForm extends ActionForm{
	/**
	 *  set get:�����д���������Ӧ
	 */
	private static final long serialVersionUID = 1L;
	private String Username;
	private String password;
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
		
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
