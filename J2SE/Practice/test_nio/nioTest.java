import java.nio.*;

class test{
		public static void main(String []args)
		{
			//1:����20��������
			   IntBuffer intbuff=IntBuffer.allocate(20);
			//2:��ӡ�����    
				System.out.println("֮ǰ"+"Limit:"+intbuff.limit()+"Position:"+intbuff.position()+"Capacity:"+intbuff.capacity());
			
			int []temp={5,7,9};
			
			intbuff.put(temp);
			intbuff.put(3);//д��������
			//3:��ӡ�����    
				System.out.println("֮��"+"Limit:"+intbuff.limit()+"Position:"+intbuff.position()+"Capacity:"+intbuff.capacity());
			
			//4:����flip()	
			intbuff.flip();
				//5:��ӡ�����    
				System.out.println("����flip֮��"+"Limit:"+intbuff.limit()+"Position:"+intbuff.position()+"Capacity:"+intbuff.capacity());	
				
			//5:�����ӻ�����:	
				 IntBuffer sIntbuff=null;
				 intbuff.position(2);
				 intbuff.limit(3);
				 
				 sIntbuff=intbuff.slice();
				
			
				
				
				
				
				
				
		}
	
	}