package Tank;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;

/*2013年10月2日16:38:05
 * */
public class mypaint extends JFrame {


	/**
	 * @param args
	 */
	private Mypanel mypanel=null ;
  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mypaint m=new mypaint();

	}
	public mypaint()
	{
		mypanel=new Mypanel();
		
		Thread t=new Thread(mypanel);
		t.start();
		this.setSize(500, 500);
		this.setVisible(true);
		this.add(mypanel);
		this.addKeyListener(mypanel);
	}
}
//画飞机
class Mypanel extends JPanel implements KeyListener,Runnable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//定义在这个panel范围内的
	private MyTank mytank=null;
	//定义敌人坦克个数
	private int enemyTank_count=6;
	//把坦克放进容器
	private Vector<EnemyTank> enemyTank=new Vector<EnemyTank>();
	
	//飞机素材
	private Image img_up=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/icon36x36.png"));
	
	private Image img_down=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/down.png"));
	
	private Image img_left=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/left.png"));
	
	private Image img_right=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/right.png"));
	
	private Image img_back=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bg_02.jpg"));
	
	private Image img_bullet=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bullet.jpg"));
	
	public Mypanel()
	{
		//初始我的坐标
		mytank=new MyTank(200, 200);
		//设置颜色
		mytank.setColor(1);
		for (int i = 0; i < enemyTank_count; i++) {
			EnemyTank et=new EnemyTank((i+1)*50,0);
			et.setColor(0);
			et.setDirect(1);
			enemyTank.add(et);
		}
	}
	
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		//设置背景
		g.setColor(Color.black);
		g.drawImage(img_back, 0, 0, 500, 500, this);
		
		//我的坦克
		drawTank(mytank.getX(),mytank.getY(),g,mytank.getDirect(),mytank.getColor());
		
		//敌人的坦克
		
		for (int i = 0; i < enemyTank.size(); i++) {
			EnemyTank et=enemyTank.get(i);
			if(et.isLive)
			{
				drawTank(et.x, et.y, g, 2, et.color);
			}
		}
		
		
		//连发子弹
		for (int i = 0; i <mytank.vb.size(); i++) {
			//获取每一颗子弹
			Bullet b=mytank.vb.get(i);
			
			if(b!=null&&b.isLive==true)//子弹不等空
			{
				System.out.println(b.x);
				g.drawImage(img_bullet, b.x, b.y, 17, 24,this);
			}
			if(!b.isLive)
			{
				mytank.vb.remove(b);
			}
		
		}
		for (int i = 0; i < enemyTank.size(); i++) {
			//初始化坦克
			Bullet b=null;
			//发射子弹
			if(enemyTank.get(i).ve.size()<=5)
			enemyTank.get(i).shotyou();
			//获取子弹的发射方向和当前坦克子弹的个数
			for (int j = 0; j <enemyTank.get(i).ve.size(); j++) {
					b=enemyTank.get(i).ve.get(j);
						if(b!=null&&b.isLive==true)
						{
			
							g.drawImage(img_bullet, b.x, b.y, 16, 16,this);	
				
						}
						if(!b.isLive)
						{
							enemyTank.get(i).ve.remove(b);
						}
					
			}
				
			
			
		
		}
		
		
	}
	
	//击中坦克
	public void deadtank(Tank t,Bullet b)
	{
		
		switch(t.direct)
		{
			case 0:
			case 2:
				if(b.x>t.x&&b.x<t.x+20&&b.y>t.y&&b.y<t.y+30)
				{
					
					//击中
					//子弹消失
					b.isLive=false;
					//坦克消失
					t.isLive=false;
				}
				break;
			case 1:
			case 3:
				if(b.x>t.x&&b.x<t.x+30&&b.y>t.y&&b.y<t.y+20)
				{
					System.out.println(1);
					//击中
					//子弹消失
					b.isLive=false;
					//坦克消失
					t.isLive=false;
				}
				break;
		}
	}
	
	
	
	//坦克的位置，画笔，方向，类型
	public void drawTank(int x,int y,Graphics g,int direct,int type)
	{
		
		switch(type)
		{
		//我的坦克
		case 0:
			g.setColor(Color.RED);
			break;
			
		//敌人的坦克	
		case 1:
			g.setColor(Color.yellow);
			break;
		}
		
		switch(direct)
		{
			//向上
		case 0:
			g.drawImage(img_up, x, y, 36, 36, this);
		break;
        case 1://向左
		g.drawImage(img_right, x, y, 36, 36, this);
		break;
		case 2://向下
			g.drawImage(img_down, x, y, 36, 36, this);
		break;
		case 3://向右
			g.drawImage(img_left, x, y,36,36, this);
		break;
		}
	}


	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_UP)
		{
			
			mytank.setDirect(0);
			mytank.moveup();
		}
		else	if(e.getKeyCode()==KeyEvent.VK_DOWN)
		{
			
			mytank.setDirect(2);
			mytank.movedown();
		
		}
		else	if(e.getKeyCode()==KeyEvent.VK_LEFT)
		{
			
			mytank.setDirect(3);
			mytank.moveleft();
		}
		else	if(e.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			
			mytank.setDirect(1);
			mytank.moveright();
		}
		
		if(e.getKeyCode()==KeyEvent.VK_J)
		{
			if(mytank.vb.size()<=5)
			mytank.shooter();
		
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


	@Override
	public void run() {
		while(true)
		{
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for (int i = 0; i < mytank.vb.size(); i++) {
				//取出子弹	
				Bullet  b=mytank.vb.get(i);
				if(b.isLive)
				{
					//取出坦克
					for (int j = 0; j < enemyTank.size(); j++) {
						EnemyTank em=enemyTank.get(j);
						if(em.isLive)
						{
							this.deadtank(em, b);
						}
					}
				}
			}
			
			this.repaint();
		}
	}

}




