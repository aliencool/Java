package Thread6;

import java.util.concurrent.locks.*;






public class BoundedBuffter {
		Object[] o=new Object[100];
		int ptr,ltr,Count=0;
		
		Lock lo=new ReentrantLock();
		Condition notEmpty=lo.newCondition();
		Condition notFull=lo.newCondition();
		
		
		public void put(Object x) throws InterruptedException
		{
			lo.lock();
			try
			{
				while(Count==o.length)
				{
					notEmpty.await();//不空队列，满了
				}
				o[ptr]=x;
				if(++ptr==o.length) ptr=0;
				Count++;
				notFull.signal();
				
			}
			finally
			{
				lo.unlock();
			}
		}
		
		public Object get() throws InterruptedException
		{
		
			lo.lock();
			try
			{
				while(Count==0)
				{
					notFull.await();//还没有元素
				}
					Object x=o[ltr];
				if(++ltr==o.length) ltr=0;
				Count--;
				notEmpty.signal();
				return x;
			}
			finally
			{
				lo.unlock();
			}
		}


}
