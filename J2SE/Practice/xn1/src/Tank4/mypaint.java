package Tank4;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;

/*2013��10��2��16:38:05
 * */
public class mypaint extends JFrame{


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
//���ɻ�,ը�����ӵ�
class Mypanel extends JPanel implements KeyListener,Runnable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//���������panel��Χ�ڵ�
	private MyTank mytank=null;
	//�����ӵ�����
	private Bullet_type bt=null;
	//������˷ɻ�����
	private int enemyTank_count=5;
	//�ѷŽ�����
	private Vector<EnemyTank> enemyTank=new Vector<EnemyTank>();
	//ը������
	private Vector<Bomb> bomb=new Vector<Bomb>();
	//�ɻ��ز�
	private Image img_up=null;
	
	private Image img_down=null;
	
	private Image img_enemy=null;
	
	private Image img_left=null;
	
	private Image img_right=null;
	
	private Image img_back=null;
	
	private Image img_bullet=null;
	
	private Image img_bomb1=null;	
	
	private Image img_bomb2=null;
	
	private Image img_bomb3=null;
	
	private Image img_enemybullet=null;
	
	private Image img_type_2=null;
	
	private Image img_type_3=null;
	
	private  Image Bullet_type=null;
	
	private static  Image Bullet_type2 = null;
	//ʱ����ӵ�
	private int count=0;
	//�ӵ���Ч��
	private int Time_long=0;
	//���λ��
	private	Random random=new Random();
	public Mypanel()
	{
		
		img_up=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/icon36x36.png"));
		img_down=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/down.png"));
		img_left=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/left.png"));
		img_right=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/right.png"));
		img_back=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bg_02.jpg"));
		img_bullet=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bullet.png"));
		img_bomb1=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb1.png"));
		img_bomb2=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb2.png"));
		img_bomb3=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb3.png"));
		img_enemy=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/enfly.png"));
		img_enemybullet=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/enemy_bullet.png"));
		img_type_2=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/type_2.png"));
		img_type_3=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/type_3.png"));
		Bullet_type=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/Bullet_type.png"));
		Bullet_type2=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/Bullet_type2.png"));
		//��ʼ�ҵ�����	
		
		mytank=new MyTank(200, 200);
		//��ʼ���ӵ�����
		bt=new Bullet_type(random.nextInt(300)+1, random.nextInt(300)+1,true);
		bt.type=(int)(Math.random()*3)+1;
		//������ɫ
		mytank.settype(0);
		for (int i = 0; i < enemyTank_count; i++) {
		
			EnemyTank et=new EnemyTank(i*88,0);
			//���˵ķɻ�����
			et.settype((int)(Math.random() * 3) + 1);
		
			
			
			Thread t=new Thread(et);
			t.start();
			
			et.setDirect(2);
			//��������ӵ�һ���ӵ�
			Bullet b=new Bullet(et.x+10, et.y+33, et.direct, 55);
			et.vb.add(b);
			Thread t1=new Thread(b);
			t1.start();
		
			enemyTank.add(et);
		}
	}
	
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		//���ñ���
		g.drawImage(img_back, 0, 0, 500, 500, this);
		
		//�ҵķɻ�
		if(mytank.isLive)
		    drawTank(mytank.getX(),mytank.getY(),g,mytank.getDirect(),mytank.gettype());
		else
			mytank.vb.removeAllElements();
		
		//���˵ķɻ�
		
