/*2013��9��27��14:53:50
 * ��ϰ�¼�����ģʽ
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
	public student(Object source,String msg) {//ע���¼�Դ
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
