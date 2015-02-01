package MyTest;
/*2013年9月24日22:47:23
 * 学习鼠标 键盘事件
 * ---|1:addmouselistener
 *    --|addmouseAdpater
 * ---|2:addkeylistener
 * 	  --|addkeyAdpater
 * 
 * 知道适配器：提供特有的使用方法，不用覆盖全部
 * 
 * Event e:事件（包含事件很多信息）传给监听
 * 
 * Action<MOUSE AND Action<KEY
 * 
 * 几个特有方法：
 *  鼠标：getclickcount
 *  键盘: keyevent.getText(code) 得到键盘的按键  keyevent可以得到各种键盘位置 
 *        e.is...是各种位置
 *        consume是跳过
 *        e.getcode()判断
 * */
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class listener {
	
	private static Frame f;
	private static Button b;
	private static TextField t;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		init();
		myevent();
	}
	private static void myevent() {
		f.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		
		});
		
		b.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(e.getClickCount()==2)
				{
					t.setText("鼠标双击");
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("鼠标经过");
			}
			
		});
		
		t.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
			
				if(!(e.getKeyCode()>=KeyEvent.VK_0&&e.getKeyChar()<=KeyEvent.VK_9))
				{
					System.out.println("只能是数字");
					e.consume();//跳过
				}
				if(e.isControlDown()&&KeyEvent.VK_ENTER==e.getKeyCode())
				{
					System.out.println("11");
				}
			}
		});
		
		
	}
	private static void init() {
		// TODO Auto-generated method stub
		f=new Frame("鼠标，键盘，监听");
		b=new Button("测试");
		t=new TextField();
		
		f.setBounds(400, 150, 500, 500);
		f.setLayout(new FlowLayout());
		f.add(b);
		f.add(t);
		
		t.setSize(300, 600);
		
		
		f.setVisible(true);
		
	}

}
