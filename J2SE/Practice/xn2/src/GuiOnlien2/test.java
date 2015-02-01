package GuiOnlien2;

import java.awt.Color;
import java.awt.Container;
import java.io.File;

import javax.swing.*;

public class test {
	public test(){
	     JFrame f=new JFrame("JSplitPaneDemo");
	     Container contentPane=f.getContentPane();
	     JLabel label1=new JLabel("Label 1",JLabel.CENTER);                            
	     label1.setBackground(Color.green);
	     label1.setOpaque(true);//setOpaque(ture)������Ŀ�����������ɲ�͸��������������JLabel�������õ���ɫ��ʾ������

	     JLabel label2=new JLabel("Label 2",JLabel.CENTER);                            
	     label2.setBackground(Color.pink);
	     label2.setOpaque(true);                           

	     JLabel label3=new JLabel("Label 3",JLabel.CENTER);                            
	     label3.setBackground(Color.yellow);
	     label3.setOpaque(true);     
	     /*����label1,label2��splitPane1�У������ô�splitPane1Ϊˮƽ�ָ��Ҿ���Continuous Layout��
	      *���ܡ�
	      */
	     JSplitPane splitPane1=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,false,label1,label2);
	     /*����splitPane1�ķָ���λ�ã�0.3�������splitPane1�Ĵ�С������������ֵ�ķ�Χ��0.0��1.0
	      *�С�����ʹ������ֵ������splitPane�ķָ���λ�ã����34����ʾ�����������ֵ��pixelΪ���㵥λ
	      */
	     	splitPane1.setDividerLocation(0.3);

		splitPane1.setResizeWeight(0.3);
	     /*����JSplitPane�Ƿ����չ��������(��ͬ�ļ��ܹ�һ��)����Ϊtrue��ʾ�򿪴˹��ܡ�
	      */
	     splitPane1.setOneTouchExpandable(true);
	     splitPane1.setDividerSize(10);//���÷ָ��߿�ȵĴ�С����pixelΪ���㵥λ��
	     
	     JSplitPane splitPane2=new JSplitPane(JSplitPane.VERTICAL_SPLIT,false,splitPane1,label3);
	     splitPane2.setDividerLocation(35);
	     //����JSplitPane�Ƿ����չ��������(��ͬ�ļ��ܹ�һ��),��Ϊtrue��ʾ�򿪴˹���.
	     splitPane2.setOneTouchExpandable(false);
	     splitPane2.setDividerSize(5);
	     
	     contentPane.add(splitPane2);
	     
	    f.setSize(500,500);
	    f.setVisible(true);
	}        
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test f=new test();
	}

}
