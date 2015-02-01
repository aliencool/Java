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
 * @�๦��˵����
 * 1:Json��ˢ�·�ҳ ʹ��JsonArray �����з�ҳ��߷�ҳЧ�� ����JSonArray ��ֵ Ȼ������
 * 2:��ʾ�û��ύ�����Ա���������ݿ�
 * @���޸��ߣ�
 * @�޸����ڣ�
 * @�޸�˵����
 * @��˾���ƣ�
 * @���ߣ�Administrator
 * @����ʱ�䣺2014-6-14 ����10:43:56
 * @�汾��V1.0
 */
public class JsonPage extends ActionSupport {
	/**
	 *@������JsonPage.java
	 *@������{todo}
	 */
	
	private static final long serialVersionUID = 1L;

	private JSONArray jsonArray;
	
	@Resource(name="page")
	private ActionPage actionPageBean;
	
	@Resource(name="messageService")
	private Im_Message_Service messageService;
	//�Ǹ��û���id������ҳ
	private int id;
	
	///�û��������Ϣ
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
