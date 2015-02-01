package cn.courtier.ActionInterrupt;

import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.StrutsStatics;
import org.springframework.http.HttpRequest;

import cn.courtier.ActionBean.ActionBlog;
import cn.courtier.ActionBean.ActionMessageBox;
import cn.courtier.ActionBean.ActionPage;
import cn.courtier.Until.SectionPage;
import cn.courtier.blog.Im.Im_Show_Service;
import cn.courtier.message.Im.Im_Message_Service;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
/**
 * @�๦��˵�����ڶ�������������������վ��ʱ������ض���������
 * @���޸��ߣ�
 * @�޸����ڣ�
 * @�޸�˵����
 * @��˾���ƣ�
 * @���ߣ�Administrator
 * @����ʱ�䣺2014-6-8 ����02:43:04
 * @�汾��V1.0
 */
public class Second_Interrupt extends AbstractInterceptor{
	private static final long serialVersionUID = 1L;
	@Resource(name="page")
	private ActionPage actionPageBean;
	@Resource(name="messageService")
	private Im_Message_Service messageService;
	@Resource(name="show_Service")
	private Im_Show_Service operation;
	/**
	 *@�����������ύ��ip��ַ,�����Ƿ�Ϊ0
	 *@������{todo}
	 */

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		//0:�õ�request
		HttpServletRequest httpServletRequest=(HttpServletRequest)arg0.getInvocationContext().get(StrutsStatics.HTTP_REQUEST);
		actionPageBean.setCurrentPage(1);
		
		
	
		//1:Ϊ�վ�֤�����ǵ�һ�ν������԰�
		if(httpServletRequest.getSession().getAttribute("user")==null)
		{
		
			//2:��ת���µ�½ҳ��
			return Action.LOGIN;
		}
			
		
		return arg0.invoke();
	}

}
