package JHKJ;


import java.util.*;

/*2013��7��23��17:05:46
 * ѧϰListIterator
 * ListIterator:���Խ����������������
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
		System.out.println("�Ƿ���ǰһ��:"+lt.hasPrevious());
		System.out.println("�Ƿ�����һ��:"+lt.hasNext());
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
		
		
		/*Iterator it=li.iterator(); ���ֲ������⣬ֻ֪��ǰ��Ķ���֪�������
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
