package Tank;

import java.util.Vector;

//总坦克
class Tank
{
	//定义坦克的横坐标
	 int x=0;
	//定义坦克的纵坐标
	 int y=0;
	//定义坦克的方向
	 int direct=0;
	//定义坦克的速度;
	 int speed=5;
	//定义坦克的颜色
	 int color=1;
	 //定义坦克的死亡
	 boolean isLive=true;
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
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

class EnemyTank extends Tank
{
    //敌人的子弹
	Bullet b=null;
	Vector<Bullet> ve=new Vector<Bullet>();
	
	public void shotyou()
	{
		switch(this.direct)
		{
		case 0://向上
			b=new Bullet(x+10, y,0,15);
			ve.add(b);
			break;
		case 1://向下
		
			b=new Bullet(x+10, y+30,2,15);
			ve.add(b);
			break;
		case 2://向左
			b=new Bullet(x+10, y+30,3,15);
			ve.add(b);
			break;
		case 3://向右
			b=new Bullet(x, y+10,1,15);
			ve.add(b);
			break;
		}
		//为每个敌人的子弹分配线程
		Thread t=new Thread(b);
		t.start();
	}
	
	public EnemyTank(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
}

//我的坦克
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
				b=new Bullet(x+10, y,0,15);
				vb.add(b);
				break;
			case 1:
				b=new Bullet(x+30, y+10,2,15);
				vb.add(b);
				break;
			case 2://向左
				b=new Bullet(x+10, y+30,3,15);
				vb.add(b);
				break;
			case 3://向右
				b=new Bullet(x, y+10,1,15);
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
	//子弹的位置(随着坦克的位置)
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
		// 子弹不断沿着坦克射出方向运动
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
					case 2://向下
						
						y+=speed;
						break;
					case 1://向左
						x-=speed;
						break;
					case 3://向右
						x+=speed;
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
	

	


