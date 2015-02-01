package GuiOnlien3;

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
		private ArrayList<Socket> arrayList;
		private ArrayList<String> arrayList_other;
		private String msg;
		public Tlistener(Socket s,ArrayList<Socket> arrayList,ArrayList<String> arrayList_other) {
			super();
			this.s = s;
			this.arrayList=arrayList;
			this.arrayList_other=arrayList_other;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true)
			{
				try{	
					BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(s.getInputStream()));	
					PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
					msg=bufferedReader.readLine();	//每次读取标记

					if(msg.equals("1"))//给每个人发
					{
						msg=bufferedReader.readLine();	
						Clienlistener.hashmap.put(msg, s);

						arrayList_other.add(msg);//你发过来说你上线了，我就添加!在线列表
						
						Set<Map.Entry<String, Socket>> set=Clienlistener.hashmap.entrySet();
						Iterator<Map.Entry<String, Socket>> iterator=set.iterator();
						while(iterator.hasNext())
					    {
							Map.Entry<String, Socket> map=iterator.next();
							Socket Socketclien=map.getValue();
						PrintWriter pw1=new PrintWriter(Socketclien.getOutputStream(),true);
						//每个人发我上线了
						if(Socketclien==this.s)
							{
								continue;
							}
						pw1.println(1);
						pw1.println(msg);
					   }//通知到每个
							
					}
					if(msg.equals("2"))//每次等于2
					{
						
					
						for (int i = 0; i < arrayList_other.size(); i++) {
							pw.println(1);
							pw.println(arrayList_other.get(i));
							
						}
						pw.println("over");
					
					}		
					if(msg.equals("3"))
					{
						String id=bufferedReader.readLine();//得到要发送的人
						Socket socket=Clienlistener.hashmap.get(id);
						String senmsg=bufferedReader.readLine();//得到要发送的信息
						String now=bufferedReader.readLine();
						
						PrintWriter pw_send=new PrintWriter(socket.getOutputStream(),true);//发送
						pw_send.println(3);
						pw_send.println(now+"对您说:"+senmsg);
						pw_send.println("over");
					}
				}
				catch(Exception e)
				{}
			
			}
			
		}
	

}
