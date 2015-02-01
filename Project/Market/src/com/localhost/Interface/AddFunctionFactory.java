package com.localhost.Interface;

import com.localhost.Factory.Shop_Factory;

public interface AddFunctionFactory {
	public   Shop_Factory createInstanceof(String className);
}
