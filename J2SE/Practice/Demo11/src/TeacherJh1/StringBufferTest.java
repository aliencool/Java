package TeacherJh1;
/*2013��7��6��16:24:23
 * ѧϰstringbuffer
 * 1:�ص�:�������ͣ����룬�ı��ַ���
 * 2:ÿ�η���stringbuffer��ÿ��16���ַ�
 * */
public class StringBufferTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer("scfd");
		sb.delete(1, 3);//����ͷ��β
		String b=sb.substring(1, 3);//ȥ��ͷ��β
		System.out.println(sb);
		System.out.println(b);
	}

}
