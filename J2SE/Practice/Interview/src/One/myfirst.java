package One;

public class myfirst {
	private int mFlag=0;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []_Num = {1,2,3,4,5,6,7,8};
		
		System.out.println(serach(_Num,0,_Num.length-1,3));
	}
	
	public static int serach(int num[],int start,int end,int key)
	{
		int _Mid = start + end; 
	     return num[_Mid]==key?_Mid:num[_Mid]>key?serach(num,0,_Mid-1,key):serach(num,_Mid+1,end,key);
	}

}
