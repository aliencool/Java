package nb;
/*2013��4��26��17:12:02
 * ������:
 * 1:ʹ�ó�Ա���������ڱ�������
 * 2:{}ֻ��ʹ��һ�ι�������
 * 3:��Ա������new Thread(new XX{})�����Զ���
 * 4:�ֲ��������ݸ����캯��������final
 * */

public class test4 {
        int a;
	/**
	 * @param args
	 */
        test4(){}
        test4(int a){}
        void method(){System.out.println(1);}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=5;
		test4 t4=new test4(a){{}/*��������*/void method(){System.out.println(a);}
		};
		t4.method();
		
		
		
	}

}
