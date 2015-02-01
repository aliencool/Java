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
 * @类功能说明：第二拦截器，进入留言网站的时候进行特定数据拦截
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @公司名称：
 * @作者：Administrator
 * @创建时间：2014-6-8 下午02:43:04
 * @版本：V1.0
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
	 *@类名：根据提交的ip地址,查找是否为0
	 *@描述：{todo}
	 */

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		//0:得到request
		HttpServletRequest httpServletRequest=(HttpServletRequest)arg0.getInvocationContext().get(StrutsStatics.HTTP_REQUEST);
		actionPageBean.setCurrentPage(1);
		
		
	
		//1:为空就证明他是第一次进入留言板
		if(httpServletRequest.getSession().getAttribute("user")==null)
		{
		
			//2:跳转重新登陆页面
			return Action.LOGIN;
		}
			
		
		return arg0.invoke();
	}

}
