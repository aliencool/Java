package cn.courtier.ActionBean;

/**
 * @类功能说明：用户留言实体
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @公司名称：
 * @作者：Administrator
 * @创建时间：2014-6-14 下午09:10:52
 * @版本：V1.0
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
