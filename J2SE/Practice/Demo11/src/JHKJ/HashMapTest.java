package JHKJ;

import java.util.*;

/*学习HashMap
 * 2013年7月30日21:20:53
 * 添加：PUT (key,neirong)覆盖
 * 删除：REMOVE(KEY)
 * 获取：GET(KEY)
 * 判断：Containskey containsvalue
 * 两种迭代器:KeySet Map.entrySet
 * */
public class HashMapTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer,String> map=new HashMap<Integer,String>();
		//添加
		map.put(2, "haha");
		map.put(3, "xixi");
		
		//获取
		
		System.out.println("map:"+map.get(2));
		
		//判断:
		System.out.println("map:"+map.containsKey(3)+"  "+"values:"+map.containsValue("xixi"));
		
		//迭代
		Set<Integer> keyset=map.keySet();
		Iterator<Integer> it=keyset.iterator();//要加上<Integer>
		while(it.hasNext())
		{
			Integer key=it.next();
			String name=map.get(key);
			System.out.println(name);
		}
		//迭代2
		Set<Map.Entry<Integer, String>> se=map.entrySet();
		Iterator<Map.Entry<Integer, String>> it1=se.iterator();
		while(it1.hasNext())
		{
			Map.Entry<Integer, String> mapentry=it1.next();
			System.out.println(mapentry.getKey());
			System.out.println(mapentry.getValue());
			
		}
		
		//values
		Collection<String> ce=map.values();
		Iterator<String> it3=ce.iterator();
		while(it3.hasNext())
		{
			System.out.println(it3.next());
			
		}
		
	}

}
