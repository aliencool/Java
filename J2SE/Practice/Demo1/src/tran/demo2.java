package tran;

public class demo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[][]=new int [3][];
	}
	public static void toHex(int num)
	{
		trans(num,15,4);
	}
	public static void toOct(int num)
	{
		trans(num,7,3);
	}
	public static void toBinary(int num)
	{
		trans(num,1,1);
	}
	
	
	public static void trans(int num,int base,int offest)
	{
		
		char []arr=new char[32];
		int pos=arr.length;
		int temp;
		char []sr={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		
		while(num!=0)
		{
			temp=num & base;
			arr[--pos]=sr[temp];
			num=num>>>offest;//Ïàµ±ÓÚ³ı2
		}
		for(int x=pos;x<arr.length;x++)
		{
			System.out.print(arr[x]);
			
		}
		
		System.out.println();
		
		
	}

}
