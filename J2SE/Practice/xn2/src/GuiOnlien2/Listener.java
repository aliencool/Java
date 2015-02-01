package GuiOnlien2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Listener extends Thread{
	private Socket socket;
	private	int count=0;
	public Listener(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			try{
			BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter pw=new PrintWriter(socket.getOutputStream(),true);

			if(count==0)
			{
				pw.println(1);
		
				pw.println(GUIClient.user);
				pw.println(2);//我要服务器的在线列表
				count++;
			}
			String msg=null;
			while((msg=bufferedReader.readLine())!=null)
			{
			    if(msg.equals("1"))
				{	
				    msg=bufferedReader.readLine();//在读多次
				    System.out.println(msg);
					GUIClient.jcb.addItem(msg);
				}
			    if(msg.equals("3"))
				{	
			    	System.out.println(1);
				    msg=bufferedReader.readLine();//在读多次
				    String[] text=msg.split(":");
					GUIClient.jta.append(text[0]+":\r\n"+text[1]+"\r\n");
					System.out.println(2);
				}
			    
			}	
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

}
