package extends1;
/*
 * 2013年4月24日11:05:35
 * 接口是一种规则，比如，只有USB接口的对象才可以接到电脑上面的USB
 * */
interface usb
{
	public abstract void open();
	public abstract void close();
	
}

class Radomdisk implements usb
{
	public void open(){System.out.println("Random disk ........");}
	public void close(){System.out.println("Random disk close........");}
}

class useMouse implements usb
{
	public void open(){System.out.println("useMouse ........");}
	public void close(){System.out.println("useMouse close........");}
}

class Bookpc{
	
	public Bookpc(usb u)
	{
		u.open();
		u.close();
	}
	
}



public class Interfaca2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			new Bookpc(new Radomdisk());
			new Bookpc(new useMouse());
		
	}

}
