/*2013��9��27��14:53:50
 * ��ϰ�¼�����ģʽ
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
	public student(Object source,String msg) {//�¼�Դ
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
