package cn.courtier.po;



/**
 * @�๦��˵�������԰�po
 * @���޸��ߣ�
 * @�޸����ڣ�
 * @�޸�˵����
 * @��˾���ƣ�
 * @���ߣ�Administrator
 * @����ʱ�䣺2014-6-7 ����05:19:43
 * @�汾��V1.0
 */
public class MessageBox {
	private int m_Id;
	//user 1....n��Ϣ
	private Bloguser u_Id;
	//0:��ͨ�û� 1:����Ա�û�
	private int u_Type;
	//�����洢ʱ��Сʱ����˵���û���������
	private String u_Hour;
	private String reply_Time;
	private String reply_Content;
	//�Ƿ��Ѿ���
	private int  reply_Status;
	
	
	
	public String getU_Hour() {
		return u_Hour;
	}
	public void setU_Hour(String uHour) {
		u_Hour = uHour;
	}
	public int getM_Id() {
		return m_Id;
	}
	public Bloguser getU_Id() {
		return u_Id;
	}
	public int getU_Type() {
		return u_Type;
	}
	public String getReply_Time() {
		return reply_Time;
	}
	public String getReply_Content() {
		return reply_Content;
	}
	public int getReply_Status() {
		return reply_Status;
	}
	public void setM_Id(int mId) {
		m_Id = mId;
	}
	public void setU_Id(Bloguser uId) {
		u_Id = uId;
	}
	public void setU_Type(int uType) {
		u_Type = uType;
	}
	public void setReply_Time(String replyTime) {
		reply_Time = replyTime;
	}
	public void setReply_Content(String replyContent) {
		reply_Content = replyContent;
	}
	public void setReply_Status(int replyStatus) {
		reply_Status = replyStatus;
	}
	
	
}
