import java.util.*;
public class B23
{
	public static List<Integer> max5(List<Integer> lst)
	{
		if(lst.size()<=5) return lst;
		
		int a = lst.get(0)>lst.get(1)?lst.remove(1):lst.remove(0);  // 填空
		List<Integer> b = max5(lst);
		
		for(int i=0; i<b.size(); i++)
		{
			int t = b.get(i);
			if(a>t)
			{
				b.add(i,a);  // 填空
				a = t;  //表示从5个里面剔除 后，最大的 来比较
			}
		}
		
		return b;
	}
	
	public static void main(String[] args)
	{
		List<Integer> lst = new Vector<Integer>();
		lst.addAll(Arrays.asList(12,127,85,66,27,34,15,344,156,344,29,47));		
		System.out.println(max5(lst));
		  String[][] getSongInfo = {
	            {"__00000.m4a", "征服"},
	            {"__00001.m4a", "童话"},
	            {"__00002.m4a", "同桌的你"},
	            {"__00003.m4a", "七里香"},
	            {"__00004.m4a", "传奇"},
	            {"__00005.m4a", "大海"},
	            {"__00006.m4a", "后来"},
	            {"__00007.m4a", "你的背包"},
	            {"__00008.m4a", "再见"},
	            {"__00009.m4a", "老男孩"},
	            {"__00010.m4a", "龙的传人"},
	    };
	}
}