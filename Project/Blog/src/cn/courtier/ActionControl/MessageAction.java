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
 * @类功能说明：留言处理
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @公司名称：
 * @作者：Administrator
 * @创建时间：2014-6-14 下午10:28:38
 * @版本：V1.0
 */
public class MessageAction extends ActionSupport{
	/**
	 *@类名：实现留言版保存与查看
	 *@描述：{todo}
	 */
	
	private static final long serialVersionUID = 1L;
	private int id;
	private MessageBox messageBox;
	private Bloguser bloguser;
	//-2: 帮助页 -1:详细列表 0:进入 1:保存 
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
			//设置时间
			
			
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
