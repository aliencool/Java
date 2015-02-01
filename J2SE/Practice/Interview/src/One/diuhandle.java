package One;

import java.util.LinkedList;
import java.util.List;

/* 2014年7月6日13:58:17
 * 丢手帕问题
 * */
public class diuhandle {
 
	public static void main(String []args){
		int j=1;
		int k=0;
		int len=0;
		
		int [] list=new int[5];
		//进入元素 50个
		for (int i=0; i <5; i++) {
			list[i]=i+1;
		}
		
		len=list.length;
		int m=len;
		
		
		
		while(len > 0){
			/*思路:
			 * 1:如果,是第几个则第几个标记
			 * 2:标记后判断，是标记过的跳过
			 * 3:不是标记过的,开始数数 ，然后，j位置为重新为1
			 * */
			
			if(list[k%m] > 0)
			{
				if(j%4 == 0)
				{
					System.out.println(list[k%m]);
					list[k%m]=-1;
					j=1;
	                len--;
	             }else{
	                    k++;
	                    j++;
	             }
			
			}
			else{
				k++;
			}
			    			
		}
		
		
		
	}
}
