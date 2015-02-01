package Io6;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import javax.imageio.stream.FileImageInputStream;

public class ZipRW {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		test1();
			
	}

	private static void test2() throws FileNotFoundException, IOException {
		ZipInputStream zis=new ZipInputStream(new FileInputStream("Spiltzhang15"+".zip"));
		BufferedInputStream bis=new BufferedInputStream(zis);
		 ZipEntry z=zis.getNextEntry(); 
		 FileOutputStream fos=new FileOutputStream(z.getName());
		 int temp=0;
		 byte []b=new byte[1024*1024];
		 while((temp=bis.read(b))!=-1){
			 fos.write(b,0,temp);
		 }
		 fos.close();
		 zis.close();
	}

	private static void test1() throws FileNotFoundException, IOException {
		int temp=0;
		 File f=new File("total.txt");
		 FileInputStream fis=new FileInputStream(f);
		 ZipOutputStream zos=new ZipOutputStream(new FileOutputStream("we"+".zip"));
		 
		 ZipEntry ze=new ZipEntry(f.getName());
		 zos.putNextEntry(ze);
		 while((temp=fis.read())!=-1)
		 {
			 zos.write(temp);
		 }
		fis.close();
		zos.close();
	}

}