		for (int i = 0; i < enemyTank.size(); i++) {
			EnemyTank et=enemyTank.get(i);
			
				if(enemyTank.size()<15)
				{
				if(et.isLive)
				{
					
					drawTank(et.x, et.y, g, 2, et.type);
					//ÿ���ɻ����ӵ�
					for(int j=0;j<et.vb.size();j++)
					{
						Bullet b=et.vb.get(j);
						if(b.isLive)
						{
							if(et.type==1)
							g.drawImage(img_enemybullet, b.x-3, b.y+42, 17, 26,this);	
							if(et.type==2)
							g.drawImage(img_enemybullet, b.x+13, b.y+52, 17, 26,this);
							if(et.type==3)
							g.drawImage(img_enemybullet, b.x+3, b.y+52, 17, 26,this);
						}
						else
						{
							et.vb.remove(b);
						}
					}
				}
				else
				{
					//ֻҪ��ǰ�������Ƴ����߳�
					enemyTank.remove(et);
					EnemyTank en=new EnemyTank(random.nextInt(400), 0);
					//���÷ɻ�����
					en.settype((int)(Math.random() * 3) + 1);
					enemyTank.add(en);
					drawTank(en.x, en.y, g, 2, en.type);
					Thread tt=new Thread(en);
					tt.start();
				}
			  }
			
			
		}
		for (int i = 0; i <mytank.vb.size(); i++) {
			//��ȡ��һ���ӵ�
			Bullet b=mytank.vb.get(i);
			
			
			if(b!=null&&b.isLive==true)//�ӵ����ȿ�
			{
		
				g.drawImage(img_bullet, b.x, b.y, 17, 24,this);
			}
			if(!b.isLive)
			{
				mytank.vb.remove(b);
			}
		
		}
		//��ҩ���͸�����Ӧ����
		shoot(g);
		
