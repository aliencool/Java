package Collection1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ItergetTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Collection ce=new ArrayList();
		ce.add("abc");
		ce.add("abc1");
		ce.add("abc2");
		
		for(Iterator it=ce.iterator();it.hasNext();)
		{
			System.out.println(it.next());
		}
	}

}
