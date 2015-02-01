package cn.courtier.po;


/**
 * @类功能说明：给会员留言信息
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @公司名称：
 * @作者：Administrator
 * @创建时间：2014-6-7 下午05:14:20
 * @版本：V1.0
 */
public class Send_Message {
	private int sm_Id;
	
	//当前用户留言表
	private Bloguser save_M;
	//谁给当前用户留言
	private String give_message_name;
	private String send_Time;
	private String msg_Content;
	//留言者图片
	private String image;
	//flag:表示是否已经读取 0:未读 1:已读
	private int flag;
	
	
	
	

	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getGive_message_name() {
		return give_message_name;
	}

	public void setGive_message_name(String giveMessageName) {
		give_message_name = giveMessageName;
	}

	public int getSm_Id() {
		return sm_Id;
	}

	public String getSend_Time() {
		return send_Time;
	}
	public String getMsg_Content() {
		return msg_Content;
	}
	public void setSm_Id(int smId) {
		sm_Id = smId;
	}
	
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	

	public Bloguser getSave_M() {
		return save_M;
	}

	public void setSave_M(Bloguser saveM) {
		save_M = saveM;
	}

	public void setSend_Time(String sendTime) {
		send_Time = sendTime;
	}
	public void setMsg_Content(String msgContent) {
		msg_Content = msgContent;
	}
	
	
}
