import java.util.*;
public class B23
{
	public static List<Integer> max5(List<Integer> lst)
	{
		if(lst.size()<=5) return lst;
		
		int a = lst.get(0)>lst.get(1)?lst.remove(1):lst.remove(0);  // ���
		List<Integer> b = max5(lst);
		
		for(int i=0; i<b.size(); i++)
		{
			int t = b.get(i);
			if(a>t)
			{
				b.add(i,a);  // ���
				a = t;  //��ʾ��5�������޳� ������ ���Ƚ�
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
	            {"__00000.m4a", "����"},
	            {"__00001.m4a", "ͯ��"},
	            {"__00002.m4a", "ͬ������"},
	            {"__00003.m4a", "������"},
	            {"__00004.m4a", "����"},
	            {"__00005.m4a", "��"},
	            {"__00006.m4a", "����"},
	            {"__00007.m4a", "��ı���"},
	            {"__00008.m4a", "�ټ�"},
	            {"__00009.m4a", "���к�"},
	            {"__00010.m4a", "���Ĵ���"},
	    };
	}
}