package cn.courtier.po;


/**
 * @�๦��˵��������Ա������Ϣ
 * @���޸��ߣ�
 * @�޸����ڣ�
 * @�޸�˵����
 * @��˾���ƣ�
 * @���ߣ�Administrator
 * @����ʱ�䣺2014-6-7 ����05:14:20
 * @�汾��V1.0
 */
public class Send_Message {
	private int sm_Id;
	
	//��ǰ�û����Ա�
	private Bloguser save_M;
	//˭����ǰ�û�����
	private String give_message_name;
	private String send_Time;
	private String msg_Content;
	//������ͼƬ
	private String image;
	//flag:��ʾ�Ƿ��Ѿ���ȡ 0:δ�� 1:�Ѷ�
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
