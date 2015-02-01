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
 * @类功能说明：头拦截器，进入网站的时候进行特定数据拦截
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @公司名称：
 * @作者：Administrator
 * @创建时间：2014-6-8 下午02:43:04
 * @版本：V1.0
 */
public class Head_Interrupt extends AbstractInterceptor{

	/**
	 *@类名：Head_Interrupt.java
	 *@描述：头拦截器
	 */
	
	private static final long serialVersionUID = 1L;

	@Resource(name="page")
	private ActionPage actionPageBean;
	
	@Resource(name="show_Service")
	private Im_Show_Service service;
	
	
	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		System.out.println(123);
		//1:查询文章
		
		List<ActionBlog> blog_R = service.get_Recommend_BlogContent();
		
		
		//2:设置页数 采用了通用页，所以，全部配页数
		actionPageBean.setCurrentPage(1);
		
		List<ActionBlog> blog_N=service.get_All_BlogContent(actionPageBean).get_section_BlogContent();
		
		//3:保存
		//3.1:通过ActionContext来获取httpRequest
		ActionContext context = arg0.getInvocationContext();
        HttpServletRequest request = (HttpServletRequest)context.get(StrutsStatics.HTTP_REQUEST); 
        
        //3.2:request级别保存
		request.setAttribute("recommend", blog_R);
		request.setAttribute("new_blog", blog_N);
		
		String result=arg0.invoke();
		
		return result;
	}
	

}
