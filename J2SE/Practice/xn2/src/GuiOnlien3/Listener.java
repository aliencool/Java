package GuiOnlien3;

import java.io.BufferedReader;
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
		   //合并
	    cellRenderer.setOpenIcon(new ImageIcon("zk.gif"));
	    //展开
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
				pw.println(2);//我要服务器的在线列表
				count++;
			}
			String msg=null;
			while((msg=bufferedReader.readLine())!=null)
			{
			    if(msg.equals("1"))
				{	
				    msg=bufferedReader.readLine();//在读多次
				    GUIClient.node.add(new DefaultMutableTreeNode(msg)); 
				    cellRenderer.setLeafIcon(new ImageIcon("dltb.png"));
				    GUIClient.jTree.setCellRenderer(cellRenderer);
				    
				    //每个树都要刷新
				    GUIClient.jTree.updateUI();
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
