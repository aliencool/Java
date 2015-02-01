package OtherClass;

import java.io.IOException;

/*2013年8月8日17:47:59
 * Runtime类使用了单利设计模式
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
