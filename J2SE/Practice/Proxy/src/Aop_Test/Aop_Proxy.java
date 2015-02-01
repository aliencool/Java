package Aop_Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Aop_Proxy implements InvocationHandler{
	
	private Object target;
	
	
	
	public Aop_Proxy(Object target) {
		super();
		this.target = target;
	}

	public Object getInstance()
	{
		System.out.println(target.getClass().getInterfaces().toString());
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),this);
		
		
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		System.out.println(args);
		method.invoke(target, args);
		return null;
	}
}
