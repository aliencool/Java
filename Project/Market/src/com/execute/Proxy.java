package com.execute;

import java.lang.reflect.Constructor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.localhost.Factory.CreateFactoryreflect;
import com.localhost.Factory.Shop_Factory;
import com.localhost.Interface.AddFunctionFactory;
import com.localhost.Interface.Shop_cr;

public class Proxy implements AddFunctionFactory{
	private static CreateFactoryreflect factoryreflect=new CreateFactoryreflect();
	
	public Shop_Factory createInstanceof(String className) {
		// TODO Auto-generated method stub
		return factoryreflect.createInstanceof(className);
	}

}
