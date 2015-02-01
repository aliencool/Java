package MyTest;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
abstract class Test
{
	void hehe(){};
	void haha(){};
}

public class FrameTest extends Test{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame f=new Frame("Test");
	
		Button b=new Button();
		
	
		
		f.setLayout(new FlowLayout());
		f.setBounds(400, 150, 300, 300);
		f.setVisible(true);
		f.add(b);
		
		
		f.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		});
	   		
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
	}


}
