package extends1;
/*
 * 2013��4��24��11:05:35
 * �ӿ���һ�ֹ��򣬱��磬ֻ��USB�ӿڵĶ���ſ��Խӵ����������USB
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
