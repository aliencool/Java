package Test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

public class mygui extends JFrame{

	/**
	 * @param args
	 */ 
	mycolor my=null;
	public static void main(String[] args) {
		mygui g=new mygui();
		

	}
	public mygui()
	{
		my=new mycolor();
		init();
	}
	public void init()
	{
		JButton jb=new JButton("红色");
	    final JPanel jp=new JPanel();
	    JButton jb2=new JButton("蓝色");
	   
	  
		add(jb,BorderLayout.NORTH);
		add(jb2,BorderLayout.SOUTH);
		add(jp,BorderLayout.CENTER);
		
		jb.addActionListener(my);
		jb.setActionCommand("红色");
		
		jb2.addActionListener(my);
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("22");
			}
		});
		
		
		jp.setLayout(new BorderLayout());
		this.addMouseMotionListener(my);
		this.setVisible(true);
		this.setSize(500, 500);
	}

}

class mycolor implements ActionListener,MouseMotionListener
{

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("红色"))
		{
			System.out.println("1");
		}
		if(e.getActionCommand().equals("蓝色"))
		{
			System.out.println("2");
		}
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getX()+e.getY());
	}
	
}
