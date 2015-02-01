package cn.courtier.ActionInterrupt;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.StrutsStatics;
import cn.courtier.ActionBean.ActionBlog;
import cn.courtier.ActionBean.ActionPage;
import cn.courtier.blog.Im.Im_Show_Service;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * @�๦��˵����ͷ��������������վ��ʱ������ض���������
 * @���޸��ߣ�
 * @�޸����ڣ�
 * @�޸�˵����
 * @��˾���ƣ�
 * @���ߣ�Administrator
 * @����ʱ�䣺2014-6-8 ����02:43:04
 * @�汾��V1.0
 */
public class Head_Interrupt extends AbstractInterceptor{

	/**
	 *@������Head_Interrupt.java
	 *@������ͷ������
	 */
	
	private static final long serialVersionUID = 1L;

	@Resource(name="page")
	private ActionPage actionPageBean;
	
	@Resource(name="show_Service")
	private Im_Show_Service service;
	
	
	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		System.out.println(123);
		//1:��ѯ����
		
		List<ActionBlog> blog_R = service.get_Recommend_BlogContent();
		
		
		//2:����ҳ�� ������ͨ��ҳ�����ԣ�ȫ����ҳ��
		actionPageBean.setCurrentPage(1);
		
		List<ActionBlog> blog_N=service.get_All_BlogContent(actionPageBean).get_section_BlogContent();
		
		//3:����
		//3.1:ͨ��ActionContext����ȡhttpRequest
		ActionContext context = arg0.getInvocationContext();
        HttpServletRequest request = (HttpServletRequest)context.get(StrutsStatics.HTTP_REQUEST); 
        
        //3.2:request���𱣴�
		request.setAttribute("recommend", blog_R);
		request.setAttribute("new_blog", blog_N);
		
		String result=arg0.invoke();
		
		return result;
	}
	

}
