package until;


import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.*;
import Bean.Account;
import Bean.Nickname;



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
			 session=HibernateUntil.getSession();
			//开启事务,使用persist不需使用
			 transaction=session.beginTransaction();
			//保存 之前，可做任何修改，因为，他是持久对象
			Nickname user=new Nickname();
			 user.setNickname_name("ccc");
			 user.setNickname_password("123434457");
			 
			 
			 
			 Account account=new Account();
			 account.setAct_no("111");
			 account.setBal(888888.88);
			 account.setNickname(user);
			 
			 Account account1=new Account();
			 account1.setAct_no("222");
			 account1.setBal(888888.88);
			 account.setNickname(user);
			 
			 Account account2=new Account();
			 account2.setAct_no("333");
			 account2.setBal(888888.88);
			 account.setNickname(user);
			 
			user.getAccount().add(account);
			user.getAccount().add(account1);
			user.getAccount().add(account2);
			 
			session.save(user);
			session.save(account);
			session.save(account1);
			session.save(account2);
			
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
	
	public static void search()
	{
		try{
			//得到持久对象
			 session=HibernateUntil.getSession();
			//开启事务,使用persist不需使用
			 transaction=session.beginTransaction();
			 //Hql
			 String hql="from Nickname ";

			 Query query=session.createQuery(hql);
			 
			 List list=query.list();
			 Set set=null;
			 Iterator iterator;
			for(int i=0;i<list.size();i++)
			{
				System.out.println(((Nickname)list.get(i)).getUser_id());
				System.out.println(((Nickname)list.get(i)).getNickname_name());
				set=((Nickname)list.get(i)).getAccount();
				iterator=set.iterator();
				
				while(iterator.hasNext())
				{
					Account account=(Account) iterator.next();
					System.out.println(account.getBal());
				}
				
			}
			
			
			 
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
