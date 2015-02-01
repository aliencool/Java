/*2013年9月27日14:53:50
 * 练习事件定制模式
 * */
package Mystuedent2;

import java.io.Serializable;
import java.util.EventObject;

public class student extends EventObject implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;
	public student(Object source,String msg) {//事件源
		super(source);
		setMsg(msg);
		// TODO Auto-generated constructor stub
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
