package cn.courtier.user.Im;

import javax.annotation.Resource;

import org.hibernate.Query;

import cn.courtier.Interf.User_Interf;
import cn.courtier.Until.Get_Session;
import cn.courtier.po.Bloguser;

/**
 * @类功能说明：用户增加与修改实现类
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @公司名称：
 * @作者：Administrator
 * @创建时间：2014-6-10 下午09:46:28
 * @版本：V1.0
 */
public class User_Im implements User_Interf{

	@Resource(name="session_All")
	private  Get_Session get_session;
	
	public void insertUser(Bloguser actionuser) {
		// TODO Auto-generated method stub
		get_session.getSession().save(actionuser);
	}

	public void updateUser(Bloguser actionUser, int id) {
		//为空 不修改
		if(actionUser==null)return;
		if((actionUser.getU_Password()==null||actionUser.getU_Password().equals(""))&&(actionUser.getU_Pic()==null||actionUser.getU_Pic().equals("")))return;
			
		
			//1:更新所有属性
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
	
	
	//flag:0 登陆,flag:1 查询
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

		//得到list是为空
		if(query.list().size()==0) return null;
		System.out.println("list"+query.list());
		return (Bloguser) query.list().get(0);
	}
	
	
	//flag:0 检测用户名，1表示检测密码
	public String checkUser(Bloguser bloguser, int flag) {
		Query query;
		if(flag==0)
		{
			query=get_session.getSession().createQuery("select u_Name from Bloguser where u_Name=:name");
			query.setParameter("name", bloguser.getU_Name());
		}else
		{
			query=get_session.getSession().createQuery("select u_Password from Bloguser where u_Id=:id");
			//根据id拿到密码
			query.setParameter("id", bloguser.getU_Id());
			
			//传过来的密码与当前密码不一致
			if(!((String)query.uniqueResult()).equals(bloguser.getU_Password())){
				return null;
				
			}
		}
		return (String) query.uniqueResult();
	}
   
}
