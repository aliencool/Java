package JH;
/*2013年6月11日21:24:50
 * 学习list
 * 只有next,才有Previous(Link)
 * 只有Array.asList才是固定的
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
			System.out.println("Hashlist内容:"+it.next());
			
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
			System.out.println("内容:"+it.next());
			
		}
		System.out.println("个数为:"+list.size());
		
		
	}
	public static void LinkedListTest1()
	{
		List<String> list=new LinkedList<String>();
		list.add("c");
		list.add("b");
		list.add("a");
		ListIterator<String> listit=list.listIterator();
		
			System.out.println("内容:"+listit.next());
			System.out.println("内容:"+listit.next());
			System.out.println("内容:"+listit.previous());
			
		
		
	}

}
