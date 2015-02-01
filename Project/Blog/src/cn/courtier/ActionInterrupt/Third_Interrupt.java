package cn.courtier.ActionInterrupt;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.filechooser.FileFilter;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import cn.courtier.ActionBean.ActionPage;
import cn.courtier.message.Im.Im_Message_Service;
import cn.courtier.po.Bloguser;
import cn.courtier.user.Im.User_Im;
import cn.courtier.user.Im.User_Service;

/**
 * @�๦��˵����������鿴�û���Ϣ
 * @���޸��ߣ�
 * @�޸����ڣ�
 * @�޸�˵����
 * @��˾���ƣ�
 * @���ߣ�Administrator
 * @����ʱ�䣺2014-6-12 ����03:30:13
 * @�汾��V1.0
 */
public class Third_Interrupt extends AbstractInterceptor{
	
	/**
	 *@������Third_Interrupt.java
	 *@������{todo}
	 */
	
	private static final long serialVersionUID = 1L;
	@Resource(name="userService")
	private User_Service service;
	@Resource(name="messageService")
	private Im_Message_Service messageService;


    //1:���,idΪnull,user��Ϊnull,��ʾ�����Լ���
    //2:���,id��Ϊnull,user��Ϊnull,��ʾ������˵�
		
	

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		
		ActionContext context = invocation.getInvocationContext();
        HttpServletRequest request = (HttpServletRequest)context.get(StrutsStatics.HTTP_REQUEST); 
        //û�е�½����ת����½
        if(request.getSession().getAttribute("user")==null)	return Action.LOGIN;
        
        
        //��Ϊ��,�鿴���˵�
		if(request.getParameter("id")!=null)
		{
			int id=Integer.parseInt(request.getParameter("id"));
			
			//���,id�뵱ǰ��½�û�idһ�£�������Լ�ҳ�� 0�����ҵ�
			if(((Bloguser)request.getSession().getAttribute("user")).getU_Id()==id)
			{
				request.setAttribute("flag",0);
				
				//��������
				ActionPage actionPageBean=new ActionPage();
				actionPageBean.setCurrentPage(1);
				
				//id��Ϊ���ҵ���ǰ�û���id������
				request.setAttribute("discuss", messageService.show_Save_Message(actionPageBean,((Bloguser)request.getSession().getAttribute("user")).getU_Id()).get_section_userMessage());
				request.setAttribute("count", messageService.show_Save_Message(actionPageBean,((Bloguser)request.getSession().getAttribute("user")).getU_Id()).total_Page());
				
			}
			//���򣬾��ǽ�����˵�
			else
			{
				request.setAttribute("flag",1);
				Bloguser bloguser=new Bloguser();
				bloguser.setU_Id(id);
				
			
				//����ͻ���Ϣ
				request.setAttribute("visitor", service.selectUser(bloguser,1));
				//��������
				ActionPage actionPageBean=new ActionPage();
				actionPageBean.setCurrentPage(1);
				
				//id��Ϊ���ҵ���ǰ�û���id������
				request.setAttribute("discuss", messageService.show_Save_Message(actionPageBean,id).get_section_userMessage());
				request.setAttribute("count", messageService.show_Save_Message(actionPageBean,id).total_Page());
			}
			
			return invocation.invoke();
		}

		return Action.LOGIN;
			
			
	
		
	}

}
