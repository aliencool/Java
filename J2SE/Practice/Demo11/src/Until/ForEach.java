package Until;

import java.util.*;

/* 2013��8��7��16:59:45
 * �߼�for:���ڻ�ȡ
 * �ͼ�for:���ڲ���
 * �ؼ�����Map����
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
