package cn.courtier.message.Im;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.hibernate.Query;

import cn.courtier.ActionBean.ActionPage;
import cn.courtier.Interf.Message_Interf;
import cn.courtier.Interf.Save_Message;
import cn.courtier.Until.Get_Session;
import cn.courtier.Until.SectionPage;
import cn.courtier.po.Bloguser;
import cn.courtier.po.MessageBox;
import cn.courtier.po.Send_Message;

/**
 * @�ӿ�ʵ��˵����ʵ��2���ӿ�.����������
 * @���޸��ߣ�
 * @�޸����ڣ�
 * @�޸�˵����
 * @��˾���ƣ�
 * @���ߣ�Administrator
 * @����ʱ�䣺2014-6-11 ����06:44:16
 * @�汾��V1.0
 */
@Transactional
public class Im_Message implements Message_Interf,Save_Message{
	//�õ�session
	@Resource(name="session_All")
	private  Get_Session get_session;
	
////////////////////////////////////////////////��ҳ����//////////////////////////////////////////////////////////////////////////////////
	public void delete_Message(int id) {
		
		MessageBox box=(MessageBox) get_session.getSession().load(MessageBox.class, id);
		get_session.getSession().delete(box);
	}

	public void save_Message(MessageBox messageBox) {
		
		messageBox.setReply_Time(String.valueOf(new Date().getTime()));
		get_session.getSession().save(messageBox);
	}

	public SectionPage show_Message(ActionPage actionPageBean) {
		SectionPage sectionPage=new SectionPage(actionPageBean, get_session.getSession(), "select new cn.courtier.ActionBean.ActionMessageBox" +
				"(m.m_Id,m.u_Id.u_Id,m.u_Id.u_Name,m.u_Type,m.u_Id.u_Pic,m.reply_Time,m.reply_Content,m.reply_Status) from MessageBox m order by m.reply_Time desc",2,null);
		return sectionPage;
	}

	public void update_Message(int i,MessageBox messageBox) {
		
		MessageBox box=(MessageBox) get_session.getSession().load(MessageBox.class, i);
		box.setReply_Content(messageBox.getReply_Content());
		box.setReply_Time(messageBox.getReply_Time());
		box.setU_Id(messageBox.getU_Id());
		//�Ƿ�Ϊ����Ա����?
		if(messageBox.getU_Type()==0)box.setU_Type(0);else box.setU_Type(1);
		get_session.getSession().save(box);
			
	}

	////////////////////////////////////////////////�û�����//////////////////////////////////////////////////////////////////////////////////

	public SectionPage show_Save_Message(ActionPage actionPageBean,int id) {
		// TODO Auto-generated method stub
		
		SectionPage page=new SectionPage(actionPageBean,get_session.getSession(),"select new cn.courtier.ActionBean.ActionSaveMessage(s.give_message_name,s.image,s.msg_Content) from Send_Message s where s.save_M.u_Id="+id,3,String.valueOf(id));
		
		return page;
	}
	
	public void delete_Save_Message(Send_Message message) {
		get_session.getSession().delete(message);
		
	}

	public void Save_save_Message(Send_Message message) {
		get_session.getSession().save(message);
		
	}

}
