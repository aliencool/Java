package Dao;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JUNIT_Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("Application.xml");
		System.out.println(applicationContext);
		I_operation implOperation=(I_operation) applicationContext.getBean("Im_op");
		
		//����
		student beanStu=new student();
		beanStu.setAge(20);
		beanStu.setSex("M");
		beanStu.setSname("zs");
		beanStu.setSno("1140");
		
		implOperation.insert_stu(beanStu);
		
		student beanStu1=new student();
		beanStu1.setAge(20);
		beanStu1.setSex("M");
		beanStu1.setSname("xm");
		beanStu1.setSno("1141");
		
		implOperation.insert_stu(beanStu1);
		
		student beanStu2=new student();
		beanStu2.setAge(20);
		beanStu2.setSex("M");
		beanStu2.setSname("xj");
		beanStu2.setSno("1142");
		
		implOperation.insert_stu(beanStu2);
		
		//ɾ��
		//ɾ��zs
		implOperation.delete_stu(beanStu);
		
		//����
		//beanStu1.setSname("mv");
		implOperation.update_stu(beanStu1);
		
		List<student> list=implOperation.get_stu();
		
		for(student stu:list)
		{
			System.out.println("ѧ��:"+stu.getSno()+",����:"+stu.getSname()+",�Ա�:"+stu.getSex()+",����"+stu.getAge());
		}
	}

}
