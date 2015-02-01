package Tank3;

import java.util.Vector;

//�ܷɻ�
class Tank
{
	//����ɻ��ĺ�����
	 int x=0;
	//����ɻ���������
	 int y=0;
	//����ɻ��ķ���
	 int direct=0;
	//����ɻ����ٶ�;
	 int speed=5;
	//����ɻ�����ɫ
	 int type=1;
	 //����ɻ�������
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
//������ΪҪ�˶������ԣ���Ϊһ���߳� 
class EnemyTank extends Tank implements Runnable
{
    
	
	//���˵��ӵ�
	Bullet b=null;
	//���˵��ӵ�����
	Vector<Bullet> vb=new Vector<Bullet>();
	//��¼
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
					   //�ɻ������ӵ��ٶ�Ҳ��ͬ
					    if(this.type==1)
						b=new Bullet(x+13, y+30,2,55);
					    if(this.type==2)
						b=new Bullet(x+13, y+70,2,55);
					    if(this.type==3)
						b=new Bullet(x+13, y+70,2,55);
						vb.add(b);
						Thread t=new Thread(b);//ÿ���ӵ������µ��߳�
						t.start();//������J��ʱ��ͳ�ʼ�����λ�ã�Ȼ�������̲߳����˶�
					}
					for(int i=0;i<10;i++)//��30��
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
					
					
				
					
				//�߳�����(�ɻ�)
				if(this.isLive==false)
				{
					break;
				}
			}
			
		}



}

	


//�ҵķɻ�
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
				b=new Bullet(x+10, y,0,36);
				vb.add(b);
				break;
			case 1:
				b=new Bullet(x+30, y+10,1,36);
				vb.add(b);
				break;
			case 2://����
				b=new Bullet(x+10, y+30,2,36);
				vb.add(b);
				break;
			case 3://����
				b=new Bullet(x, y+10,3,36);
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
	//�ӵ���λ��(���ŷɻ���λ��)
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
		// �ӵ��������ŷɻ���������˶�
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
					case 1://����
						x+=speed;
						break;
					case 2://����
						
						y+=speed;
						break;
					case 3://����
						x-=speed;
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

	


