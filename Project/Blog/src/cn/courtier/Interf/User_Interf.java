package cn.courtier.Interf;


import cn.courtier.po.Bloguser;

/**
 * @接口功能说明：用户的增加和修改
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @公司名称：
 * @作者：Administrator
 * @创建时间：2014-6-10 下午09:45:38
 * @版本：V1.0
 */
public interface User_Interf {
	public void insertUser(Bloguser actionuser);
	public void updateUser(Bloguser actionUser,int id);
	//0:表示登陆 1:表示查看
	public Bloguser selectUser(Bloguser actionUser,int flag);
	//0:表示检测用户名 1:表示检测密码
	public String checkUser(Bloguser bloguser,int flag);
}
