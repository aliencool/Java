package Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class main_morphology {
	
	/**
	 * @param args
	 * ״̬ģʽ->����C���Դʷ����� 5��״̬   ����Ϊ5��
	 * 1:�ؼ���
	 * 2:����
	 * 3:���
	 * 4:�����
	 * 5:��ʾ�� 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//����
		//1:save:��������ڴ���ַ�
		char []msg;
		//2:size:�����ڴ���ַ���С
		int count=0;
		//3:message
		int len=0;
		//4:flag �Ƿ����������
		int i=0;
		
		
		//�����ڴ�
		InputStream inputStream=new FileInputStream("programmer.txt");
		//�õ��ļ�����
		count=inputStream.available();
		msg=new char[count];
		//��ʼ��
		
		while((len=inputStream.read())!=-1)
		{
			msg[i]=(char)len;
			i++;
		}
		
		Work.setMsg(msg);
		
		//����
		Work work=new Work();
		System.out.println("�ʷ�������ʼִ��:");
		while(Work.stats!=-1)
		{
			work.analysis();
			Work.p++;
			work.setState(new Digit_Letter_State());
		}

	/*	StringBuilder sentence = new StringBuilder("This is an apple");
		char c;
		int p1, p2;
		
		p1 = sentence.length();
		System.out.println("1L"+p1);
		while (p1 > 0) {
			p1--;
			p2 = p1;
			
			while (p1 >= 0 && sentence.charAt(p1) != ' ') {
				p1--;
			}
			
			int ww = p2 - p1;
		
			p2 = p1 + 1;
			
			while (p1 + ww >= p2) {
				System.out.print(sentence.charAt(p2));
				p2++;
			}
			
			if (p1 >= 0) {
				System.out.print(' ');
			}
		}
		*/
		
		
		
	
	}

}
