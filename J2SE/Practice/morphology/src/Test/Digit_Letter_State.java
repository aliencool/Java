package Test;

public class Digit_Letter_State implements State{

	@Override
	public  void State_Work(Work work) {
		//����������ʾ��
		 int len=0;
		 //��װ����
		 String str="";
		 //ÿ�ζ�ȡһ��
		 char ch=Work.getMsg()[Work.p];
		//1:ȥ�ո�
		
		
		while(ch==' ')
		{
			Work.p++;
			ch=Work.getMsg()[Work.p];
		}
		
		//2:�ж��Ƿ�Ϊ�ַ���������
		//2.1:��һ���������ַ�
		if((ch>='a'&&ch<='z')||(ch>='A'&&ch<='Z'))
		{
			    //2.2:�ڶ������ַ������� ����ȫ���ַ� ���� �ؼ���
				while((ch>='0'&&ch<='9')||(ch>='a'&&ch<='z')||(ch>='A'&&ch<='Z'))
				{
					
					
					Work.word[len]=ch;
					len++;
					Work.p++;
					ch=Work.getMsg()[Work.p];
					
				}
				//����һλ���бȽ�,����,��
				Work.p--;
				//���裬�����ǹؼ���
				Work.stats=10;
				//2.3:�������ѵõ�������װ���ַ���
				for (int i = 0; i < len; i++) {
					
					str=str+Work.word[i];
					
				}
				//2.4:������������ؼ��ֱȽ�
				for (int i = 0; i < Work.keyword.length; i++) {
					if(str.compareTo(Work.keyword[i])==0)
					{
						//2.5��ӡ���ؼ��ֺ�����
						Work.stats=i+1;
					}
				}
			
				System.out.println("<"+Work.stats+"-"+str+">");
		}
		//3:�����¸�״̬����
		else
		{
		
			//3.1:����״̬
			work.setState(new Digit_State());
			//3.2:�������ֵķ���
			work.analysis();
		}
	}
}
