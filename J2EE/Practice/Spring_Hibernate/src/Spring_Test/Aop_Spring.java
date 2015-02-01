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
	//1:�����е�
	@Pointcut("execution(* Spring_Test.PersonServiceBean.*(..))")
	public void anyMethod(){}
	
	//2:����֪ͨ
	//1:ǰ��֪ͨ
	@Before("anyMethod()&&args(a)")
	public void before()
	{
		System.out.println("����ǰ��֪ͨ:");
	}
	//2:����֪ͨ
	@AfterReturning(pointcut="anyMethod()",returning="result")
	public void after(String result)
	{
		System.out.println("���Ǻ���֪ͨ:"+result);
	}
	//3:����֪ͨ
	@After("anyMethod()")
	public void Final_after()
	{
		System.out.println("��������֪ͨ");
	}
	
	//4:�쳣֪ͨ
	@AfterThrowing("anyMethod()")
	public void throwing()
	{
		System.out.println("��������֪ͨ");
	}
	
	//5:����֪ͨ
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
