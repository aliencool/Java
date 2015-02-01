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
	private Transaction transaction=null;//��ѯ����Ҫ����

	public Dao_Imple() {
		//��������
		this.connection = new Dao_Connection();
		//����session
		session=connection.getSession();
	}
	
	
	
	
	//ɾ������
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		try{
			//1:��������:
			transaction=session.beginTransaction();
			//1.1:����
			String hql="delete from News where id="+id;
			//2:ɾ������:
			Query query=session.createQuery(hql);
			query.executeUpdate();
			//3:�ύ����:
			transaction.commit();
			}catch(TransactionalException e)
			{
				//�����쳣�ع�
				transaction.rollback();
				throw e;
			}
			return true;
	}
	//����
	public boolean insert(News nb) {
		// TODO Auto-generated method stub
		try{//1:��������:
		transaction=session.beginTransaction();
		//2:��������:
		session.save(nb);
		System.out.println("image:"+nb.getImag_url());
		//3:�ύ����:
		transaction.commit();
		}catch(TransactionalException e)
		{
			//�����쳣�ع�
			transaction.rollback();
			throw e;
		}
		return true;
	}
	//����
	public boolean update(News nb,int id,String time) {
		// TODO Auto-generated method stub
		try{//1:��������:
		transaction=session.beginTransaction();
		//2:��������:
		String sql="Update News set title='"+nb.getTitle()+"',content='"+nb.getContent()+"',source='"+nb.getSource()+"',issue_time='"+time+"' where id="+id;
		System.out.println(sql);
		//����
		Query query=session.createQuery(sql);
		query.executeUpdate();
	
		//3:�ύ����:
		transaction.commit();
		}catch(TransactionalException e)
		{
			//�����쳣�ع�
			transaction.rollback();
			throw e;
		}
		return true;
	}
	
	
	//��ѯȫ������
	public List All_search() {
		//��ѯ����
		String sql="from News"+" order by issue_time asc";
		//��ѯ
		Query query=session.createQuery(sql);
		//����list
		List<News> list=query.list();
		return list;
	}
	//��ѯ�ض����� id 
	public News Part_search_id(String id) {
		//�жϲ�ѯ����
		String sql="";
		sql="from News where id="+id;
		
		//��ѯ
		Query query=session.createQuery(sql);
		return (News)query.uniqueResult();
	}
	//��ѯ�ض����� title 
	public List Part_search_title(String title) {
		//�жϲ�ѯ����
		String sql="";
		sql="from News where title like '%"+title+"%'";
		
		//��ѯ
		Query query=session.createQuery(sql);
		return query.list().subList(0, 3);
	}
	
	
	//ģ����ѯ
	/*@param:text:ָ������
	 * @param:time_max:���ʱ��
	 * @param:time_max:��Сʱ��
	  */
	public List<News> like_search(String condition,String text,String time_max,String time_min) {
		//�жϲ�ѯ����
		String sql="";
		if(condition.equals("Time"))
		{
			sql="select title from News where issue_time in ('"+time_min+"'"+time_max+"')";
		}else if(condition.equals("Title"))
		{
			sql="select title from News where title like '"+text+"%'";
		}
		System.out.println(sql);
		//��ѯ
		Query query=session.createQuery(sql);
		return query.list().subList(0, 2);
	}


	//��ѯ����
	public List All_search_four() {
		//��ѯ����
		String sql="from News"+" order by issue_time asc";
		//��ѯ
		Query query=session.createQuery(sql);
		//����list
		List<News> list=query.list().subList(0, 4);
		return list;
	}

}

