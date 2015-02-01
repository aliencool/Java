package GuiOnlien;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.*;

public class GUIServer extends JFrame{

	/**
	 * @param args
	 */
	private JTextArea jta;
	private JTextField jtf;
	private JButton jb;
	private JPanel jp;
	
	/*网络Socket
	 * */
	ServerSocket serverSocket=null;
	Socket socket=null;
	
	GUIServer()
	{
		jta=new JTextArea();
		jtf=new JTextField(15);
		jb=new JButton("发送");
		jp=new JPanel();
		jp.add(jtf);
		jp.add(jb);
		try {
			serverSocket=new ServerSocket(10001);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		add(jta,"Center");
		add(jp,"South");
		
		this.setTitle("我是服务器");
		this.setSize(300, 200);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		GUIServer gui=new GUIServer();
		gui.listeren();
		gui.accept();
	}
	
	public void listeren()
	{
		addWindowListener(new WindowAdapter() {


			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				try {
					serverSocket.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.exit(0);
			}
		
		});
		jb.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(jtf.getText().equals(""))
				{
					JOptionPane.showMessageDialog(jb, "不能为空", "错误", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					send();
				}
			}

			
		});
		
	}
	public void send() {
		// TODO Auto-generated method stub
		try {
			
				PrintWriter printWriter=new PrintWriter(socket.getOutputStream(),true);
				printWriter.println(jtf.getText());
				jtf.setText("");
	
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void accept()//不断接受
	{
		while(true)
		{
			try {
				socket=serverSocket.accept();//刚开始就获得
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						try{
						InputStream inputStream=socket.getInputStream();
						PrintWriter pw=new PrintWriter(socket.getOutputStream());
						int select=inputStream.read();//看是否是文件
						System.out.println(select);
						if(select==48)
						{	
							BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
							String msg=null;
							
							while((msg=bufferedReader.readLine())!=null)
							{
								if(msg.equals("0"))continue;
								jta.append(socket.getLocalAddress().getHostAddress()+":"+msg+"\r\n");
							}
							bufferedReader.close();
						}
						else if(select==1)
						{
							
							byte[] bytes=new byte[1024];
							OutputStream  ous=new FileOutputStream(socket.getInetAddress().getHostAddress()+".jpg");
							int len=0;
							while((len=inputStream.read(bytes))!=-1)
							{
								ous.write(bytes,0,len);
								ous.flush();	
							}
						
							pw.println(socket.getInetAddress().getHostAddress()+"上传成功");
							pw.close();
							ous.close();
							
						}
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
						
					}
				}).start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}

