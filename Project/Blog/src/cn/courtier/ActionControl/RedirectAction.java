package cn.courtier.ActionControl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import cn.courtier.blog.Im.Im_Show_Service;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @类功能说明：进入会员信息表的Action和类别跳转
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @公司名称：
 * @作者：Administrator
 * @创建时间：2014-6-8 下午03:56:10
 * @版本：V1.0
 */
public class RedirectAction extends ActionSupport{

	/**
	 *@类名：跳转
	 *@描述：{todo}
	 */
	
	private static final long serialVersionUID = 1L;
	//0:进入我的 1:进入别人的
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
