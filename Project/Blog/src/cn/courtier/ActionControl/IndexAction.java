package cn.courtier.ActionControl;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @�๦��˵����������ҳ��Action
 * @���޸��ߣ�
 * @�޸����ڣ�
 * @�޸�˵����
 * @��˾���ƣ�
 * @���ߣ�Administrator
 * @����ʱ�䣺2014-6-8 ����03:56:10
 * @�汾��V1.0
 */
public class IndexAction extends ActionSupport{

	/**
	 *@��������ҳ
	 *@������{todo}
	 */
	
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		System.out.println("����");
		return SUCCESS;
	}
}
