package MyDoingWork;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/*2013��10��26��13:08:55
 * ����:
 * */
public class Work {

	/**
	 * @param args
	 */
	public static MotherBoard m=new MotherBoard();
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		m.run();
		
		Work.write_proper("NetCard");
	}
	public  static void write_proper(String Class_Name) throws Exception
	{
		Properties properties=new Properties();
		
		//��ȡ�ļ�
		File f=new File("config.properties");
		
		//�ļ������ھʹ���
		if(!f.exists())f.createNewFile();
		
		
		
		//�������ļ����ؽ��ļ�
		FileInputStream inStream=new FileInputStream(f);
		properties.load(inStream);
		
		//�鿴�Ƿ����
			//�����ڴ���
		if(properties.getProperty("PCI1")==null)
		{
			properties.setProperty("PCI1", "MyDoingWork."+Class_Name);
			FileWriter fileWriter=new FileWriter("config.properties");
			
			properties.store(fileWriter,"Class_Name");
			fileWriter.close();
		}
		else
		{
			String class_n=properties.getProperty("PCI1");
			
			//�����ļ����ؽ��ڴ�
			Class class1=Class.forName(class_n);
			PCI p=(PCI)class1.newInstance();
			
			m.Pci_Run(p);
			
			
			
		}
		inStream.close();
	}
}
