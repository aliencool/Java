package ActionLogincheck;


import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class Actioninterupt extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		//1:��ȡȫ��context(��servlet��ʹ��config����ȡ����Ϊ,web����������˺ܶ�webӦ��,ͨ��ÿ��config��߰�ȫ)
		ActionContext context=arg0.getInvocationContext();
		
		//2:�鿴�Ƿ����û� 
		Map<String, Object> map=context.getSession();
		String username=(String) map.get("username");
		if(username!=null)
		{
			//��ת
			return arg0.invoke();
			
		}
		else
		{  //������½
			return Action.LOGIN;
		}
	}

}
