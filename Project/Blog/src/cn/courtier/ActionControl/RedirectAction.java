package cn.courtier.ActionControl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import cn.courtier.blog.Im.Im_Show_Service;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @�๦��˵���������Ա��Ϣ���Action�������ת
 * @���޸��ߣ�
 * @�޸����ڣ�
 * @�޸�˵����
 * @��˾���ƣ�
 * @���ߣ�Administrator
 * @����ʱ�䣺2014-6-8 ����03:56:10
 * @�汾��V1.0
 */
public class RedirectAction extends ActionSupport{

	/**
	 *@��������ת
	 *@������{todo}
	 */
	
	private static final long serialVersionUID = 1L;
	//0:�����ҵ� 1:������˵�
	@Autowired  
	private  HttpServletRequest request; 


	@Override
	public String execute() throws Exception {
		Integer flag=(Integer)request.getAttribute("flag");
		
		
		if(flag.intValue()==0)
		{
			return "UPDATE";
		}else 
		return "SHOW";
	}
}
