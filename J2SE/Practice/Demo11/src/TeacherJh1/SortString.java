package TeacherJh1;
/*2013年7月3日16:04:59
 * 选择排序:里面比外面多一次 使用下标
 * 冒泡排序:是从1开始算(n-1),记得减i
 * */
public class SortString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] msg=new String[]{"nba","abc","cba","zz","qq","hh"};
		String temple=null;
		int k;
		//选择
		for(int i=0;i<msg.length-1;i++)
		{
			k=i;
			for(int j=i+1;j<msg.length;j++)
			{
				if(msg[k].compareTo(msg[j])>0)
				{
					k=j;
				}
			}
			if(i!=k)
			{
				temple=msg[i];
				msg[i]=msg[k];
				msg[k]=temple;
			}
			
			
		}
		//冒泡
/*	for(int i=1;i<=msg.length-1;i++)
		{
			for(int j=0;j<msg.length-i;j++)
			{
				if(msg[j].compareTo(msg[j+1])>0)
				{
					temple=msg[j];
					msg[j]=msg[j+1];
					msg[j+1]=temple;
				}
			}
		}*/
		
		for(int i=0;i<msg.length;i++)
		{
			System.out.println("Sort:"+msg[i]);
		}

	}

}