		//�Ե���ҩ
		if(count>10)
		{
			//�����������ӵ�����
			Thread tt=new Thread(bt);
			tt.start();
			if(bt.islive)
			{
				if(bt.type!=3)
				g.drawImage(Bullet_type, bt.x, bt.y,36,36, this);
				if(bt.type==3)
				g.drawImage(Bullet_type2, bt.x+36, bt.y+36,36,36, this);
				
				
				afoul(mytank, bt,g);
				
			}
			else
			{
				//������������ʱ��
				count=0;
				bt.x=random.nextInt(300)+100;
				bt.y=random.nextInt(300)+100;
				bt.type=(int)(Math.random() * 3) + 1;
				//�ٴθ���
				bt.islive=true;
				
			}
			
		
			
			
		}
		
		
		//ը��
		for (int i = 0; i < bomb.size(); i++) {
			Bomb b=bomb.get(i);
			
			if(b.life_down>2)
			{
				g.drawImage(img_bomb1, b.x, b.y, 30, 30,this);
			}else if(b.life_down>1)
			{
				g.drawImage(img_bomb2, b.x, b.y, 30, 30,this);
			}
			else
			{
				g.drawImage(img_bomb3, b.x, b.y, 30, 30,this);
			}
			//ը���л�
			b.lifedown();
			//ը������Ϊ0�Ƴ�
			if(b.life_down==0)
			{
				bomb.remove(b);
			}
			
		}
		
	
	}


	public void shoot(Graphics g) {
		//ֻ�ܷ�һ��һ���ӵ�
		//�������ӵ�
		if(bt.type==2)
		{
		
			Time_long++;//����1300
			for (int i = 0; i <mytank.vb.size(); i++) {
				//��ȡ��һ���ӵ�
				Bullet b=mytank.vb.get(i);
				
				
				if(b!=null&&b.isLive==true)//�ӵ����ȿ�
				{
			
					g.drawImage(img_bullet, b.x, b.y, 17, 24,this);
					
				}
				if(!b.isLive)
				{
					mytank.vb.remove(b);
				}	
			
			
			}
			for (int i = 0; i <mytank.vb1.size(); i++) {
				//��ȡ�ڶ����ӵ�
				Bullet b1=mytank.vb1.get(i);
				if(b1!=null&&b1.isLive==true)//�ӵ����ȿ�
				{
			
					g.drawImage(img_bullet, b1.x+30, b1.y+30, 17, 24,this);
				}
				if(!b1.isLive)
				{
					mytank.vb1.remove(b1);
				}
		
			}
			
			//��������1300�ͻص���һ���ӵ�
			if(Time_long>1300)
			{
				bt.type=0;
			}
		}
		else if(bt.type==3&&afoul(mytank, bt, g))//ȫ����ը
		{
			for (int i = 0; i < enemyTank.size(); i++) {
				//��ȡ�з��ɻ�
				EnemyTank et=enemyTank.get(i);
				et.isLive=false;
				//���ը��
				Bomb bb=new Bomb(et.x, et.y);
			    bomb.add(bb);
			
			}
		
			
		}
	}
	//�����е��˵�ʱ��
	public void hitenemy() {
		for (int i = 0; i < mytank.vb.size(); i++) {
			//ȡ���ҵ��ӵ�	
			Bullet  b=mytank.vb.get(i);
			
			if(b.isLive)
			{
				//ȡ���ɻ�
				for (int j = 0; j < enemyTank.size(); j++) {
					EnemyTank em=enemyTank.get(j);
					if(em.isLive)
					{
						this.deadtank(em, b);
					}
				}
			}
		
			
		}
		for (int i = 0; i < mytank.vb1.size(); i++) {
			Bullet  b1=mytank.vb1.get(i);
			if(b1.isLive)
			{
				//ȡ���ɻ�
				for (int j = 0; j < enemyTank.size(); j++) {
					EnemyTank em=enemyTank.get(j);
					if(em.isLive)
					{
						this.deadtank(em, b1);
					}
				}
			}
		}
	}
	
	//���������ҵ�ʱ��
	public void hitme() {
		for (int i = 0; i < enemyTank.size(); i++) {
			//ȡ������	
			EnemyTank  em=enemyTank.get(i);
			if(em.isLive)
			{
				//ȡ�����˵�ÿһ���ӵ�
				for (int j = 0; j < em.vb.size(); j++) {
						Bullet b=em.vb.get(j);
					if(b.isLive)
					{
						
						this.deadtank(mytank, b);
					}
				}
			}
		}
	}
	
	//���зɻ�
	public void deadtank(Tank t,Bullet b)
	{
		
		switch(t.direct)
		{
			case 0:
			case 2:
				if(b.x>=t.x&&b.x<=t.x+36&&b.y>=t.y&&b.y<=t.y+36)
				{
					
					//����
					//���ը��
					Bomb bb=new Bomb(t.x, t.y);
					bomb.add(bb);
					//�ӵ���ʧ
					b.isLive=false;
					//�л���ʧ
					t.isLive=false;
				
					
				
				}
				break;
			case 1:
			case 3:
				if(b.x>=t.x&&b.x<=t.x+36&&b.y>=t.y&&b.y<=t.y+36)
				{
					
					//����
					//���ը��
					Bomb bb=new Bomb(t.x, t.y);
					bomb.add(bb);
					//�ӵ���ʧ
					b.isLive=false;
					//�ɻ���ʧ
					t.isLive=false;
				}
				break;
		}
	}
	
	public boolean afoul(Tank t,Bullet_type b, Graphics g)
	{
		
		switch(t.direct)
		{
			case 0:
			case 2:
				if(b.x>=t.x&&b.x<=t.x+36&&b.y>=t.y&&b.y<=t.y+36)
				{
					
					

					//�ӵ�����
					b.islive=false;
					Time_long=0;
					//�����Ż�
					return true;
					
					
				
				}
				break;
			case 1:
			case 3:
				if(b.x>=t.x&&b.x<=t.x+36&&b.y>=t.y&&b.y<=t.y+36)
				{
					
					//����
					b.islive=false;
					Time_long=0;
					return true;
					
					
				}
				break;
		}
		return false;
	
	}

	
	
	//�ɻ���λ�ã����ʣ���������
	public void drawTank(int x,int y,Graphics g,int direct,int type)
	{
		if(type==0)//�ҵķɻ�
		{
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
		else
		{
			if(type==1)
			{
				g.drawImage(img_enemy, x, y,36,36,this);
			}
			if(type==2)
			{
				g.drawImage(img_type_2,x,y,72,72,this);
			}
			if(type==3)
			{
				g.drawImage(img_type_3,x,y,72,72,this);
			}
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
			
			//�����е���
			hitenemy();
			
			//����������
			hitme();
			
			count++;
			
			
			this.repaint();
		}
	}



}




