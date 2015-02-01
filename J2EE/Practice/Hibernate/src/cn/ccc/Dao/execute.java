package cn.ccc.Dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.ccc.bean.User;
import cn.ccc.until.hibernateuntil;
/*2014年4月12日16:44:32
 * 实现操作
 * 使用静态直接操作
 * */
public class execute implements Implement{
	private Session s=null;
	private Transaction transaction=null;
	
	@Override
	public void save(User u) {
		if(u!=null)
		{
			try{
				//得到持久对象
				 s=hibernateuntil.getS();
				//开启事务,使用persist不需使用
				 transaction=s.beginTransaction();
				//保存 之前，可做任何修改，因为，他是持久对象
				s.save(u);
				
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
		else
		{
			System.out.println("ERROR:The u is null");
		}
		
	}
	
	@Override
	public void Update(User u) {
		if(u!=null)
		{
			try{
				//得到持久对象
				 s=hibernateuntil.getS();
				//开启事务,使用persist不需使用
				 transaction=s.beginTransaction();
				//保存 之前，可做任何修改，因为，他是持久对象
				s.update(u);
				
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
		else
		{
			System.out.println("ERROR:The u is null");
		}
		
		
	}

	@Override
	public void delete(User u) {
		if(u!=null)
		{
			try{
				//得到持久对象
				 s=hibernateuntil.getS();
				//开启事务,使用persist不需使用
				 transaction=s.beginTransaction();
				//保存 之前，可做任何修改，因为，他是持久对象
				s.delete(u);
				
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
		else
		{
			System.out.println("ERROR:The u is null");
		}
		
	}

	@Override
	public User search(int id) {
			
			User u=null;
		
				//得到持久对象
				s=hibernateuntil.getS();
				
				//得到对象  先找 xml 再找hbm.xml 进行给的
				u=(User) s.get(User.class, 1);
					
				return u;
			
	}
}
