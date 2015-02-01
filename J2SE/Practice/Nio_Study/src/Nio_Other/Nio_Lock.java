package Nio_Other;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * @类功能说明：使用文件锁
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @公司名称：
 * @作者：Administrator
 * @创建时间：2014-6-29 上午10:46:17
 * @版本：V1.0
 */
public class Nio_Lock {
	public static void main(String []agrs) throws Exception
	{
		//1:文件
		File file=new File("www.txt");
		//2:读进来
		FileOutputStream fileOutputStream=new FileOutputStream(file,true);
		//3:进行读写
		FileChannel channel=fileOutputStream.getChannel();
		//4:锁定
		FileLock fileLock=channel.tryLock();
		
		while(fileLock!=null)
		{
			Thread.sleep(3000);
			fileLock.release();
		}
		channel.close();
		
	}
}
