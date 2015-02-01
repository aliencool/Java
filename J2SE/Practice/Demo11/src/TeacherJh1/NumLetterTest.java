package TeacherJh1;

import java.util.*;

public class NumLetterTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String str="fsdfsdxzcb++tfjhg";
			
			String count=getcharto(str);
			System.out.println(count);
	}

	public static String getcharto(String str) {
		// TODO Auto-generated method stub
		
		//转为字符
		char[] ch=str.toCharArray();
		
		//定义键值对
		Map<Character,Integer> map=new TreeMap<Character, Integer>();
		
		for (int i = 0; i < ch.length; i++) {
			if(!(ch[i]>='a'&&ch[i]<='z'||ch[i]>='A'&&ch[i]<='Z'))continue;
			int count=0;
			Integer it=map.get(ch[i]);
			if(it!=null)
			{
				count=it;
			}
			count++;
			map.put(ch[i], count);
		}
		
		return gettoString(map);
	}

	public static String gettoString(Map<Character, Integer> map) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer();
		Set<Map.Entry<Character, Integer>> set=map.entrySet();
		Iterator<Map.Entry<Character, Integer>> it=set.iterator();
		//Iterator<Character> it1=map.keySet().iterator();
		while(it.hasNext())
		{
			//Character key=it1.next();
			//Integer it=map.get(key);
			Map.Entry<Character, Integer> ma=it.next();
			sb.append(ma.getKey()+"("+(ma.getValue())+")");
		}
		return sb.toString();
	}

}
