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
		System.out.println("����ǰ��֪ͨ:"+u);
	}
	
	
	public void after(String u)
	{
		System.out.println("���Ǻ���֪ͨ:"+u);
	}
	
	
	public void Final_after()
	{
		System.out.println("��������֪ͨ");
	}
	
	
	
	public void throwing()
	{
		System.out.println("��������֪ͨ");
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
				System.out.println("Ȩ�޲���");
			}
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return object;
	}
	
}
