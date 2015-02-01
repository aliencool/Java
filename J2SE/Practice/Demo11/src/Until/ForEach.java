package Until;

import java.util.*;

/* 2013年8月7日16:59:45
 * 高级for:用于获取
 * 低级for:用于操作
 * 关键在于Map迭代
 * */
public class ForEach {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer,String> map=new HashMap<Integer,String>();
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");
		
		for(Integer key:map.keySet())
		{
			System.out.println(map.get(key));
		}
		for(Map.Entry<Integer,String> entry:map.entrySet())
		{
			System.out.println(entry.getValue()+"............"+entry.getKey());
		}
		
		Iterator<Map.Entry<Integer,String>> it=map.entrySet().iterator();
		while(it.hasNext())
		{
			Map.Entry<Integer,String> map1=it.next();
			System.out.println(map1.getValue()+"........."+map1.getKey());
		}
		
		
	}

}
