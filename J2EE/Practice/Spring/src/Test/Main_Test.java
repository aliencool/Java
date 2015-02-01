package Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import P_Impl.Person_Service;

public class Main_Test {
	public static void main(String []args){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("Applicationcontext.xml");
		Person_Service service_ch=(Person_Service)applicationContext.getBean("service_ch");
		service_ch.say("уехЩ");
		Person_Service service_foreigner=(Person_Service)applicationContext.getBean("service_foreigner");
		service_foreigner.say("Jack");
	}
}
