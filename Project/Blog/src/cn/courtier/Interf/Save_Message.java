package cn.courtier.Interf;

import cn.courtier.ActionBean.ActionPage;
import cn.courtier.Until.SectionPage;
import cn.courtier.po.Bloguser;
import cn.courtier.po.Send_Message;

/**
 * @�๦��˵���������û�����
 * @���޸��ߣ�
 * @�޸����ڣ�
 * @�޸�˵����
 * @��˾���ƣ�
 * @���ߣ�Administrator
 * @����ʱ�䣺2014-6-14 ����01:57:55
 * @�汾��V1.0
 */
public interface Save_Message {

	public SectionPage show_Save_Message(ActionPage actionPageBean,int id);
	//
	public void Save_save_Message(Send_Message message);
	public void delete_Save_Message(Send_Message message);
}
