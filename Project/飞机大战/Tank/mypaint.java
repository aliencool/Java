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

/*2013��10��2��16:38:05
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
//���ɻ�
class Mypanel extends JPanel implements KeyListener,Runnable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//���������panel��Χ�ڵ�
	private MyTank mytank=null;
	//�������̹�˸���
	private int enemyTank_count=6;
	//��̹�˷Ž�����
	private Vector<EnemyTank> enemyTank=new Vector<EnemyTank>();
	
	//�ɻ��ز�
	private Image img_up=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/icon36x36.png"));
	
	private Image img_down=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/down.png"));
	
	private Image img_left=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/left.png"));
	
	private Image img_right=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/right.png"));
	
	private Image img_back=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bg_02.jpg"));
	
	private Image img_bullet=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bullet.jpg"));
	
	public Mypanel()
	{
		//��ʼ�ҵ�����
		mytank=new MyTank(200, 200);
		//������ɫ
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
		//���ñ���
		g.setColor(Color.black);
		g.drawImage(img_back, 0, 0, 500, 500, this);
		
		//�ҵ�̹��
		drawTank(mytank.getX(),mytank.getY(),g,mytank.getDirect(),mytank.getColor());
		
		//���˵�̹��
		
		for (int i = 0; i < enemyTank.size(); i++) {
			EnemyTank et=enemyTank.get(i);
			if(et.isLive)
			{
				drawTank(et.x, et.y, g, 2, et.color);
			}
		}
		
		
		//�����ӵ�
		for (int i = 0; i <mytank.vb.size(); i++) {
			//��ȡÿһ���ӵ�
			Bullet b=mytank.vb.get(i);
			
			if(b!=null&&b.isLive==true)//�ӵ����ȿ�
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
			//��ʼ��̹��
			Bullet b=null;
			//�����ӵ�
			if(enemyTank.get(i).ve.size()<=5)
			enemyTank.get(i).shotyou();
			//��ȡ�ӵ��ķ��䷽��͵�ǰ̹���ӵ��ĸ���
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
	
	//����̹��
	public void deadtank(Tank t,Bullet b)
	{
		
		switch(t.direct)
		{
			case 0:
			case 2:
				if(b.x>t.x&&b.x<t.x+20&&b.y>t.y&&b.y<t.y+30)
				{
					
					//����
					//�ӵ���ʧ
					b.isLive=false;
					//̹����ʧ
					t.isLive=false;
				}
				break;
			case 1:
			case 3:
				if(b.x>t.x&&b.x<t.x+30&&b.y>t.y&&b.y<t.y+20)
				{
					System.out.println(1);
					//����
					//�ӵ���ʧ
					b.isLive=false;
					//̹����ʧ
					t.isLive=false;
				}
				break;
		}
	}
	
	
	
	//̹�˵�λ�ã����ʣ���������
	public void drawTank(int x,int y,Graphics g,int direct,int type)
	{
		
		switch(type)
		{
		//�ҵ�̹��
		case 0:
			g.setColor(Color.RED);
			break;
			
		//���˵�̹��	
		case 1:
			g.setColor(Color.yellow);
			break;
		}
		
		switch(direct)
		{
			//����
		case 0:
			g.drawImage(img_up, x, y, 36, 36, this);
		break;
        case 1://����
		g.drawImage(img_right, x, y, 36, 36, this);
		break;
		case 2://����
			g.drawImage(img_down, x, y, 36, 36, this);
		break;
		case 3://����
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
				//ȡ���ӵ�	
				Bullet  b=mytank.vb.get(i);
				if(b.isLive)
				{
					//ȡ��̹��
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




