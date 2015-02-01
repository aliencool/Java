package MyTest;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI1 extends Frame{

	private Panel p;
	private Label l;
	private String[] names={"7","8","9","+","4","5","6","-","1","2","3","*","0",".","=","/"};
	private Button[] b=new Button[16];
	/**
	 * @param args
	 * @return 
	 */
	public  GUI1(String title)
	{
		super(title);
		l=new Label();
		p=new Panel();
		
		p.setLayout(new GridLayout(4,4));
		add(l,BorderLayout.NORTH);
		add(p,BorderLayout.CENTER);
		
		
			ActionListener layout=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < b.length; i++) {
					String s = null;
					System.out.println(e);
					if(e.getSource()==b[i])
					{
						if(s!=null)
						{
								s+=names[i];
								l.setText(s);
						}
						else
						{
							s=names[i];
							l.setText(s);
						}
					}
				}
				
			}
		};
		
		
		for (int i = 0; i < b.length; i++) {
			b[i]=new Button(names[i]);
			b[i].addActionListener(layout);
			p.add(b[i]);
		}
		
	
		
	
		
	
		
		
		pack();
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GUI1("Test");
	}

}
