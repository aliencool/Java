package Spring_Test;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class Aop_Spring {
	//1:定义切点
	@Pointcut("execution(* Spring_Test.PersonServiceBean.*(..))")
	public void anyMethod(){}
	
	//2:各种通知
	//1:前置通知
	@Before("anyMethod()&&args(a)")
	public void before()
	{
		System.out.println("我是前置通知:");
	}
	//2:后置通知
	@AfterReturning(pointcut="anyMethod()",returning="result")
	public void after(String result)
	{
		System.out.println("我是后置通知:"+result);
	}
	//3:最终通知
	@After("anyMethod()")
	public void Final_after()
	{
		System.out.println("我是最终通知");
	}
	
	//4:异常通知
	@AfterThrowing("anyMethod()")
	public void throwing()
	{
		System.out.println("我是例外通知");
	}
	
	//5:环绕通知
	@Around("anyMethod()")
	public Object around(ProceedingJoinPoint point)
	{
		Object object=null;
		try {
			System.out.println(1);
			object=point.proceed();
			System.out.println(2);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return object;
	}
	
}
