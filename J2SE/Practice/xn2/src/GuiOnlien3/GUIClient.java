package GuiOnlien3;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import java.io.OutputStream;

import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


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
	private JMenuItem addItem;
	private JLabel jLabel=null;
	 ImageIcon image = null;
	/*����Socket
	 * */
	Socket socket; 
	
	GUIClient()
	{
		jta=new JTextArea();
		jtf=new JTextField(15);
		popMenu = new JPopupMenu();
		
		jb=new JButton("����");
		jb_send=new JButton("�����ļ�");
		jp=new JPanel();
		
		image = new ImageIcon("dltb.png");
		jLabel=new JLabel(image);
		node=new DefaultMutableTreeNode("�����û�");
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
		
		jTree.addMouseListener(new MouseAdapter() {
			 public void mousePressed(MouseEvent e) {
			        TreePath path = jTree.getPathForLocation(e.getX(), e.getY());  
			        if (path == null) {
			            return;
			        }
			        jTree.setSelectionPath(path);
			        if (e.getButton() == 1) {
			 
			        	jLabel.setText("������ѡ��Ҫ�����û����û���Ϣ��"+selectmsg);
			        	popMenu.add(jLabel);
			            popMenu.show(jTree, e.getX(), e.getY());
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
