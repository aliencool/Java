package JHKJ;

import java.util.*;

/*ѧϰHashMap
 * 2013��7��30��21:20:53
 * ��ӣ�PUT (key,neirong)����
 * ɾ����REMOVE(KEY)
 * ��ȡ��GET(KEY)
 * �жϣ�Containskey containsvalue
 * ���ֵ�����:KeySet Map.entrySet
 * */
public class HashMapTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer,String> map=new HashMap<Integer,String>();
		//���
		map.put(2, "haha");
		map.put(3, "xixi");
		
		//��ȡ
		
		System.out.println("map:"+map.get(2));
		
		//�ж�:
		System.out.println("map:"+map.containsKey(3)+"  "+"values:"+map.containsValue("xixi"));
		
		//����
		Set<Integer> keyset=map.keySet();
		Iterator<Integer> it=keyset.iterator();//Ҫ����<Integer>
		while(it.hasNext())
		{
			Integer key=it.next();
			String name=map.get(key);
			System.out.println(name);
		}
		//����2
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
