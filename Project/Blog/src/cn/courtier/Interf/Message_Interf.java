package cn.courtier.Interf;

import java.util.List;

import cn.courtier.ActionBean.ActionPage;
import cn.courtier.Until.SectionPage;
import cn.courtier.po.Bloguser;
import cn.courtier.po.MessageBox;

/**
 * @接口功能说明：实现留言版的CRUD,其中,修改与删除只能出现管理员处
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @公司名称：
 * @作者：Administrator
 * @创建时间：2014-6-11 下午06:42:28
 * @版本：V1.0
 */
public interface Message_Interf {
	//网页留言
	public SectionPage show_Message(ActionPage actionPageBean);
	public void update_Message(int i,MessageBox messageBox);
	public void save_Message(MessageBox messageBox);
	public void delete_Message(int i);
	
}
