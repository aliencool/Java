package Set_Contructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Set_Contructor {
	public  static void main(String[] args)
	{
		//Web��·�� �����ļ��� 
		//Path����src ApplicationContext ���ϼ���
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("Applicationcontext.xml");
		PersonService person=(PersonService) applicationContext.getBean("ps");
		person.execute();
	}
}
