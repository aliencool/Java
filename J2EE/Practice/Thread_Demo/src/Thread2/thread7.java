package Thread2;
/*2013��5��22��11:15:06
 * �̵߳�ͨ��:
 * 1:ͬ��Ҫ�ŵ���ȷ��λ�ã�ǧ������while(true)��ǰ��
 * 2:����ϣ����ֵ����������
 * */
//��Դ
class Resource
{
	String name;
	String sex;
}
//����
class Iuput implements Runnable
{
	Resource re=new Resource();
	int x=0;
	Iuput(Resource re)//��֤�߳�����Ψһ���빲��ͬһ��Դ
	{
		this.re=re;
	}
	
	@Override
	public void run() {
		while(true)
		{
			synchronized(re)
			{
				if(x==0)
				{
					re.name="Mike";
					re.sex="Boy";
				}
				else
				{
					re.name="Penny";
					re.sex="Gril";
				}
			}
			x=(x+1)%2;
		}
		
	}
}

//���
class Output implements Runnable
{
	Resource re=new Resource();
	int x=0;
	Output(Resource re)//��֤�߳�����Ψһ���빲��ͬһ��Դ
	{
		this.re=re;
	}
	
	@Override
	public void run() {
		//synchronized(re)����Զ����һ�������
		//{
			while(true)
			{
				synchronized(re){
					System.out.println("����:"+re.name+"..............."+"�Ա�"+re.sex);
				}
			}
		//}
		
	}
	
}
public class thread7 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//������Դ:
		Resource re=new Resource();
		
		//��������
		Iuput in=new Iuput(re);
		Output ou=new Output(re);
		
		//�����߳�:
		Thread th1=new Thread(in);
		Thread th2=new Thread(ou);
		
		//��������
		th1.start();
		th2.start();
	
	}

}
