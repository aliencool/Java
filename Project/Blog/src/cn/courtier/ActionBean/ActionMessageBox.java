package cn.courtier.ActionBean;

import cn.courtier.po.Bloguser;



/**
 * @类功能说明：留言版po
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @公司名称：
 * @作者：Administrator
 * @创建时间：2014-6-7 下午05:19:43
 * @版本：V1.0
 */
public class ActionMessageBox {
	private int m_Id;
	private int u_Id;
	//user 1....n信息
	private String u_Name;
	//0:普通用户 1:管理员用户
	private int u_Type; 
	private String u_Pic;
	private String reply_Time;
	private String reply_Content;
	//是否已经读
	private int  reply_Status;
	
	public int getM_Id() {
		return m_Id;
	}
	public String getU_Pic() {
		return u_Pic;
	}

	public void setU_Pic(String uPic) {
		u_Pic = uPic;
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
	
	public String getU_Name() {
		return u_Name;
	}

	public void setU_Name(String uName) {
		u_Name = uName;
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
	
	
	public int getU_Id() {
		return u_Id;
	}
	public void setU_Id(int uId) {
		u_Id = uId;
	}

	
	
	public ActionMessageBox(int mId, int uId, String uName, int uType, String uPic, String replyTime, String replyContent,
			int replyStatus) {
		super();
		m_Id = mId;
		u_Id = uId;
		u_Name = uName;
		u_Type = uType;
		u_Pic = uPic;
		reply_Time = replyTime;
		reply_Content = replyContent;
		reply_Status = replyStatus;
	}
	
	
	
	
	
	
}
