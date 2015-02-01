package nb2;


class outer{
	static String a;
	public  class Inner{
		String b;
		public void innerMethod()
		{
			System.out.println(a);
			System.out.println(b);
		}
		
	
		
	}
	
		public void createInner()
		{
			Inner i=new Inner();
			i.innerMethod();
		}
}








public class test7 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
