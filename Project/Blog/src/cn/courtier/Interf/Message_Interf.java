package cn.courtier.Interf;

import java.util.List;

import cn.courtier.ActionBean.ActionPage;
import cn.courtier.Until.SectionPage;
import cn.courtier.po.Bloguser;
import cn.courtier.po.MessageBox;

/**
 * @�ӿڹ���˵����ʵ�����԰��CRUD,����,�޸���ɾ��ֻ�ܳ��ֹ���Ա��
 * @���޸��ߣ�
 * @�޸����ڣ�
 * @�޸�˵����
 * @��˾���ƣ�
 * @���ߣ�Administrator
 * @����ʱ�䣺2014-6-11 ����06:42:28
 * @�汾��V1.0
 */
public interface Message_Interf {
	//��ҳ����
	public SectionPage show_Message(ActionPage actionPageBean);
	public void update_Message(int i,MessageBox messageBox);
	public void save_Message(MessageBox messageBox);
	public void delete_Message(int i);
	
}
