package cn.courtier.Interf;


import cn.courtier.po.Bloguser;

/**
 * @�ӿڹ���˵�����û������Ӻ��޸�
 * @���޸��ߣ�
 * @�޸����ڣ�
 * @�޸�˵����
 * @��˾���ƣ�
 * @���ߣ�Administrator
 * @����ʱ�䣺2014-6-10 ����09:45:38
 * @�汾��V1.0
 */
public interface User_Interf {
	public void insertUser(Bloguser actionuser);
	public void updateUser(Bloguser actionUser,int id);
	//0:��ʾ��½ 1:��ʾ�鿴
	public Bloguser selectUser(Bloguser actionUser,int flag);
	//0:��ʾ����û��� 1:��ʾ�������
	public String checkUser(Bloguser bloguser,int flag);
}
