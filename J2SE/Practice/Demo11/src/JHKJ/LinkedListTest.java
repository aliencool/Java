package JHKJ;

import java.util.LinkedList;

/*2013��7��23��21:33:55
 * ѧϰLinkedList
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
		System.out.println("��ջ:"+ll);//��ջ
		
		Object ss=GetStatick(ll);
		System.out.println("��ջ:"+ss);
		*/
		PushQueue(ll,"b");
		PushQueue(ll,"c");
		System.out.println("���:"+ll);//��ջ
		
		Object ss=GetQueue(ll);
		System.out.println("����:"+ss);
		
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
