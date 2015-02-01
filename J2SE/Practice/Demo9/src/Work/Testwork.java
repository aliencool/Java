package Work;
/*2013年5月11日16:30:51
 * 2个错误:
 * 1:父类没有的抛出异常方法子类不能有或者说只能是父类的异常方法的子集!
 * 2:无法处理的异常是RuntimeException!
 * 3:尽量使用属性来作为功能的材料!
 * */

interface Areable
{
	void show();
}
class Novalue extends RuntimeException
{
	Novalue(){super();}
	Novalue(String str){super(str);}
}
class Rectangle implements Areable
{
	private int Heigh;//尽量使用属性来运算
	private int Width;//尽量使用属性来运算
	
	Rectangle(int Heigh,int Width)
	{
		if(Heigh<=0||Width<=0){
			throw new RuntimeException("非法数值");
		}
		this.Heigh=Heigh;
		this.Width=Width;
	}

	@Override
	public void show(){
		// TODO Auto-generated method stub
		//接口重写必须是public 
		System.out.println("Area:"+Heigh*Width);
	}
	
	
	
}

public class Testwork {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		int j=4^5;
		System.out.println(j);
		

	}

}
