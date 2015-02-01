/*2013年9月27日14:53:50
 * 练习事件定制模式
 * */
package Mystudent;

import java.io.Serializable;
import java.util.EventObject;

public class student extends EventObject implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;
	public student(Object source,String msg) {//注册事件源
		super(source);
		setMsg(msg);
	
	}
	
	public void setMsg(String msg)
	{
		this.msg=msg;
	}
	
	public String getMsg()
	{
		return msg;
	}
	
}
