package OtherClass;

import java.io.IOException;

/*2013��8��8��17:47:59
 * Runtime��ʹ���˵������ģʽ
 * */
public class RuntimeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Runtime r=Runtime.getRuntime();
		Process p=r.exec("D:\\Program Files\\KGMusic\\KuGou.exe");
		p.destroy();
	}

}
