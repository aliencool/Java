package JHKJ;


import java.util.*;

/*2013年7月23日17:05:46
 * 学习ListIterator
 * ListIterator:可以解决并发操作的问题
 * */
public class ListIteratorTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List li=new ArrayList();
		li.add("abc");
		li.add("abc1");
		li.add("abc2");
		li.add("abc3");
		System.out.println(li);
		ListIterator lt=li.listIterator();
		System.out.println("是否有前一个:"+lt.hasPrevious());
		System.out.println("是否有下一个:"+lt.hasNext());
		while(lt.hasNext())
		{
			Object ob=lt.next();
			if(ob.equals("abc"))
			{
				li.add("abc8");
			}
			else
			{
				System.out.println(ob);
			}
		
		}
		
		
		/*Iterator it=li.iterator(); 出现并发问题，只知道前面的而不知道后面的
		while(it.hasNext())
		{
			Object ob=it.next();
			if(ob.equals("abc"))
			{
				li.add("abc8");
			}
			else
			{
				System.out.println("Next:"+it.next());
			}
		}*/
		
	}

}
