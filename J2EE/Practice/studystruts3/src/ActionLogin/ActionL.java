package ActionLogin;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ActionL extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String execute() throws Exception {
		//��ȡsession
		Map actionSession=ActionContext.getContext().getSession();
		//�ж�
		if(username.equals("admin"))
		{
			actionSession.put("username", "admin");
			return SUCCESS;
		}
		else 
		{
			addFieldError("username", "�û�������");
			return LOGIN;
		}
	}
	public String adduser()
	{
		return SUCCESS;
	}
	

}
