package JH;
/*2013��6��11��21:24:50
 * ѧϰlist
 * ֻ��next,����Previous(Link)
 * ֻ��Array.asList���ǹ̶���
 * */
import java.util.*;

public class LIST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayListTest1();
		LinkedListTest1();
	}
	public static void ArrayListTest()
	{
		List<String> list=new ArrayList<String>();
		list.add("haha");
		list.add("heihei");
		list.add("haha");
		Iterator<String> it=list.iterator();
		while(it.hasNext())
		{
			System.out.println("Hashlist����:"+it.next());
			
		}
		System.out.println("Hashlist"+list.size());
		System.out.println();
	}
	
	public static void ArrayListTest1()
	{
		String []msg={"haha","hehe","xixi"};
		List<String> list=Arrays.asList(msg);
		list.set(2, "gaga");

		System.out.println(Arrays.toString(list.toArray()));
		System.out.println();
	}
	
	public static void LinkedListTest()
	{
		List<String> list=new LinkedList<String>();
		list.add("c");
		list.add("b");
		list.add("a");
		
		Collections.sort(list);
		Iterator<String> it=list.iterator();
		while(it.hasNext())
		{
			System.out.println("����:"+it.next());
			
		}
		System.out.println("����Ϊ:"+list.size());
		
		
	}
	public static void LinkedListTest1()
	{
		List<String> list=new LinkedList<String>();
		list.add("c");
		list.add("b");
		list.add("a");
		ListIterator<String> listit=list.listIterator();
		
			System.out.println("����:"+listit.next());
			System.out.println("����:"+listit.next());
			System.out.println("����:"+listit.previous());
			
		
		
	}

}
