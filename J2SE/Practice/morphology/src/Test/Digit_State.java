package Test;

public class Digit_State implements State{

	@Override
	public void State_Work(Work work) {
		// TODO Auto-generated method stub
		char ch=Work.getMsg()[Work.p];
		
		int num=0;
		//1:������
		if((ch>='0'&&ch<='9'))
		{
			while(ch>='0'&&ch<='9')
			{
				//1.1:�õ��ַ�-'0'�õ�����
				num=num*10+ch-'0';
				//1.2:״̬���
				Work.stats=11;
				//1.3:���
				Work.p++;
				ch=Work.getMsg()[Work.p];
				System.out.println("<"+Work.stats+"-"+num+">");
			}
			Work.p--;
			
		}
		else
		{	
			//2.1:����״̬
			work.setState(new Other_State());
			//2.2:�������ֵķ���
			work.analysis();
		}
	}
}
