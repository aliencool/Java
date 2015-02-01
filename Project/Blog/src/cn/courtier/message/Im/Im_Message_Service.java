package cn.courtier.message.Im;

import javax.annotation.Resource;

import cn.courtier.ActionBean.ActionPage;
import cn.courtier.Interf.Message_Interf;
import cn.courtier.Interf.Save_Message;
import cn.courtier.Until.SectionPage;
import cn.courtier.po.Bloguser;
import cn.courtier.po.MessageBox;
import cn.courtier.po.Send_Message;

public class Im_Message_Service implements Message_Interf,Save_Message{

	@Resource(name="messageIm")
	private Message_Interf messageInterf;
	@Resource(name="messageIm")
	private Save_Message saveMessage;
	
	public void delete_Message(int id) {
		// TODO Auto-generated method stub
		messageInterf.delete_Message(id);
	}

	public void save_Message(MessageBox messageBox) {
		// TODO Auto-generated method stub
		messageInterf.save_Message(messageBox);
	}

	public SectionPage show_Message(ActionPage actionPageBean) {
		// TODO Auto-generated method stub
		return messageInterf.show_Message(actionPageBean);
	}

	public void update_Message(int i,MessageBox messageBox) {
		// TODO Auto-generated method stub
		messageInterf.update_Message(i,messageBox);
	}

	public void delete_Save_Message(Send_Message message) {
		// TODO Auto-generated method stub
		saveMessage.delete_Save_Message(message);
	}

	public SectionPage show_Save_Message(ActionPage actionPageBean,int id) {
		// TODO Auto-generated method stub
		return saveMessage.show_Save_Message(actionPageBean,id);
	}

	public void Save_save_Message(Send_Message message) {
		// TODO Auto-generated method stub
		saveMessage.Save_save_Message(message);
	}

}
