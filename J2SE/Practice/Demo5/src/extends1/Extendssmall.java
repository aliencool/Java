package extends1;
/*
 * 2013��4��22��16:55:04
 * ѧϰ��ʼ��
 * ������ȳ�ʼ��
 * */

class Father
{

	Father(){show();}
	void show(){System.out.println("F running");}

}
class Son extends Father
{
	int num=8;
    Son(){}	
    void show(){System.out.println("Z running"+".........."+num);}
}

public class Extendssmall {

	/**
	 * @param args
	 */
	public static  void main(String[] args) {
		// TODO Auto-generated method stub
      
      
	}

}
