package MyTest;
/*2013��9��24��22:47:23
 * ѧϰ��� �����¼�
 * ---|1:addmouselistener
 *    --|addmouseAdpater
 * ---|2:addkeylistener
 * 	  --|addkeyAdpater
 * 
 * ֪�����������ṩ���е�ʹ�÷��������ø���ȫ��
 * 
 * Event e:�¼��������¼��ܶ���Ϣ����������
 * 
 * Action<MOUSE AND Action<KEY
 * 
 * �������з�����
 *  ��꣺getclickcount
 *  ����: keyevent.getText(code) �õ����̵İ���  keyevent���Եõ����ּ���λ�� 
 *        e.is...�Ǹ���λ��
 *        consume������
 *        e.getcode()�ж�
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
					t.setText("���˫��");
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("��꾭��");
			}
			
		});
		
		t.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
			
				if(!(e.getKeyCode()>=KeyEvent.VK_0&&e.getKeyChar()<=KeyEvent.VK_9))
				{
					System.out.println("ֻ��������");
					e.consume();//����
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
		f=new Frame("��꣬���̣�����");
		b=new Button("����");
		t=new TextField();
		
		f.setBounds(400, 150, 500, 500);
		f.setLayout(new FlowLayout());
		f.add(b);
		f.add(t);
		
		t.setSize(300, 600);
		
		
		f.setVisible(true);
		
	}

}
