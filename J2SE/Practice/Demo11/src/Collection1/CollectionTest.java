package Collection1;
/*2013年7月19日17:22:20
 * 存放对象，自动增加减少!
 * */
import java.util.ArrayList;
import java.util.Collection;

public class CollectionTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Collection ce=new ArrayList();
		Collection ce1=new ArrayList();
	//	show(ce);
		show(ce,ce1);
	}

	private static void show(Collection ce,Collection ce1) {
		// TODO Auto-generated method stub
		ce.add(11);
		ce.add(22);
		ce.add(11);
		System.out.println("ce:"+ce);
		
		ce1.add(11);
		ce1.add(2);
		ce1.add(11);
		System.out.println("ce1:"+ce1);
		
		ce.retainAll(ce1);
		System.out.println("ce:"+ce);
		
	}

	private static void show(Collection ce) {
		// TODO Auto-generated method stub
		ce.add(11);
		ce.add(22);
		System.out.println(ce);
		System.out.println(ce.size());
		
		
		ce.remove(22);
		System.out.println(ce);
		System.out.println(ce.size());
		
		System.out.println(ce.contains(22));
	}

}
