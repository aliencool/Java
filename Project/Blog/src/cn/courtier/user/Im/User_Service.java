package cn.courtier.user.Im;

import javax.annotation.Resource;
import cn.courtier.Interf.User_Interf;
import cn.courtier.po.Bloguser;

/**
 * @�๦��˵����User�ķ�����
 * @���޸��ߣ�
 * @�޸����ڣ�
 * @�޸�˵����
 * @��˾���ƣ�
 * @���ߣ�Administrator
 * @����ʱ�䣺2014-6-13 ����08:46:52
 * @�汾��V1.0
 */
public class User_Service implements User_Interf{
     @Resource(name="userIm")
     private User_Interf userIm;
	
	public void insertUser(Bloguser actionuser) {
		// TODO Auto-generated method stub
		userIm.insertUser(actionuser);
	}

	public void updateUser(Bloguser actionUser, int id) {
		// TODO Auto-generated method stub
		userIm.updateUser(actionUser, id);
	}

	public Bloguser selectUser(Bloguser actionUser,int flag) {
		// TODO Auto-generated method stub
		
		return userIm.selectUser(actionUser,flag);
	}

	public String checkUser(Bloguser bloguser, int flag) {
		// TODO Auto-generated method stub
		return userIm.checkUser(bloguser, flag);
	}

}
