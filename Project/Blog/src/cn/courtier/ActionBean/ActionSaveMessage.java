package cn.courtier.ActionBean;

/**
 * @�๦��˵�����û�����ʵ��
 * @���޸��ߣ�
 * @�޸����ڣ�
 * @�޸�˵����
 * @��˾���ƣ�
 * @���ߣ�Administrator
 * @����ʱ�䣺2014-6-14 ����09:10:52
 * @�汾��V1.0
 */
public class ActionSaveMessage {
	private String give_message_name;
	private String image;
	private String msg_Content;

	
	public String getGive_message_name() {
		return give_message_name;
	}


	public String getImage() {
		return image;
	}


	public String getMsg_Content() {
		return msg_Content;
	}


	public void setGive_message_name(String giveMessageName) {
		give_message_name = giveMessageName;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public void setMsg_Content(String msgContent) {
		msg_Content = msgContent;
	}


	public ActionSaveMessage(String giveMessageName, String image,
			String msgContent) {
		super();
		give_message_name = giveMessageName;
		this.image = image;
		msg_Content = msgContent;
	}
	
	
}
