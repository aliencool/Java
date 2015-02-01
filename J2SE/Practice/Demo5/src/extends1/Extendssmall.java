package extends1;
/*
 * 2013年4月22日16:55:04
 * 学习初始化
 * 父类会先初始化
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
