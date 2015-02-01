package com.localhost.Factory;

import java.lang.reflect.Constructor;

import com.localhost.Interface.AddFunctionFactory;

public class CreateFactoryreflect implements AddFunctionFactory{

	public Shop_Factory createInstanceof(String className) {
		// TODO Auto-generated method stub
		Shop_Factory shopFactory=null;
		try {
			Class class1=Class.forName(className);
			Constructor constructor=class1.getConstructor(null);
			shopFactory=(Shop_Factory)constructor.newInstance(null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return shopFactory;	
	}

}
