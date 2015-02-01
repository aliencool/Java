package Thread6;

import java.util.*;
import java.util.concurrent.locks.*;

/*2013��6��7��16:07:57
 * ѧϰ��д��
 * ����ϵͳ:��һ�����ݿ���,�ڶ��Σ�ֱ���û��� 
 * */
public class ThreadReadWritelockTest {

	
	private Map<String,Object> hasmap=new HashMap<String,Object>();
	
	public static void main(String[] args) {

	}
	private ReadWriteLock rwl=new ReentrantReadWriteLock();
	public Object get(String key)
	{	
		rwl.readLock().lock();
		Object obj=null;
		try
		{
		
			obj=hasmap.get(key);
			if(obj==null)
			{
				rwl.readLock().unlock();
				rwl.writeLock().lock();
				try{
					if(obj==null)
					obj="aa";
				}
				finally
				{
					rwl.writeLock().unlock();
				}
				rwl.readLock().lock();
			}
		
		}
		finally
		{
			rwl.readLock().unlock();
		}
		return obj;
	}

}
