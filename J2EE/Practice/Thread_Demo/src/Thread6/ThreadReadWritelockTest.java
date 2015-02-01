package Thread6;

import java.util.*;
import java.util.concurrent.locks.*;

/*2013年6月7日16:07:57
 * 学习读写锁
 * 缓存系统:第一次数据库拿,第二次，直接拿缓存 
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
