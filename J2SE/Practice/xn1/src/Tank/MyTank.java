package Tank;

import java.util.Vector;

//��̹��
class Tank
{
	//����̹�˵ĺ�����
	 int x=0;
	//����̹�˵�������
	 int y=0;
	//����̹�˵ķ���
	 int direct=0;
	//����̹�˵��ٶ�;
	 int speed=5;
	//����̹�˵���ɫ
	 int color=1;
	 //����̹�˵�����
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
    //���˵��ӵ�
	Bullet b=null;
	Vector<Bullet> ve=new Vector<Bullet>();
	
	public void shotyou()
	{
		switch(this.direct)
		{
		case 0://����
			b=new Bullet(x+10, y,0,15);
			ve.add(b);
			break;
		case 1://����
		
			b=new Bullet(x+10, y+30,2,15);
			ve.add(b);
			break;
		case 2://����
			b=new Bullet(x+10, y+30,3,15);
			ve.add(b);
			break;
		case 3://����
			b=new Bullet(x, y+10,1,15);
			ve.add(b);
			break;
		}
		//Ϊÿ�����˵��ӵ������߳�
		Thread t=new Thread(b);
		t.start();
	}
	
	public EnemyTank(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
}

//�ҵ�̹��
public class MyTank extends Tank
{
	//�ӵ���
	Bullet b=null;
	//�����ӵ�
	Vector<Bullet> vb=new Vector<Bullet>();
	
	public MyTank(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	//�ӵ����
	public void shooter()
	{
		switch(this.direct)
		{
			case 0://����
				b=new Bullet(x+10, y,0,15);
				vb.add(b);
				break;
			case 1:
				b=new Bullet(x+30, y+10,2,15);
				vb.add(b);
				break;
			case 2://����
				b=new Bullet(x+10, y+30,3,15);
				vb.add(b);
				break;
			case 3://����
				b=new Bullet(x, y+10,1,15);
				vb.add(b);
				break;
			}
		Thread t=new Thread(b);//ÿ���ӵ������µ��߳�
		t.start();//������J��ʱ��ͳ�ʼ�����λ�ã�Ȼ�������̲߳����˶�
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

//�ӵ��� -|�߳�:Ϊʲô��Ҫ�̣߳���Ϊ���ӵ��ǲ����˶���
class Bullet implements Runnable
{
	//�ӵ�������
	int x;
	int y;
	//�ӵ���λ��(����̹�˵�λ��)
	int direct;
	//�ӵ����ٶ�
	int speed=0;
	//�ӵ�����
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
		// �ӵ���������̹����������˶�
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
					case 0://����
						y-=speed;
						break;
					case 2://����
						
						y+=speed;
						break;
					case 1://����
						x-=speed;
						break;
					case 3://����
						x+=speed;
						break;
					}
					
				//�ӵ����˳�ѭ��
				if(x<0||x>500||y<0||y>500)
				{
					isLive=false;
					break;
				}
				
			}
			
			
		}
	}
	

	


