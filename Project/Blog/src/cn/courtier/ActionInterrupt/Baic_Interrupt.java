package cn.courtier.ActionInterrupt;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;

import cn.courtier.ActionBean.ActionBlog;
import cn.courtier.ActionBean.ActionMessageBox;
import cn.courtier.ActionBean.ActionPage;
import cn.courtier.Until.SectionPage;
import cn.courtier.blog.Im.Im_Show_Service;
import cn.courtier.message.Im.Im_Message_Service;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * @�๦��˵�������������� ����������ҳ����Ҫ ���˵�½ ����ʾ
 * @���޸��ߣ�
 * @�޸����ڣ�
 * @�޸�˵����
 * @��˾���ƣ�
 * @���ߣ�Administrator
 * @����ʱ�䣺2014-6-13 ����11:57:04
 * @�汾��V1.0
 */
public class Baic_Interrupt extends AbstractInterceptor {
	@Resource(name="page")
	private ActionPage actionPageBean;
	@Resource(name="messageService")
	private Im_Message_Service messageService;
	@Resource(name="show_Service")
	private Im_Show_Service operation;
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("����");
		HttpServletRequest httpServletRequest=(HttpServletRequest)invocation.getInvocationContext().get(StrutsStatics.HTTP_REQUEST);
		//1:���ֱ���
		//1:�������
		SectionPage list_click=operation.get_All_BlogContent(actionPageBean);
		//1.1:����
		Collections.sort(list_click.get_section_BlogContent(),new Comparator<ActionBlog>() {

			public int compare(ActionBlog o1, ActionBlog o2) {
				// TODO Auto-generated method 
				return o1.getClick()-o2.getClick();
			}
		});
		
		httpServletRequest.setAttribute("click_blog", list_click.get_section_BlogContent());
		
		
		
		//2:�Ƽ�����
		List<ActionBlog> blog_N=operation.get_All_BlogContent(actionPageBean).get_section_BlogContent();
		
		httpServletRequest.setAttribute("recommend", blog_N);
		
		//3:�õ���������
		SectionPage sectionPage=messageService.show_Message(actionPageBean);
		
		List<ActionMessageBox> actionMessageBoxs=sectionPage.get_section_MessageBox();
	
		httpServletRequest.setAttribute("newcomment", actionMessageBoxs);

		return invocation.invoke();
	}

}
