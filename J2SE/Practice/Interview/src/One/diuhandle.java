package One;

import java.util.LinkedList;
import java.util.List;

/* 2014��7��6��13:58:17
 * ����������
 * */
public class diuhandle {
 
	public static void main(String []args){
		int j=1;
		int k=0;
		int len=0;
		
		int [] list=new int[5];
		//����Ԫ�� 50��
		for (int i=0; i <5; i++) {
			list[i]=i+1;
		}
		
		len=list.length;
		int m=len;
		
		
		
		while(len > 0){
			/*˼·:
			 * 1:���,�ǵڼ�����ڼ������
			 * 2:��Ǻ��жϣ��Ǳ�ǹ�������
			 * 3:���Ǳ�ǹ���,��ʼ���� ��Ȼ��jλ��Ϊ����Ϊ1
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
