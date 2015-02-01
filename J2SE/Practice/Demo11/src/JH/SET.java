package JH;

import java.util.*;

public class SET {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSetTest();
		TreeSetTest();
	}
	
	public static void HashSetTest()
	{
		Set<String> set=new HashSet<String>();
		set.add("haha");
		set.add("heihei");
		set.add("haha");
		Iterator<String> it=set.iterator();
		while(it.hasNext())
		{
			System.out.println("HashSet内容:"+it.next());
			
		}
		System.out.println("HashSet"+set.size());
		System.out.println();
	}
	
	public static void TreeSetTest()
	{
		Set<String> set=new TreeSet<String>();
		set.add("c");
		set.add("b");
		set.add("a");
		
		Iterator<String> it=set.iterator();
		while(it.hasNext())
		{
			System.out.println("内容:"+it.next());
			
		}
		System.out.println("个数为:"+set.size());
		
		
	}

}
