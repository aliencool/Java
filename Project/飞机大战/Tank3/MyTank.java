package Tank3;

import java.util.Vector;

//总飞机
class Tank
{
	//定义飞机的横坐标
	 int x=0;
	//定义飞机的纵坐标
	 int y=0;
	//定义飞机的方向
	 int direct=0;
	//定义飞机的速度;
	 int speed=5;
	//定义飞机的颜色
	 int type=1;
	 //定义飞机的死亡
	 boolean isLive=true;
	public int gettype() {
		return type;
	}
	public void settype(int type) {
		this.type = type;
	}
	public int getDirect() {
		return direct;
	}
	public void setDirect(int direct) {
		this.direct = direct;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Tank(int x,int y)
	{
		this.x=x;
		this.y=y;
	}

}
//敌人因为要运动，所以，成为一个线程 
class EnemyTank extends Tank implements Runnable
{
    
	
	//敌人的子弹
	Bullet b=null;
	//敌人的子弹集合
	Vector<Bullet> vb=new Vector<Bullet>();
	//记录
	int count=0;
	
	public EnemyTank(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() 
	{
		// TODO Auto-generated method stub
		while(true)
		{
			try {
				Thread.sleep(450);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				   if(vb.size()<5)
					{
					   //飞机类型子弹速度也不同
					    if(this.type==1)
						b=new Bullet(x+13, y+30,2,55);
					    if(this.type==2)
						b=new Bullet(x+13, y+70,2,55);
					    if(this.type==3)
						b=new Bullet(x+13, y+70,2,55);
						vb.add(b);
						Thread t=new Thread(b);//每个子弹都是新的线程
						t.start();//但按下J的时候就初始化射出位置，然后，启动线程不断运动
					}
					for(int i=0;i<10;i++)//走30步
					{
						if(y<480)
						{
							y+=speed;
						}
						else
						{
							this.isLive=false;
						}
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					
				
					
				//线程死亡(飞机)
				if(this.isLive==false)
				{
					break;
				}
			}
			
		}



}

	


//我的飞机
public class MyTank extends Tank
{
	//子弹类
	Bullet b=null;
	//连发子弹
	Vector<Bullet> vb=new Vector<Bullet>();
	
	
	public MyTank(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	//子弹射出
	public void shooter()
	{
		switch(this.direct)
		{
			case 0://向上
				b=new Bullet(x+10, y,0,36);
				vb.add(b);
				break;
			case 1:
				b=new Bullet(x+30, y+10,1,36);
				vb.add(b);
				break;
			case 2://向下
				b=new Bullet(x+10, y+30,2,36);
				vb.add(b);
				break;
			case 3://向左
				b=new Bullet(x, y+10,3,36);
				vb.add(b);
				break;
			}
		Thread t=new Thread(b);//每个子弹都是新的线程
		t.start();//但按下J的时候就初始化射出位置，然后，启动线程不断运动
	}
	
	
	
	public void moveup()
	{
		y-=speed;
	}
	public void movedown()
	{
		y+=speed;
	}
	public void moveleft()
	{
		x-=speed;
	}
	public void moveright()
	{
		x+=speed;
	}
	
}

//子弹类 -|线程:为什么需要线程，因为，子弹是不断运动的
class Bullet implements Runnable
{
	//子弹的坐标
	int x;
	int y;
	//子弹的位置(随着飞机的位置)
	int direct;
	//子弹的速度
	int speed=0;
	//子弹生命
	boolean isLive=true;

	public Bullet(int x, int y, int direct, int speed) {
		super();
		this.x = x;
		this.y = y;
		this.direct = direct;
		this.speed = speed;
	}


	@Override
	public void run() {
		// 子弹不断沿着飞机射出方向运动
		// TODO Auto-generated method stub
		while(true)
		{
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				switch(this.direct)
				{
					case 0://向上
						y-=speed;
						break;
					case 1://向右
						x+=speed;
						break;
					case 2://向下
						
						y+=speed;
						break;
					case 3://向左
						x-=speed;
						break;
				}
					
				//子弹就退出循环
				if(x<0||x>500||y<0||y>500)
				{
					isLive=false;
					break;
				}
				
			}
			
			
		}
	}

class Bomb 
{
	int x;
	int y;
	int life_down=3;
	boolean isLive=true;
	public Bomb(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public void lifedown()
	{
		if(life_down>0)
		{
			life_down--;
		}
		else
		{
			isLive=false;
		}
	}
}

	


