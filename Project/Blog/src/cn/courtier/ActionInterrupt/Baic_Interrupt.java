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
 * @类功能说明：基本过滤器 基本所有网页都需要 除了登陆 ，显示
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @公司名称：
 * @作者：Administrator
 * @创建时间：2014-6-13 下午11:57:04
 * @版本：V1.0
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
		System.out.println("测试");
		HttpServletRequest httpServletRequest=(HttpServletRequest)invocation.getInvocationContext().get(StrutsStatics.HTTP_REQUEST);
		//1:各种保存
		//1:点击排行
		SectionPage list_click=operation.get_All_BlogContent(actionPageBean);
		//1.1:排序
		Collections.sort(list_click.get_section_BlogContent(),new Comparator<ActionBlog>() {

			public int compare(ActionBlog o1, ActionBlog o2) {
				// TODO Auto-generated method 
				return o1.getClick()-o2.getClick();
			}
		});
		
		httpServletRequest.setAttribute("click_blog", list_click.get_section_BlogContent());
		
		
		
		//2:推荐文章
		List<ActionBlog> blog_N=operation.get_All_BlogContent(actionPageBean).get_section_BlogContent();
		
		httpServletRequest.setAttribute("recommend", blog_N);
		
		//3:得到最新评论
		SectionPage sectionPage=messageService.show_Message(actionPageBean);
		
		List<ActionMessageBox> actionMessageBoxs=sectionPage.get_section_MessageBox();
	
		httpServletRequest.setAttribute("newcomment", actionMessageBoxs);

		return invocation.invoke();
	}

}
