package cn.courtier.ActionControl;


import java.util.Date;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import com.opensymphony.xwork2.ActionSupport;
import cn.courtier.ActionBean.ActionPage;
import cn.courtier.Until.SectionPage;
import cn.courtier.message.Im.Im_Message_Service;
import cn.courtier.po.Bloguser;
import cn.courtier.po.MessageBox;



/**
 * @�๦��˵�������Դ���
 * @���޸��ߣ�
 * @�޸����ڣ�
 * @�޸�˵����
 * @��˾���ƣ�
 * @���ߣ�Administrator
 * @����ʱ�䣺2014-6-14 ����10:28:38
 * @�汾��V1.0
 */
public class MessageAction extends ActionSupport{
	/**
	 *@������ʵ�����԰汣����鿴
	 *@������{todo}
	 */
	
	private static final long serialVersionUID = 1L;
	private int id;
	private MessageBox messageBox;
	private Bloguser bloguser;
	//-2: ����ҳ -1:��ϸ�б� 0:���� 1:���� 
	private int flag;
	
	@Resource(name="page")
	private ActionPage actionPageBean;
	@Resource(name="messageService")
	private Im_Message_Service messageService;
	@Autowired  
	private  HttpServletRequest request; 

	
	
	public ActionPage getActionPageBean() {
		return actionPageBean;
	}

	public void setActionPageBean(ActionPage actionPageBean) {
		this.actionPageBean = actionPageBean;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public Bloguser getBloguser() {
		return bloguser;
	}

	public void setBloguser(Bloguser bloguser) {
		this.bloguser = bloguser;
	}

	public MessageBox getMessageBox() {
		return messageBox;
	}

	public void setMessageBox(MessageBox messageBox) {
		this.messageBox = messageBox;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
	

	@Override
	public String execute() throws Exception {
		
		switch(flag)
		{
		case -2:return "help";
		case -1:
			SectionPage messagelist=messageService.show_Message(actionPageBean);
			//����ʱ��
			
			
			request.setAttribute("messagebox", messagelist.get_section_MessageBox());
			
			request.setAttribute("count", messagelist.total_Page());
			
		
			return "messageList";
		case 0:
			SectionPage message=messageService.show_Message(actionPageBean);
			
			
			message=messageService.show_Message(actionPageBean);
		
		
			request.setAttribute("messagebox", message.get_section_MessageBox());
			
			return "message";
		case 1:
			
			
			messageBox.setReply_Time(String.valueOf(new Date().getTime()));
			
			messageService.save_Message(messageBox);
			
			return NONE;

		}
		
		
		return SUCCESS;
	}
	

	
	
}
