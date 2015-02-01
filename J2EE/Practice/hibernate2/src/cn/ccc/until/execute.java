package cn.ccc.until;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.ccc.bean.Person;
import cn.ccc.bean.Student;
import cn.ccc.bean.Teacher;

public class execute {

	/**
	 * @param args
	 */
	private static Session session=null;
	private static Transaction transaction=null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test:
		
		
		try{
			//得到持久对象
			 session=until.getSession();
			//开启事务,使用persist不需使用
			 transaction=session.beginTransaction();
			//保存 之前，可做任何修改，因为，他是持久对象
			Person person=new  Person();
			person.setAge(22);
			person.setName("zzz");
			person.setSex("m");
			
			Student s=new Student();
			s.setSchool("www");
			s.setSno("111");
			
			Teacher teacher=new Teacher();
			teacher.setSalary(100000.88);
			teacher.setNo("1111");
			
			session.save(person);
			session.save(s);
			session.save(teacher);
			
			transaction.commit();
			
		}catch(HibernateException e)
		{
			if(transaction!=null)
			{
				//出错回滚
				transaction.rollback();
			}
			throw e;
		}
		
		
	}

}
