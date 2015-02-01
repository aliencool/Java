package ActionLogincheck;


import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class Actioninterupt extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		//1:获取全局context(在servlet中使用config来获取是因为,web服务器存放了很多web应用,通过每个config提高安全)
		ActionContext context=arg0.getInvocationContext();
		
		//2:查看是否有用户 
		Map<String, Object> map=context.getSession();
		String username=(String) map.get("username");
		if(username!=null)
		{
			//跳转
			return arg0.invoke();
			
		}
		else
		{  //跳到登陆
			return Action.LOGIN;
		}
	}

}
