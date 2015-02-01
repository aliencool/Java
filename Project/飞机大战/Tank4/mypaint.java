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

/*2013年10月2日16:38:05
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
//画飞机,炸弹，子弹
class Mypanel extends JPanel implements KeyListener,Runnable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//定义在这个panel范围内的
	private MyTank mytank=null;
	//定义子弹类型
	private Bullet_type bt=null;
	//定义敌人飞机个数
	private int enemyTank_count=5;
	//把放进容器
	private Vector<EnemyTank> enemyTank=new Vector<EnemyTank>();
	//炸弹容器
	private Vector<Bomb> bomb=new Vector<Bomb>();
	//飞机素材
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
	//时间的子弹
	private int count=0;
	//子弹的效果
	private int Time_long=0;
	//随机位置
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
		//初始我的坐标	
		
		mytank=new MyTank(200, 200);
		//初始化子弹类型
		bt=new Bullet_type(random.nextInt(300)+1, random.nextInt(300)+1,true);
		bt.type=(int)(Math.random()*3)+1;
		//设置颜色
		mytank.settype(0);
		for (int i = 0; i < enemyTank_count; i++) {
		
			EnemyTank et=new EnemyTank(i*88,0);
			//敌人的飞机类型
			et.settype((int)(Math.random() * 3) + 1);
		
			
			
			Thread t=new Thread(et);
			t.start();
			
			et.setDirect(2);
			//给敌人添加第一课子弹
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
		//设置背景
		g.drawImage(img_back, 0, 0, 500, 500, this);
		
		//我的飞机
		if(mytank.isLive)
		    drawTank(mytank.getX(),mytank.getY(),g,mytank.getDirect(),mytank.gettype());
		else
			mytank.vb.removeAllElements();
		
		//敌人的飞机
		
		for (int i = 0; i < enemyTank.size(); i++) {
			EnemyTank et=enemyTank.get(i);
			
				if(enemyTank.size()<15)
				{
				if(et.isLive)
				{
					
					drawTank(et.x, et.y, g, 2, et.type);
					//每个飞机的子弹
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
					//只要当前死亡就移除死线程
					enemyTank.remove(et);
					EnemyTank en=new EnemyTank(random.nextInt(400), 0);
					//设置飞机类型
					en.settype((int)(Math.random() * 3) + 1);
					enemyTank.add(en);
					drawTank(en.x, en.y, g, 2, en.type);
					Thread tt=new Thread(en);
					tt.start();
				}
			  }
			
			
		}
		for (int i = 0; i <mytank.vb.size(); i++) {
			//获取第一颗子弹
			Bullet b=mytank.vb.get(i);
			
			
			if(b!=null&&b.isLive==true)//子弹不等空
			{
		
				g.drawImage(img_bullet, b.x, b.y, 17, 24,this);
			}
			if(!b.isLive)
			{
				mytank.vb.remove(b);
			}
		
		}
		//弹药类型给出相应处理
		shoot(g);
		
		//吃到弹药
		if(count>10)
		{
			//启动下来的子弹类型
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
				//下来飞下来的时间
				count=0;
				bt.x=random.nextInt(300)+100;
				bt.y=random.nextInt(300)+100;
				bt.type=(int)(Math.random() * 3) + 1;
				//再次复活
				bt.islive=true;
				
			}
			
		
			
			
		}
		
		
		//炸弹
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
			//炸弹切换
			b.lifedown();
			//炸弹生命为0移除
			if(b.life_down==0)
			{
				bomb.remove(b);
			}
			
		}
		
	
	}


	public void shoot(Graphics g) {
		//只能发一个一个子弹
		//发两科子弹
		if(bt.type==2)
		{
		
			Time_long++;//持续1300
			for (int i = 0; i <mytank.vb.size(); i++) {
				//获取第一颗子弹
				Bullet b=mytank.vb.get(i);
				
				
				if(b!=null&&b.isLive==true)//子弹不等空
				{
			
					g.drawImage(img_bullet, b.x, b.y, 17, 24,this);
					
				}
				if(!b.isLive)
				{
					mytank.vb.remove(b);
				}	
			
			
			}
			for (int i = 0; i <mytank.vb1.size(); i++) {
				//获取第二颗子弹
				Bullet b1=mytank.vb1.get(i);
				if(b1!=null&&b1.isLive==true)//子弹不等空
				{
			
					g.drawImage(img_bullet, b1.x+30, b1.y+30, 17, 24,this);
				}
				if(!b1.isLive)
				{
					mytank.vb1.remove(b1);
				}
		
			}
			
			//持续超过1300就回到第一发子弹
			if(Time_long>1300)
			{
				bt.type=0;
			}
		}
		else if(bt.type==3&&afoul(mytank, bt, g))//全部爆炸
		{
			for (int i = 0; i < enemyTank.size(); i++) {
				//获取敌方飞机
				EnemyTank et=enemyTank.get(i);
				et.isLive=false;
				//添加炸弹
				Bomb bb=new Bomb(et.x, et.y);
			    bomb.add(bb);
			
			}
		
			
		}
	}
	//我射中敌人的时候
	public void hitenemy() {
		for (int i = 0; i < mytank.vb.size(); i++) {
			//取出我的子弹	
			Bullet  b=mytank.vb.get(i);
			
			if(b.isLive)
			{
				//取出飞机
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
				//取出飞机
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
	
	//敌人射中我的时候
	public void hitme() {
		for (int i = 0; i < enemyTank.size(); i++) {
			//取出敌人	
			EnemyTank  em=enemyTank.get(i);
			if(em.isLive)
			{
				//取出敌人的每一个子弹
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
	
	//击中飞机
	public void deadtank(Tank t,Bullet b)
	{
		
		switch(t.direct)
		{
			case 0:
			case 2:
				if(b.x>=t.x&&b.x<=t.x+36&&b.y>=t.y&&b.y<=t.y+36)
				{
					
					//击中
					//添加炸弹
					Bomb bb=new Bomb(t.x, t.y);
					bomb.add(bb);
					//子弹消失
					b.isLive=false;
					//敌机消失
					t.isLive=false;
				
					
				
				}
				break;
			case 1:
			case 3:
				if(b.x>=t.x&&b.x<=t.x+36&&b.y>=t.y&&b.y<=t.y+36)
				{
					
					//击中
					//添加炸弹
					Bomb bb=new Bomb(t.x, t.y);
					bomb.add(bb);
					//子弹消失
					b.isLive=false;
					//飞机消失
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
					
					

					//子弹类型
					b.islive=false;
					Time_long=0;
					//碰到才画
					return true;
					
					
				
				}
				break;
			case 1:
			case 3:
				if(b.x>=t.x&&b.x<=t.x+36&&b.y>=t.y&&b.y<=t.y+36)
				{
					
					//击中
					b.islive=false;
					Time_long=0;
					return true;
					
					
				}
				break;
		}
		return false;
	
	}

	
	
	//飞机的位置，画笔，方向，类型
	public void drawTank(int x,int y,Graphics g,int direct,int type)
	{
		if(type==0)//我的飞机
		{
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
			
			//我射中敌人
			hitenemy();
			
			//敌人射中我
			hitme();
			
			count++;
			
			
			this.repaint();
		}
	}



}




