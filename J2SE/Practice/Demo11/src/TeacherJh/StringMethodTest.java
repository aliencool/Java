package TeacherJh;
/*2013��6��12��17:35:40
 * 1:length:����
 * 2:CharAt:��ȡ�ַ�λ��
 * 3:Indexof(int):����ǰ�ַ���ȡλ��
 * 4:LastIndexof(int):���ݺ��ַ���ȡλ��
 * 5:substring:��ȡ�ַ�(����ͷ��������β)
 * 6:split(����):��ȡ�����ַ�
 * 7:toCharArray:ת��Ϊchar (����)
 * 8:getbytes:ת��Ϊbyte(����)
 * 9:toupperCast:��д  toLowerCast:Сд
 * 10:replace(Ҫ�滻��,�滻):�滻
 * 11:trim(ȥ��ͷβ�ո�) 
 *    valueof():������������ת��
 *    copyvalueof();�ַ�ת��Ϊ����
 * */
public class StringMethodTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		stringmethodtest();
		stringmethodtest1();
	}

	public static void stringmethodtest1() {
		// TODO Auto-generated method stub
		String msg="����,����,����";
		String[] split=msg.split(",");//split��ŵ�������ʽ(\\.)
		for (int i = 0; i < split.length; i++) {
			System.out.println(split[i]);
		}
		
		char[] chs=msg.toCharArray();//ת��Ϊһ��һ��
		String.copyValueOf(chs);
		for (int i = 0; i < chs.length; i++) {
			System.out.println(chs[i]);
		}
		
		byte[] bt=msg.getBytes();
		for (int i = 0; i < chs.length; i++) {
			System.out.println(bt[i]);//GB2312���λΪ1
		}
		
		System.out.println("jovo".replace("jovo","java"));
	}

	public static void stringmethodtest() {
		String msg="abcdae";
		System.out.println("SubString:"+msg.substring(2));
		System.out.println("SubString:"+msg.substring(2,5));//����begin,������end
		System.out.println("Length:"+msg.length());//6
		System.out.println("charAt:"+msg.charAt(3));//d
		System.out.println("indexof:"+msg.indexOf('a'));//0
		System.out.println("Lastindexof:"+msg.lastIndexOf('a'));//4
		
	}

}
