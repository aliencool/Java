package GuiOnlien3;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class User extends JFrame{
	public static JTextArea jta;
	public static JButton jb_login;
	public JButton jb_clear;
	private JPanel jp2;
	
	private  JLabel jl_user;
	private JLabel jl_passworld;
	private Image clear;
	private Image denglu;
	private JLabel jbl1;
	private JLabel jp2_jbl1;
	private JLabel jp2_jbl2;
	private static JTextField jp2_jtf;
	private JPasswordField jp2_jpf;
	private JPanel jbl2;
	
	/**
	 * @param args
	 */
	User()
	{
		//第一个头
		jbl1=new JLabel(new ImageIcon("background.jpg"));
		
		jp2_jbl1=new JLabel("号码",JLabel.CENTER);
		jp2_jbl2=new JLabel("密码",JLabel.CENTER);
		
		
		jp2_jtf=new JTextField();
		jp2_jpf=new JPasswordField();
		
		
		jb_login=new JButton(new ImageIcon("denglu.jpg"));
		
		
		/*
		 * 中间的!
		 * */
		jp2=new JPanel(new GridLayout(2,0));
		jp2.add(jp2_jbl1);
		jp2.add(jp2_jtf);
		jp2.add(jp2_jbl2);
		jp2.add(jp2_jpf);
		
		/*下边的
		 * */
		jbl2=new JPanel();
		jbl2.add(jb_login);
		
		this.setTitle("请设置用户名");
		
		
		this.add(jbl1,"North");
		this.add(jp2,"Center");
		this.add(jbl2,"South");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(350, 285);
			this.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final User u=new User();
		jb_login.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(jp2_jtf.getText()!=null)
				{
					GUIClient.user=jp2_jtf.getText();
					GUIClient gui=new GUIClient();
					gui.listeren();
					gui.accept();
					u.setVisible(false);
				}
			}
			
		});
		
	}

}
