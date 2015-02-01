package cn.courtier.ActionControl;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import cn.courtier.ActionBean.ActionPage;
import cn.courtier.message.Im.Im_Message_Service;
import cn.courtier.po.Send_Message;

import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;

/**
 * @类功能说明：
 * 1:Json无刷新分页 使用JsonArray 来进行分页提高分页效率 生成JSonArray 赋值 然后配置
 * 2:表示用户提交的留言保存进入数据库
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @公司名称：
 * @作者：Administrator
 * @创建时间：2014-6-14 下午10:43:56
 * @版本：V1.0
 */
public class JsonPage extends ActionSupport {
	/**
	 *@类名：JsonPage.java
	 *@描述：{todo}
	 */
	
	private static final long serialVersionUID = 1L;

	private JSONArray jsonArray;
	
	@Resource(name="page")
	private ActionPage actionPageBean;
	
	@Resource(name="messageService")
	private Im_Message_Service messageService;
	//那个用户的id进来分页
	private int id;
	
	///用户保存的信息
	private Send_Message message;
	
	
	
	public Send_Message getMessage() {
		return message;
	}

	public void setMessage(Send_Message message) {
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ActionPage getActionPageBean() {
		return actionPageBean;
	}

	public void setActionPageBean(ActionPage actionPageBean) {
		this.actionPageBean = actionPageBean;
	}

	public JSONArray getJsonArray() {
		return jsonArray;
	}

	public void setJsonArray(JSONArray jsonArray) {
		this.jsonArray = jsonArray;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		

		jsonArray=JSONArray.fromObject(messageService.show_Save_Message(actionPageBean,id).get_section_userMessage());
		
		return SUCCESS;
	}
	
	public String save()
	{
		message.setSend_Time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		messageService.Save_save_Message(message);
		
		
		return NONE;
	}
	
	
	
	
}
