package JHKJ;

import java.util.LinkedList;

/*2013年7月23日21:33:55
 * 学习LinkedList
 * addfirst
 * addlast
 * */
public class LinkedListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList ll=new LinkedList();
		/*PushStatck(ll,"a");
		PushStatck(ll,"b");
		PushStatck(ll,"c");
		System.out.println("进栈:"+ll);//进栈
		
		Object ss=GetStatick(ll);
		System.out.println("出栈:"+ss);
		*/
		PushQueue(ll,"b");
		PushQueue(ll,"c");
		System.out.println("入队:"+ll);//进栈
		
		Object ss=GetQueue(ll);
		System.out.println("出队:"+ss);
		
	}
	public static void PushStatck(LinkedList ll,String ss)
	{
		ll.addFirst(ss);
	}
	
	public static Object GetStatick(LinkedList ll)
	{
		Object ss=ll.removeFirst();
		return ss;
		
	}
	public static void PushQueue(LinkedList ll,String ss)
	{
		ll.addLast(ss);
	}
	
	public static Object GetQueue(LinkedList ll)
	{
		Object ss=ll.removeFirst();
		return ss;
		
	}
	
	
}
