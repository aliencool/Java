package ActionUpload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class Upload extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
      /*
       *�ֶ�-������
       * */
	
	private  File[] file;
	private  String[] fileFileName;
	private  String[] fileContentType;
	private  String save_avenue;
	//����
	private int len=0;
	private InputStream is=null;
	private OutputStream out=null;
	
	public File[] getFile() {
		return file;
	}
	public void setFile(File[] file) {
		this.file = file;
	}
	
	public String[] getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String[] fileFileName) {
		this.fileFileName = fileFileName;
	}
	
	public String[] getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String[] fileContentType) {
		this.fileContentType = fileContentType;
	}
	public String getSave_avenue() {
		return ServletActionContext.getRequest().getRealPath("/upload");
	}
	
	/*�ϴ���*/
	@Override
	public String execute() throws Exception {
		//�ϴ����ļ�
		for (int i = 0; i < getFile().length; i++) {
			//�õ��ļ�
			is=new FileInputStream(getFile()[i]);
			//�����ļ�
			System.out.println(fileContentType[i]);
			out=new FileOutputStream(getSave_avenue()+"//"+fileFileName[i]);
			//���屣���ļ���С
			byte[] bt=new byte[1024*1024];
			//����...
			while((len=is.read(bt))!=-1)
			{
				//��һ����������read������
				out.write(bt, 0, len);
			}
		
		}
		//�ر�
		closestream();
	
		
		return super.execute();
	}
	
	//�ر�����
	public void closestream()
	{
			try {
				if(is!=null)
				is.close();
				if(out!=null)
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
}
