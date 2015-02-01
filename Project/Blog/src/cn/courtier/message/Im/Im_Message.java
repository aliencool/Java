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
 * @接口实现说明：实现2个接口.处理留言类
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @公司名称：
 * @作者：Administrator
 * @创建时间：2014-6-11 下午06:44:16
 * @版本：V1.0
 */
@Transactional
public class Im_Message implements Message_Interf,Save_Message{
	//得到session
	@Resource(name="session_All")
	private  Get_Session get_session;
	
////////////////////////////////////////////////网页留言//////////////////////////////////////////////////////////////////////////////////
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
		//是否为管理员留言?
		if(messageBox.getU_Type()==0)box.setU_Type(0);else box.setU_Type(1);
		get_session.getSession().save(box);
			
	}

	////////////////////////////////////////////////用户留言//////////////////////////////////////////////////////////////////////////////////

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
