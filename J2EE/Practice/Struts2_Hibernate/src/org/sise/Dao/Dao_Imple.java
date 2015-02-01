package org.sise.Dao;

import java.util.List;

import javax.transaction.TransactionalException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.sise.bean.News;

public class Dao_Imple implements Dao_Interface{
	private Dao_Connection connection=null;
	private Session session=null;
	private Transaction transaction=null;//查询不需要事务

	public Dao_Imple() {
		//创建连接
		this.connection = new Dao_Connection();
		//创建session
		session=connection.getSession();
	}
	
	
	
	
	//删除新闻
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		try{
			//1:开启事务:
			transaction=session.beginTransaction();
			//1.1:条件
			String hql="delete from News where id="+id;
			//2:删除数据:
			Query query=session.createQuery(hql);
			query.executeUpdate();
			//3:提交事务:
			transaction.commit();
			}catch(TransactionalException e)
			{
				//出现异常回滚
				transaction.rollback();
				throw e;
			}
			return true;
	}
	//插入
	public boolean insert(News nb) {
		// TODO Auto-generated method stub
		try{//1:开启事务:
		transaction=session.beginTransaction();
		//2:保存数据:
		session.save(nb);
		System.out.println("image:"+nb.getImag_url());
		//3:提交事务:
		transaction.commit();
		}catch(TransactionalException e)
		{
			//出现异常回滚
			transaction.rollback();
			throw e;
		}
		return true;
	}
	//更新
	public boolean update(News nb,int id,String time) {
		// TODO Auto-generated method stub
		try{//1:开启事务:
		transaction=session.beginTransaction();
		//2:更新数据:
		String sql="Update News set title='"+nb.getTitle()+"',content='"+nb.getContent()+"',source='"+nb.getSource()+"',issue_time='"+time+"' where id="+id;
		System.out.println(sql);
		//更新
		Query query=session.createQuery(sql);
		query.executeUpdate();
	
		//3:提交事务:
		transaction.commit();
		}catch(TransactionalException e)
		{
			//出现异常回滚
			transaction.rollback();
			throw e;
		}
		return true;
	}
	
	
	//查询全部新闻
	public List All_search() {
		//查询条件
		String sql="from News"+" order by issue_time asc";
		//查询
		Query query=session.createQuery(sql);
		//返回list
		List<News> list=query.list();
		return list;
	}
	//查询特定新闻 id 
	public News Part_search_id(String id) {
		//判断查询条件
		String sql="";
		sql="from News where id="+id;
		
		//查询
		Query query=session.createQuery(sql);
		return (News)query.uniqueResult();
	}
	//查询特定新闻 title 
	public List Part_search_title(String title) {
		//判断查询条件
		String sql="";
		sql="from News where title like '%"+title+"%'";
		
		//查询
		Query query=session.createQuery(sql);
		return query.list().subList(0, 3);
	}
	
	
	//模糊查询
	/*@param:text:指定内容
	 * @param:time_max:最大时间
	 * @param:time_max:最小时间
	  */
	public List<News> like_search(String condition,String text,String time_max,String time_min) {
		//判断查询条件
		String sql="";
		if(condition.equals("Time"))
		{
			sql="select title from News where issue_time in ('"+time_min+"'"+time_max+"')";
		}else if(condition.equals("Title"))
		{
			sql="select title from News where title like '"+text+"%'";
		}
		System.out.println(sql);
		//查询
		Query query=session.createQuery(sql);
		return query.list().subList(0, 2);
	}


	//查询四条
	public List All_search_four() {
		//查询条件
		String sql="from News"+" order by issue_time asc";
		//查询
		Query query=session.createQuery(sql);
		//返回list
		List<News> list=query.list().subList(0, 4);
		return list;
	}

}

