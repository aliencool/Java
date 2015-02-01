package GuiOnlien4;


import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import java.io.OutputStream;

import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

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
	public static JTree jTree;
	private JPanel jp;
	public static DefaultMutableTreeNode node;
	private JSplitPane splitPane;
	private String selectmsg=null;
	private JPopupMenu popMenu;
	private JPanel jp1=null;
	private JLabel jLabel3=null;
	private JLabel jLabel=null;
	private JLabel jLabe2=null;
	private JPanel showimage=null;
	 ImageIcon image = null;
	/*网络Socket
	 * */
	Socket socket; 
	
	GUIClient()
	{
		jta=new JTextArea();
		jtf=new JTextField(15);
		jp1=new JPanel();
		jLabel=new JLabel();
		jLabe2=new JLabel();
		jLabel3=new JLabel(new ImageIcon("dltb.png"));
		popMenu = new JPopupMenu();
		
		jb=new JButton("发送");
		jb_send=new JButton("发送文件");
		jp=new JPanel();
		
		image = new ImageIcon("dltb.png");
		jLabel=new JLabel();
		node=new DefaultMutableTreeNode("在线用户");
		jTree=new JTree(node);
		
		
		
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
		
		splitPane=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,false,jta,jTree);
		splitPane.setResizeWeight(0.5);
		   
		     
		     
		add(new JScrollPane(splitPane),"Center");
		add(jp,"South");
		this.setTitle("您的姓名:"+GUIClient.user);
		this.setSize(500, 500);
		this.setVisible(true);
	
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
		jTree.addTreeSelectionListener(new TreeSelectionListener() {
			
			@Override
			public void valueChanged(TreeSelectionEvent e) {
				// TODO Auto-generated method stub
				DefaultMutableTreeNode note=(DefaultMutableTreeNode)jTree.getLastSelectedPathComponent(); 
				
				selectmsg=note.toString();
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
						}
						socket.shutdownOutput();//必须写结束标记
						
					
					
					}
					catch(Exception e1)
					{
						
					}
					
				}
			}

			
		});
		
		jTree.addMouseListener(new MouseAdapter() {
			 public void mousePressed(MouseEvent e) {
			        TreePath path = jTree.getPathForLocation(e.getX(), e.getY());  
			        if (path == null) {
			            return;
			        }
			        jTree.setSelectionPath(path);
			        if (e.getButton() == 1) {
			        	jLabe2.setText("姓名:"+selectmsg);
			        	jLabel.setText("职业:"+"医生");
			        	jLabel3.setSize(60, 60);
			        	popMenu.add(jLabel3);
			        	popMenu.add(jLabel);
			        	popMenu.add(jLabe2);
			            popMenu.show(jTree, e.getX(), e.getY());
			        }
			    
			    }
		});
		
	}
	public void send(String text,String id) {
		// TODO Auto-generated method stub
		try {
			PrintWriter printWriter=new PrintWriter(socket.getOutputStream(),true);
			
			if(id==null)//发送所有人
			{
				printWriter.println(4);
				jta.append("您对"+"对大家说:"+"\r\n"+text+"\r\n");
				printWriter.println(GUIClient.user+"对大家说:"+text);
			}else
			{
					printWriter.println(3);
					printWriter.println(id);	
					printWriter.println(text);
					printWriter.println(GUIClient.user);
			}
		
			jtf.setText("");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void accept()//不断接受
	{
		
			Listener listener=new Listener(socket);
			listener.start();
			}
}

