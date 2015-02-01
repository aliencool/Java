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
 * @类功能说明：拦截与查看用户信息
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @公司名称：
 * @作者：Administrator
 * @创建时间：2014-6-12 下午03:30:13
 * @版本：V1.0
 */
public class Third_Interrupt extends AbstractInterceptor{
	
	/**
	 *@类名：Third_Interrupt.java
	 *@描述：{todo}
	 */
	
	private static final long serialVersionUID = 1L;
	@Resource(name="userService")
	private User_Service service;
	@Resource(name="messageService")
	private Im_Message_Service messageService;


    //1:如果,id为null,user不为null,表示进入自己的
    //2:如果,id不为null,user不为null,表示进入别人的
		
	

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		
		ActionContext context = invocation.getInvocationContext();
        HttpServletRequest request = (HttpServletRequest)context.get(StrutsStatics.HTTP_REQUEST); 
        //没有登陆，跳转到登陆
        if(request.getSession().getAttribute("user")==null)	return Action.LOGIN;
        
        
        //不为空,查看别人的
		if(request.getParameter("id")!=null)
		{
			int id=Integer.parseInt(request.getParameter("id"));
			
			//如果,id与当前登陆用户id一致，则进入自己页面 0进入我的
			if(((Bloguser)request.getSession().getAttribute("user")).getU_Id()==id)
			{
				request.setAttribute("flag",0);
				
				//保存评论
				ActionPage actionPageBean=new ActionPage();
				actionPageBean.setCurrentPage(1);
				
				//id是为了找到当前用户的id下留言
				request.setAttribute("discuss", messageService.show_Save_Message(actionPageBean,((Bloguser)request.getSession().getAttribute("user")).getU_Id()).get_section_userMessage());
				request.setAttribute("count", messageService.show_Save_Message(actionPageBean,((Bloguser)request.getSession().getAttribute("user")).getU_Id()).total_Page());
				
			}
			//否则，就是进入别人的
			else
			{
				request.setAttribute("flag",1);
				Bloguser bloguser=new Bloguser();
				bloguser.setU_Id(id);
				
			
				//保存客户信息
				request.setAttribute("visitor", service.selectUser(bloguser,1));
				//保存评论
				ActionPage actionPageBean=new ActionPage();
				actionPageBean.setCurrentPage(1);
				
				//id是为了找到当前用户的id下留言
				request.setAttribute("discuss", messageService.show_Save_Message(actionPageBean,id).get_section_userMessage());
				request.setAttribute("count", messageService.show_Save_Message(actionPageBean,id).total_Page());
			}
			
			return invocation.invoke();
		}

		return Action.LOGIN;
			
			
	
		
	}

}
