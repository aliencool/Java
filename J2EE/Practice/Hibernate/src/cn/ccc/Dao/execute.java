package cn.ccc.Dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.ccc.bean.User;
import cn.ccc.until.hibernateuntil;
/*2014��4��12��16:44:32
 * ʵ�ֲ���
 * ʹ�þ�ֱ̬�Ӳ���
 * */
public class execute implements Implement{
	private Session s=null;
	private Transaction transaction=null;
	
	@Override
	public void save(User u) {
		if(u!=null)
		{
			try{
				//�õ��־ö���
				 s=hibernateuntil.getS();
				//��������,ʹ��persist����ʹ��
				 transaction=s.beginTransaction();
				//���� ֮ǰ�������κ��޸ģ���Ϊ�����ǳ־ö���
				s.save(u);
				
				transaction.commit();
				
			}catch(HibernateException e)
			{
				if(transaction!=null)
				{
					//����ع�
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
				//�õ��־ö���
				 s=hibernateuntil.getS();
				//��������,ʹ��persist����ʹ��
				 transaction=s.beginTransaction();
				//���� ֮ǰ�������κ��޸ģ���Ϊ�����ǳ־ö���
				s.update(u);
				
				transaction.commit();
				
			}catch(HibernateException e)
			{
				if(transaction!=null)
				{
					//����ع�
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
				//�õ��־ö���
				 s=hibernateuntil.getS();
				//��������,ʹ��persist����ʹ��
				 transaction=s.beginTransaction();
				//���� ֮ǰ�������κ��޸ģ���Ϊ�����ǳ־ö���
				s.delete(u);
				
				transaction.commit();
				
			}catch(HibernateException e)
			{
				if(transaction!=null)
				{
					//����ع�
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
		
				//�õ��־ö���
				s=hibernateuntil.getS();
				
				//�õ�����  ���� xml ����hbm.xml ���и���
				u=(User) s.get(User.class, 1);
					
				return u;
			
	}
}
