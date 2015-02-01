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
       *字段-属性区
       * */
	
	private  File[] file;
	private  String[] fileFileName;
	private  String[] fileContentType;
	private  String save_avenue;
	//定义
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
	
	/*上传区*/
	@Override
	public String execute() throws Exception {
		//上传多文件
		for (int i = 0; i < getFile().length; i++) {
			//得到文件
			is=new FileInputStream(getFile()[i]);
			//保存文件
			System.out.println(fileContentType[i]);
			out=new FileOutputStream(getSave_avenue()+"//"+fileFileName[i]);
			//定义保存文件大小
			byte[] bt=new byte[1024*1024];
			//保存...
			while((len=is.read(bt))!=-1)
			{
				//第一个参数，是read所保存
				out.write(bt, 0, len);
			}
		
		}
		//关闭
		closestream();
	
		
		return super.execute();
	}
	
	//关闭区域
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
