import java.nio.*;

class test{
		public static void main(String []args)
		{
			//1:开辟20个缓冲区
			   IntBuffer intbuff=IntBuffer.allocate(20);
			//2:打印出结果    
				System.out.println("之前"+"Limit:"+intbuff.limit()+"Position:"+intbuff.position()+"Capacity:"+intbuff.capacity());
			
			int []temp={5,7,9};
			
			intbuff.put(temp);
			intbuff.put(3);//写进缓冲区
			//3:打印出结果    
				System.out.println("之后"+"Limit:"+intbuff.limit()+"Position:"+intbuff.position()+"Capacity:"+intbuff.capacity());
			
			//4:调用flip()	
			intbuff.flip();
				//5:打印出结果    
				System.out.println("调用flip之后"+"Limit:"+intbuff.limit()+"Position:"+intbuff.position()+"Capacity:"+intbuff.capacity());	
				
			//5:生成子缓冲区:	
				 IntBuffer sIntbuff=null;
				 intbuff.position(2);
				 intbuff.limit(3);
				 
				 sIntbuff=intbuff.slice();
				
			
				
				
				
				
				
				
		}
	
	}