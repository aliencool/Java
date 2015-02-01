package cn.courtier.Interf;

import cn.courtier.ActionBean.ActionPage;
import cn.courtier.Until.SectionPage;
import cn.courtier.po.Bloguser;
import cn.courtier.po.Send_Message;

/**
 * @类功能说明：处理用户留言
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @公司名称：
 * @作者：Administrator
 * @创建时间：2014-6-14 下午01:57:55
 * @版本：V1.0
 */
public interface Save_Message {

	public SectionPage show_Save_Message(ActionPage actionPageBean,int id);
	//
	public void Save_save_Message(Send_Message message);
	public void delete_Save_Message(Send_Message message);
}
