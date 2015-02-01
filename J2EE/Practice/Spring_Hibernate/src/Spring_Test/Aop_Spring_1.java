package Spring_Test;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;



public class Aop_Spring_1 {

	
	
	
	public void before(String u)
	{
		System.out.println("我是前置通知:"+u);
	}
	
	
	public void after(String u)
	{
		System.out.println("我是后置通知:"+u);
	}
	
	
	public void Final_after()
	{
		System.out.println("我是最终通知");
	}
	
	
	
	public void throwing()
	{
		System.out.println("我是例外通知");
	}
	
	

	public Object around(ProceedingJoinPoint point)
	{
		Object object=null;
		try {
			if(point.getArgs()[0].equals("sise"))
			{
				object=point.proceed();
			}
			else
			{
				System.out.println("权限不足");
			}
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return object;
	}
	
}
