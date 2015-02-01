package Spring_Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main_Aop {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("Application1.xml");
		PersonService personService=(PersonService)applicationContext.getBean("myservice");
		
		//personService.save("ssds");
		personService.save("sise");
	}

	
	
}
