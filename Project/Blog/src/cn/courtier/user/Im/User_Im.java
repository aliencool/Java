package cn.courtier.user.Im;

import javax.annotation.Resource;

import org.hibernate.Query;

import cn.courtier.Interf.User_Interf;
import cn.courtier.Until.Get_Session;
import cn.courtier.po.Bloguser;

/**
 * @�๦��˵�����û��������޸�ʵ����
 * @���޸��ߣ�
 * @�޸����ڣ�
 * @�޸�˵����
 * @��˾���ƣ�
 * @���ߣ�Administrator
 * @����ʱ�䣺2014-6-10 ����09:46:28
 * @�汾��V1.0
 */
public class User_Im implements User_Interf{

	@Resource(name="session_All")
	private  Get_Session get_session;
	
	public void insertUser(Bloguser actionuser) {
		// TODO Auto-generated method stub
		get_session.getSession().save(actionuser);
	}

	public void updateUser(Bloguser actionUser, int id) {
		//Ϊ�� ���޸�
		if(actionUser==null)return;
		if((actionUser.getU_Password()==null||actionUser.getU_Password().equals(""))&&(actionUser.getU_Pic()==null||actionUser.getU_Pic().equals("")))return;
			
		
			//1:������������
			get_session.getSession().createQuery("update Bloguser set " +
					"u_Nickname='"+actionUser.getU_Nickname()+
					"',u_Email='"+actionUser.getU_Email()+
					"',u_City='"+actionUser.getU_City()+
					"',u_Birthday='"+actionUser.getU_Birthday()+
					"',u_Pic='"+actionUser.getU_Pic()+
					"',u_Sign='"+actionUser.getU_Sign()+
					"',u_Password='"+actionUser.getU_Password()
					+"' where u_Id="+id
			).executeUpdate();
			
			
		
		
	
	}
	
	
	//flag:0 ��½,flag:1 ��ѯ
	public Bloguser selectUser(Bloguser actionUser,int flag) {
		Query query=null;
		if(flag==0)
		{
			query= get_session.getSession().createQuery("from Bloguser where u_Name=:name and u_Password=:password");
			
			query.setParameter("name", actionUser.getU_Name());
			
			query.setParameter("password", actionUser.getU_Password());
		}
		else
		{
			query= get_session.getSession().createQuery("from Bloguser where u_Id=:u_Id");
			
			query.setParameter("u_Id", actionUser.getU_Id());
		}
		System.out.println("query:"+query);

		//�õ�list��Ϊ��
		if(query.list().size()==0) return null;
		System.out.println("list"+query.list());
		return (Bloguser) query.list().get(0);
	}
	
	
	//flag:0 ����û�����1��ʾ�������
	public String checkUser(Bloguser bloguser, int flag) {
		Query query;
		if(flag==0)
		{
			query=get_session.getSession().createQuery("select u_Name from Bloguser where u_Name=:name");
			query.setParameter("name", bloguser.getU_Name());
		}else
		{
			query=get_session.getSession().createQuery("select u_Password from Bloguser where u_Id=:id");
			//����id�õ�����
			query.setParameter("id", bloguser.getU_Id());
			
			//�������������뵱ǰ���벻һ��
			if(!((String)query.uniqueResult()).equals(bloguser.getU_Password())){
				return null;
				
			}
		}
		return (String) query.uniqueResult();
	}
   
}
