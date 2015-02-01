package JH;
import java.util.*;
public class Map {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMapTest();
		TreeMapTest();
	}
	public static  void HashMapTest()
	{
		HashMap<String,String> map=new HashMap<String,String>();
	
		map.put("1", "January");
		map.put("2", "February");
		map.put("3", "March");
		Set<String> set=map.keySet();
		Iterator<String> it=set.iterator();
		while(it.hasNext())
		{
			String key=it.next();
			System.out.println("HashMapÄÚÈİ:"+key+":"+map.get(key));
			
		}
		
	}
	public static  void TreeMapTest()
	{
		TreeMap<String, String> map=new TreeMap<String,String>();
		map.put("1", "January");
		map.put("2", "February");
		map.put("3", "March");
		Set<String> set=map.keySet();
		Iterator<String> it=set.iterator();
		while(it.hasNext())
		{
			String key=it.next();
			System.out.println("TreeMapÄÚÈİ:"+key+":"+map.get(key));
			
		}
		
	}

}
