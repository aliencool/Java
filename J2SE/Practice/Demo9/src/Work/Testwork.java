package Work;
/*2013��5��11��16:30:51
 * 2������:
 * 1:����û�е��׳��쳣�������಻���л���˵ֻ���Ǹ�����쳣�������Ӽ�!
 * 2:�޷�������쳣��RuntimeException!
 * 3:����ʹ����������Ϊ���ܵĲ���!
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
	private int Heigh;//����ʹ������������
	private int Width;//����ʹ������������
	
	Rectangle(int Heigh,int Width)
	{
		if(Heigh<=0||Width<=0){
			throw new RuntimeException("�Ƿ���ֵ");
		}
		this.Heigh=Heigh;
		this.Width=Width;
	}

	@Override
	public void show(){
		// TODO Auto-generated method stub
		//�ӿ���д������public 
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
