package Ex2;
/*2013��5��7��22:25:04
 * ���������쳣ת��Ӧ��
 * 1���쳣ת��
 * 2���Զ����쳣
 * */
/*
 * �쳣
 */
class LanPingException extends Exception
{
	LanPingException(String msg)
	{
		super(msg);
	}
}

class MaoyanException extends Exception
{
	MaoyanException(String msg)
	{
		super(msg);
	}
}
class NoplaneException extends Exception
{
	NoplaneException(String msg)
	{
		super(msg);
	}
}
/*
 * ��������
 */
class Computer
{
	private   int state=2; 
	public void run()throws LanPingException,MaoyanException//���Է����쳣ֻ�е���֪��
	{
		if(state==1) throw new LanPingException("��������");
		if(state==2) throw new MaoyanException("����ð��");
		
		System.out.println("��������");
	}
	
	public void rest()
	{
		state=0;
	}
}
class weixiu
{
	public static boolean rest(Computer comp)
	{
		comp.rest();
		return false;
	}

}

/*
 * ��ʦ����
 */
class Teacher
{
	private String name;
	private	Computer comp;
	Teacher(String name)
	{
		this.name=name;
		comp=new Computer();
		
	}

	public void prelect()throws NoplaneException //throws MaoyanException ð�̲����ڹ�˾��Χ��Ӧ���׳�һ����˾�ܴ�������
	{
		try{
		comp.run();
		System.out.println(name+"����");
		}
		catch(LanPingException e)//�쳣���Դ���(Ԥ����)
		{
			System.out.println(e.toString());
			comp.rest();//��������Զ������ѭ��
			prelect();
		}
		catch(MaoyanException e)//�쳣�����Դ���,���׳�(Ԥ����)
		{
			
			System.out.println(e.toString());
			test();
			//���ԶԵ��Խ���ά��
			if(weixiu.rest(comp))
			{
				System.out.println("ά�޺���");
				prelect();
			}
			else
			{
				throw new NoplaneException("�޷�����");
			}
		}
		
		
	}
	public void test()
	{
		System.out.println("��ϰ");
	}
	public  void rest()
	{
		comp.rest();
		
	}
}

public class Exceptionapply {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Teacher t=new Teacher("����ʦ");
			
		try{
		t.prelect();
		}
		catch(NoplaneException e)
		{
			
			System.out.println("����");
			t=new Teacher("����ʦ");
			try {
				t.rest();
				t.prelect();
			} catch (NoplaneException e1) {
				e1.printStackTrace();
			}
		}
	}

}
