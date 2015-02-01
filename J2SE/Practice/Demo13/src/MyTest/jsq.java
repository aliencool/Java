package MyTest;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class jsq {
	
	private static Frame f;
	private static Button []b;
	private static String [] name ={"7","8","9","+","4","5","6","-","1","2","3","*","0",".","=","/"};
	private static TextField t;
	private static Panel p;
	private static ActionListener al;
	private static String msg;
	/**
	 * @param args
	 */
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		init();
		myevent();
		
		
		
	}
	private static  void myevent() {
		f.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
			
				System.exit(0);
			}
			
		
		});

	
		
	
		
	}
	private static  void init() {
		// TODO Auto-generated method stub
		f=new Frame("Êó±ê£¬¼üÅÌ£¬¼àÌý");
		b=new Button[16];
		t=new TextField();
		p=new Panel();
		
		p.setLayout(new GridLayout(4,4));
		for (int i = 0; i < b.length; i++) {
			b[i]=new Button(name[i]);
			b[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(msg==null)
					{
						msg=e.getActionCommand();
						t.setText(msg);
					}
					else
					{
						
					
						if(e.getActionCommand()=="=")
						{
								if(msg.contains("+"))
								{
									String []m=msg.split("\\+");
				
									int sum=Integer.parseInt(m[0])+Integer.parseInt(m[1]);
									
									t.setText(String.valueOf(sum));
									msg=String.valueOf(sum);
								
								}
								if(msg.contains("-"))
								{
									String []m=msg.split("\\-");
				
									int sum=Integer.parseInt(m[0])-Integer.parseInt(m[1]);
									
									t.setText(String.valueOf(sum));
									msg=String.valueOf(sum);
								}
								if(msg.contains("*"))
								{
									String []m=msg.split("\\*");
				
									int sum=Integer.parseInt(m[0])*Integer.parseInt(m[1]);
									
									t.setText(String.valueOf(sum));
									msg=String.valueOf(sum);
								}
								if(msg.contains("/"))
								{
									String []m=msg.split("/");
				
									int sum=Integer.parseInt(m[0])/Integer.parseInt(m[1]);
									
									t.setText(String.valueOf(sum));
									msg=String.valueOf(sum);
								}
						}
						else
						{
						  msg+=e.getActionCommand();
						  t.setText(msg);
						
						}
					}
				
				}
			});
			p.add(b[i]);
		}
		f.add(t,BorderLayout.NORTH);
		f.add(p,BorderLayout.CENTER);
	
		f.pack();
		f.setVisible(true);
	}
}
