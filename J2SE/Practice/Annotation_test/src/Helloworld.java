
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.Random;

public class Helloworld {

	/**
	 * @param args
	 */
	
	public static void main(String []args)
	{
		
//		for (int i = 1; i < 40;) {
//			
//			
//			BigDecimal b=new BigDecimal(fl(i));
//			BigDecimal b1=new BigDecimal(fl(i=i+1));
//			
//			if(b.divide(b1, 6,BigDecimal.ROUND_HALF_UP).doubleValue()==0.618034)
//			{
//				System.out.println(fl(i-1));
//				System.out.println(fl(i));
//				break;
//			}
//			
//		}
	
		String category_Name="select c_name from category where c_id=(select c_id from BlogContent where c_name=''"+"{0}"+"'')";
		String format=MessageFormat.format(category_Name, "ÎÒ");
		System.out.println(format);
	}
	
	public static int fl(int n)
	{
		if(n==1) return 1;
		else if(n==2) return 3;
		return fl(n-1)+fl(n-2);
	}
	
	
	
	

}
