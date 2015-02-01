package test;
public class B21
{
	public static void main(String[] args)
	{
		System.out.println("±ê×¼:" + Math.PI);
		
		double a = 1; 
		int n = 6;
		
		for(int i=0; i<30; i++)
		{
			double b = Math.sqrt(1-(a/2)*(a/2));
			a = Math.sqrt((1-b)*(1-b) + (a/2)*(a/2));
			
			n = n*2; //Ìî¿Õ
			
			System.out.println(n + "  " + a);  // Ìî¿Õ
		}
	}
}