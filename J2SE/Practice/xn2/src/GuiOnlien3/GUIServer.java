package GuiOnlien3;


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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.*;

public class GUIServer extends JFrame{

	/**
	 * @param args
	 */
	private JTextArea jta;
	private JTextField jtf;
	private JButton jb;
	private JPanel jp;
	public static ArrayList<Socket> vector=new ArrayList<Socket>();
	public static ArrayList<String> vector1=new ArrayList<String>();
	/*����Socket
	 * */
	ServerSocket serverSocket=null;
	Socket socket=null;
	
	GUIServer()
	{
		jta=new JTextArea();
		jtf=new JTextField(15);
		jb=new JButton("����");
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
		
		this.setTitle("���Ƿ�����");
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
					JOptionPane.showMessageDialog(jb, "����Ϊ��", "����", JOptionPane.ERROR_MESSAGE);
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
	
	public void accept()//���Ͻ���
	{
		while(true)
		{
			try {
				socket=serverSocket.accept();//�տ�ʼ�ͻ��
				Tlistener t=new Tlistener(socket,vector,vector1);
				t.start();
				
			}
			catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} 
		}
		
	}
	


