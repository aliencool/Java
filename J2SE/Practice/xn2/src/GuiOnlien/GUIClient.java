package GuiOnlien;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.*;

public class GUIClient extends JFrame{

	/**
	 * @param args
	 */
	private JTextArea jta;
	private JTextArea jta_onlie;
	private JTextField jtf;
	private JButton jb;
	private JButton jb_send;
	private JPanel jp;
	private JSplitPane splitPane;
	
	/*网络Socket
	 * */
	Socket socket; 
	
	GUIClient()
	{
		jta=new JTextArea();
		jtf=new JTextField(15);
		jta_onlie=new JTextArea("在线列表\r\n");
		jta_onlie.setEditable(false);
		
		jb=new JButton("发送");
		jb_send=new JButton("发送文件");
		jp=new JPanel();
		
		
		jp.add(jtf);
		jp.add(jb);
		jp.add(jb_send);
		try {
			socket=new Socket("172.16.142.46",10001);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		splitPane=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,false,jta,jta_onlie);
		splitPane.setResizeWeight(0.5);
		   
		     
		     
		add(splitPane,"Center");
		add(jp,"South");
		this.setTitle("我是客户端");
		this.setSize(500, 500);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		GUIClient gui=new GUIClient();
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
					socket.close();
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
					send(jtf.getText());
				}
			}

			
		});
		
		jb_send.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				JFileChooser jf=new JFileChooser();
				int result=jf.showOpenDialog(null);
				if(result==JFileChooser.APPROVE_OPTION)
				{
					File f=jf.getSelectedFile();
					try{
						//输出到服务器的
						OutputStream outputStream=socket.getOutputStream();
						//读到内存
						InputStream inputStream=new FileInputStream(f);
						byte[] bytes=new byte[1024];
						int len=0;
						outputStream.write(1);
						//不断读取
						while((len=inputStream.read(bytes))!=-1)
						{
							outputStream.write(bytes, 0, len);
							System.out.println(12132321);
						}
						socket.shutdownOutput();//必须写结束标记
						
					
					
					}
					catch(Exception e1)
					{
						
					}
					
				}
			}

			
		});
		
	}
	public void send(String text) {
		// TODO Auto-generated method stub
		try {
			PrintWriter printWriter=new PrintWriter(socket.getOutputStream(),true);
			printWriter.println(0);
			printWriter.println(text);
			jtf.setText("");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void accept()//不断接受
	{
		try{
			BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String msg=null;
			
			while((msg=bufferedReader.readLine())!=null)
			{
				jta.append(socket.getLocalAddress().getHostAddress()+":"+msg+"\r\n");
			}
			bufferedReader.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
	}
	
	
	
	
	
	
	
	
	
	
}

