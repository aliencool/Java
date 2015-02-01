package MyDoingWork;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/*2013年10月26日13:08:55
 * 反射:
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
		
		//读取文件
		File f=new File("config.properties");
		
		//文件不存在就创建
		if(!f.exists())f.createNewFile();
		
		
		
		//把配置文件加载进文件
		FileInputStream inStream=new FileInputStream(f);
		properties.load(inStream);
		
		//查看是否存在
			//不存在创建
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
			
			//把类文件加载进内存
			Class class1=Class.forName(class_n);
			PCI p=(PCI)class1.newInstance();
			
			m.Pci_Run(p);
			
			
			
		}
		inStream.close();
	}
}
