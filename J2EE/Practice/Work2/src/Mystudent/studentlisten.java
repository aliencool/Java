/*2013年9月27日15:01:09
 * 事件监听器 监听student事件源
 * */
package Mystudent;


import java.util.EventListener;

public interface studentlisten extends EventListener {//注册监听器
	 void checkmsg(student s);
	
}
