package Test;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ActionTest extends JFrame{

	/**
	 * @param args
	 */
	private Mypanel my=new Mypanel();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ActionTest a=new ActionTest();
		
	}
	ActionTest()
	{
		this.add(my);
		this.addKeyListener(my);
		this.setSize(100,200);
		this.setVisible(true);
	}
	

}
class Mypanel extends  JPanel implements KeyListener
{
	int x=0;
	int y=0;
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.fillOval(x, y, 10, 10);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_DOWN)
		{
			++y;
		}
		if(e.getKeyCode()==KeyEvent.VK_UP)
		{
			--y;
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT)
		{
			--x;
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			++x;
		}
		this.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
