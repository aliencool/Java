/*
 * 2013��4��19��22:01:29
 * ѧϰ����ģʽ
 * ����:
 * ˽�й���
 * ˽�о�̬ʵ��
 * ���з���
 * */
package clas3;

//��һ�ַ�ʽ(�������ڿ���)
class Test{
	int num;
	private static Test ts=new Test();
	
	private Test(){}
	public static Test getInstance()
	{
		return ts;
	}
	
	public void setNum(int num)
	{
		this.num=num;
	}
	
	public int getNum()
	{
		return num;
	}
	
}

//�ڶ��ַ�ʽ ���̲߳��ܱ���ģʽ
class Test1{
	private static Test1 ts1=null;
	
	private Test1(){}
	
	public static Test1 getInstance()
	{
		if(ts1==null)ts1=new Test1();
		return ts1;
	}
	
}
//�ڶ��ַ�ʽ ���̲߳��ܱ���ģʽ(�������,�ٶ�һ���жϺ���)
class Test2{
	private static Test2 ts1=null;
	
	private Test2(){}
	
	public static Test2 getInstance()//�ر�ע��static û��this �ؼ���
	{	
		if(ts1==null)//����������ж�ÿ���̶߳�Ҫȥ����ʸ���ٴ��ж�
		{
			synchronized(Test2.class)//������ֻ��ʹ��һ���߳̽��з���
			{
				if(ts1==null)ts1=new Test2();
			}
		}
		return ts1;
	}
	
}


public class single {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test tt=Test.getInstance();
		Test tt1=Test.getInstance();
		
		tt.setNum(50);
		tt1.setNum(98);
		
		System.out.println(tt.getNum());
		System.out.println(tt1.getNum());
	}

}
