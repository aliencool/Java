package GuiOnlien4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;


public class Listener extends Thread{
	private Socket socket;
	private     DefaultTreeCellRenderer cellRenderer;
	private	int count=0;
	public Listener(Socket socket) {
		super();
		this.socket = socket;
		cellRenderer=new DefaultTreeCellRenderer();
		   //�ϲ�
	    cellRenderer.setOpenIcon(new ImageIcon("zk.gif"));
	    //չ��
	    cellRenderer.setClosedIcon(new ImageIcon("hb.gif"));
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
				pw.println(2);//��Ҫ�������������б�
				count++;
			}
			String msg=null;
			while((msg=bufferedReader.readLine())!=null)
			{
			    if(msg.equals("1"))
				{	
			    	Thread.sleep(100);//��ȡ��̫��
				    msg=bufferedReader.readLine();//�ڶ���� ������Ϣ
				    GUIClient.node.add(new DefaultMutableTreeNode(msg));
				    cellRenderer.setLeafIcon(new ImageIcon("dltb.png"));
				    GUIClient.jTree.setCellRenderer(cellRenderer); 
				    GUIClient.jTree.updateUI();  //ÿ������Ҫˢ��
				  
				}
			    if(msg.equals("3"))
				{	
			
				    msg=bufferedReader.readLine();//�ڶ����
				    String[] text=msg.split(":");
					GUIClient.jta.append(text[0]+":\r\n"+text[1]+"\r\n");
					
				}
			    if(msg.equals("4"))
			    {
			    	msg=bufferedReader.readLine();
			    	String[] text=msg.split(":");
					GUIClient.jta.append(text[0]+":\r\n"+text[1]+"\r\n");
			    }
			    if(msg.equals("5"))
			    {
			    	FileOutputStream outputStream=new FileOutputStream("www.txt");
			    	System.out.println(55+"test");
			    	InputStream inputStreamReader=socket.getInputStream();//�õ����������ҷ���
					byte [] bye=new byte[1024];
					int len=0;
					while((len=inputStreamReader.read(bye))!=-1)
					{
						outputStream.write(bye, 0, len);
						outputStream.flush();
					}
					outputStream.close();
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
