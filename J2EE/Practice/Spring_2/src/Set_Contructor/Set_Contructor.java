package Set_Contructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Set_Contructor {
	public  static void main(String[] args)
	{
		//Web的路径 整个文件夹 
		//Path的是src ApplicationContext 马上加载
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("Applicationcontext.xml");
		PersonService person=(PersonService) applicationContext.getBean("ps");
		person.execute();
	}
}
