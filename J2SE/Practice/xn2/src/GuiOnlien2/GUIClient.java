package GuiOnlien2;


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
import java.util.ArrayList;

import javax.swing.*;

public class GUIClient extends JFrame{

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static JTextArea jta;
	public static JComboBox jcb;
	private JTextField jtf;
	public static String user;
	private JButton jb;
	private JButton jb_send;
	private JPanel jp;
	private JSplitPane splitPane;
	private String selectmsg=null;
	/*����Socket
	 * */
	Socket socket; 
	
	GUIClient()
	{
		jta=new JTextArea();
		jtf=new JTextField(15);
		jcb=new JComboBox();
		
		
		jb=new JButton("����");
		jb_send=new JButton("�����ļ�");
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
		
		splitPane=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,false,jta,jcb);
		splitPane.setResizeWeight(0.5);
		   
		     
		     
		add(splitPane,"Center");
		add(jp,"South");
		this.setTitle("��������:"+GUIClient.user);
		this.setSize(500, 500);
		this.setVisible(true);
	
	}
	
	public static void main(String[] args) {
		
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
		jcb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JComboBox jcb=(JComboBox) e.getSource();
				selectmsg=(String) jcb.getSelectedItem();
				System.out.println(selectmsg);
			
			}
		});
		
		jb.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(jtf.getText().equals(""))
				{
					JOptionPane.showMessageDialog(jb, "����Ϊ��", "����", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					send(jtf.getText(),selectmsg);
					
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
						//�������������
						OutputStream outputStream=socket.getOutputStream();
						//�����ڴ�
						InputStream inputStream=new FileInputStream(f);
						byte[] bytes=new byte[1024];
						int len=0;
						outputStream.write(1);
						//���϶�ȡ
						while((len=inputStream.read(bytes))!=-1)
						{
							outputStream.write(bytes, 0, len);
						}
						socket.shutdownOutput();//����д�������
						
					
					
					}
					catch(Exception e1)
					{
						
					}
					
				}
			}

			
		});
		
	}
	public void send(String text,String id) {
		// TODO Auto-generated method stub
		try {
			PrintWriter printWriter=new PrintWriter(socket.getOutputStream(),true);
			printWriter.println(3);
			printWriter.println(id);
			
			printWriter.println(text);
			printWriter.println(GUIClient.user);
			jtf.setText("");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void accept()//���Ͻ���
	{
		
			Listener listener=new Listener(socket);
			listener.start();
			}
}

