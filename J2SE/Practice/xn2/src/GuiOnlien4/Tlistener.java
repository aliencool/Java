package GuiOnlien4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Tlistener extends Thread{
		private Socket s;
		private ArrayList<String> arrayList_other;
		private String msg;
		private String now;
		public Tlistener(Socket socket) {
			// TODO Auto-generated constructor stub
			this.s = socket;
			
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true)
			{
				try{	
					BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(s.getInputStream()));	
					PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
					msg=bufferedReader.readLine();	//ÿ�ζ�ȡ���
				
					if(msg.equals("1"))//��ÿ���˷�
					{
						msg=bufferedReader.readLine();
						now=msg;	//����ǰ�û���
						Clienlistener.Set(msg, s);

						Iterator<String> iterator=Clienlistener.hashmap.keySet().iterator();
						while(iterator.hasNext())
					    {
							String map=iterator.next();
							
							if(Clienlistener.Get(map)==this.s)continue;
							 PrintWriter pw1=new PrintWriter(Clienlistener.Get(map).getOutputStream(),true);
							 pw1.println(1);
							 pw1.println(msg);
							
					    }
					
							
					}
					else if(msg.equals("2"))//ÿ�ε���2
					{
						Iterator<String> it=Clienlistener.hashmap.keySet().iterator();
						String res;
						while(it.hasNext())
						{
							res=it.next();
							if(res.equals(now))continue;
							pw.println(1);
							pw.println(res);
						}
					}		
					else if(msg.equals("3"))
					{
						String id=bufferedReader.readLine();//�õ�Ҫ���͵���
						Socket socket=Clienlistener.hashmap.get(id);
						String senmsg=bufferedReader.readLine();//�õ�Ҫ���͵���Ϣ
						String now=bufferedReader.readLine();
						
						PrintWriter pw_send=new PrintWriter(socket.getOutputStream(),true);//����
						pw_send.println(3);
						pw_send.println(now+"����˵:"+senmsg);
						pw_send.println("over");
					}
					else if(msg.equals("4"))
					{
						msg=bufferedReader.readLine();
						Iterator<String> iterator=Clienlistener.hashmap.keySet().iterator();
						while(iterator.hasNext())
					    {
							String map=iterator.next();
							
							if(Clienlistener.Get(map)==this.s)continue;
							PrintWriter pw1=new PrintWriter(Clienlistener.Get(map).getOutputStream(),true);
							pw1.println(4);
							pw1.println(msg);
							
					    }
					}
				}
				catch(Exception e)
				{}
			
			}
			
		}
	

}
